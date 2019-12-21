package libs;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Init {

    private static WebDriver webDriver;
    private static PageFactory pageFactory;
    private static final String pagesPackage = "ru.pages";
    private static WebDriverWait wait;
    private static int timeout = 10;


    //@Before
    public static void startWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/ChromeDriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, timeout);
        webDriver.manage().window().maximize();
    }

    //@After
    public static void closeWebDriver() {
        webDriver.quit();
    }

    public static int getTimeOut() {
        return timeout;
    }

    public static void openStartUpPage(String url) {
        startWebDriver();
        webDriver.get(url);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static libs.PageFactory getPageFactory() {
        if(pageFactory == null) {
            pageFactory = new PageFactory(getPagePackage());
        }
        return pageFactory;
    }

    public static String getCurrentDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("d.MM.yyyy");
        return formatForDateNow.format(dateNow);
    }

    public static String getCurrentDate(int days) {
        Date dateNow = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(dateNow);
        instance.add(Calendar.DAY_OF_MONTH, days);
        Date newDate = instance.getTime();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(newDate);
    }

    public static String getPagePackage() {
        return pagesPackage;
    }

    public static WebDriverWait getWait(){
        return wait;
    }

}
