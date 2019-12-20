package libs;

import annotations.PageEntry;
import com.google.common.reflect.ClassPath;
import exceptions.AutotestError;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;

public class PageFactory {
    private static final Logger LOG = LoggerFactory.getLogger(PageFactory.class);
    private final String pagesPackage;
    private String currentPageTitle;
    private AllPage currentPage;

    public PageFactory(String pagePackage) {
        this.pagesPackage = pagePackage;
    }



    public AllPage getPage(String title) throws Exception {
        if (null == this.currentPage || !this.currentPageTitle.equals(title)) {
            try {
                if(null != this.currentPage) {
                    LOG.info("Я тут на 29 строке фабрики");
                    this.currentPage = this.getPage(this.currentPage.getClass().getPackage().getName(), title);
                    LOG.info("Прошел 29 строку");
                }

                if (null == this.currentPage) {
                    this.currentPage = this.getPage(this.pagesPackage, title);
                }

                if (null == this.currentPage) {
                    throw new AutotestError("Нет пейдж обжекта");
                }
            } catch (Exception ex) {
                throw new Exception("Страница не инициализирована", ex);
            }
        }
        return this.currentPage;
    }

    public AllPage getPage(Class<? extends AllPage> page) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return this.bootstrapPage(page);
    }

    public AllPage getPage(String packageName, String title) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return this.bootstrapPage(this.getPageClass(packageName, title));
    }

    private Class<?> getPageClass(String packageName, String title) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final HashSet allClasses = new HashSet();

        try {
            ClassPath.from(loader).getAllClasses().stream().filter((info) -> {
                return info.getName().startsWith(packageName + ".");
            }).forEach((info) -> {
                allClasses.add(info.load());
            });
        } catch (Exception ex) {
            LOG.warn("Failed to shape class info set", ex);
        }

        Iterator var5 = allClasses.iterator();

        Class page;
        String pageTitle;

        do{
            if(!var5.hasNext()) {
                return null;
            }

            page = (Class)var5.next();
            pageTitle = null;
            if(null != page.getAnnotation(PageEntry.class)) {
                pageTitle = ((PageEntry)page.getAnnotation(PageEntry.class)).title();
            } else {
                try {
                    pageTitle = (String) FieldUtils.readStaticField(page, "title", true);
                } catch (Exception ex){
                    LOG.debug("Failed to read {} because it is not page object");
                }
            }
        } while (pageTitle == null || !pageTitle.equals(title));

        return page;
    }

    public AllPage bootstrapPage (Class<?> page) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IllegalArgumentException {
        if(page != null) {
            Constructor<AllPage> constructor = (Constructor<AllPage>) page.getConstructor();
            constructor.setAccessible(true);
            this.currentPage = (AllPage) constructor.newInstance();
            this.currentPageTitle = this.currentPage.getTitle();
            return this.currentPage;
        } else {
            return null;
        }
    }




}
