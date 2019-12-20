package libs;

import com.google.common.reflect.ClassPath;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;

import static java.awt.SystemColor.info;



public class Init {

    private Integer timeout;
    private static final Logger LOG = LoggerFactory.getLogger(Init.class);
    private static WebDriver webDriver;
    private static PageFactory pageFactory;
    private static final String pagesPackage = "ru.pages";
    private static WebDriverWait wait;


    //@Before
    public static void startWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/ChromeDriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 15);
    }

    //@After
    public static void closeWebDriver() {
        webDriver.quit();
    }

    public static int getTimeOut() {

        return 111;
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

    public static String getPagePackage() {
        return pagesPackage;
    }

    public static WebDriverWait getWait(){
        return wait;
    }

}
