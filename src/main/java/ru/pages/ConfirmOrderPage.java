package ru.pages;

import annotations.ElementTitle;
import libs.AllPage;
import libs.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrderPage extends AllPage {

    @FindBy(xpath = "//button[span[contains(text(), 'Оформить заказ')]]")
    @ElementTitle(value = "Оформить заказ")
    private WebElement trainChoiseBtn;

    public ConfirmOrderPage() {
        PageFactory.initElements(Init.getWebDriver(), this);
        findElement("Оформить заказ");
    }
}
