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

    @FindBy(xpath = "//*[@placeholder=\"Откуда\"]")
    @ElementTitle(value = "Откуда")
    public WebDriver byTicketFrom;

    @FindBy(xpath = "//*[@placeholder=\"Куда\"]")
    @ElementTitle(value = "Куда")
    public WebDriver buyTicketTo;

    @FindBy(xpath = "//*[@placeholder=\"Туда\"]")
    @ElementTitle(value = "Туда")
    public WebDriver buyTicketFromDate;

    @FindBy(xpath = "//*[@placeholder=\"Обратно\"]")
    @ElementTitle(value = "Обратно")
    public WebDriver buyTicketBackDate;

    @FindBy(xpath = "//button[span/span[contains(text(), 'Найти')]]")
    @ElementTitle(value = "Кнопка найти")
    public WebDriver findBtn;

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

    public void autorization(String login, String password) {
        userOnPage();
        clickButton("Кнопка логина(ключик)");
        sendKeys("Поле логин", "kakoito123");
        sendKeys("Поле пароль", "123456");
        clickButton("Кнопка войти");
        userIsAuthorized("Какой-то Какойтович");
    }

}
