package ru.pages;

import annotations.ElementTitle;
import annotations.PageEntry;
import libs.AllPage;
import libs.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(title ="Выбор типа купе")
public class ChoiseTrainServisePage extends AllPage {

    @FindBy(xpath = "//*[contains(text(), \"Плацкарт\")]/ancestor::*[@class=\"class-card\"]//button")
    @ElementTitle(value = "Кнопка выбора плацкарта")
    private WebElement plackartChoiseBtn;

    @FindBy(xpath = "//*[contains(text(), \"Купе\")]/ancestor::*[@class=\"class-card\"]//button")
    @ElementTitle(value = "Кнопка выбора купе")
    private WebElement coupeChoiseBtn;

    @FindBy(xpath = "//button[contains(text(), 'Выбрать')]")
    @ElementTitle(value = "Кнопка выбрать")
    private WebElement сhoiseBtn;

    public ChoiseTrainServisePage() {
        PageFactory.initElements(Init.getWebDriver(), this);
        findElement("Кнопка выбрать");
    }

    public void userOnPage() {
        findElement("Кнопка выбрать");
        System.out.println("Я на странице выбора поезда");
    }
}
