package ru.pages;

import libs.AllPage;
import annotations.ElementTitle;
import libs.Init;
import annotations.PageEntry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PageEntry(title = "Главная страница")
public class TicketRZDMainPage extends AllPage {

    private static final Logger LOG = LoggerFactory.getLogger(TicketRZDMainPage.class);

    @FindBy(xpath = "//*[@gtmclassname=\"gtm-header-login\"]")
    @ElementTitle(value = "Кнопка логина(ключик)")
    public WebDriver headerLoginBtn;

    @FindBy(xpath = "//*[@placeholder=\"Логин\"]")
    @ElementTitle(value = "Поле логин")
    public WebDriver loginField;

    @FindBy(xpath = "//*[@placeholder=\"Пароль\"]")
    @ElementTitle(value = "Поле пароль")
    public WebDriver passwordField;

    @FindBy(xpath = "//*[@gtmclassname=\"gtm-login\"]")
    @ElementTitle(value = "Кнопка войти")
    public WebDriver enterBtn;

    @FindBy(xpath = "//*[@class=\"sidenav__user-name\"]")
    @ElementTitle(value = "Имя пользователя")
    public WebDriver userName;

    public void userIsAuthorized(String userName) {
        if(findElement("Имя пользователя").getText().equals(userName)) {
            LOG.info("Пользователь" + userName + " авторизован!");
        }
        //throw new AssertionError("Пользователь НЕ авторизован!!!");
    }

    public TicketRZDMainPage() {
        PageFactory.initElements(Init.getWebDriver(), this);
        findElement("Кнопка логина(ключик)");
    }

    public void userOnPage() {
        waitForWindow();
        findElement("Кнопка логина(ключик)");
    }

}
