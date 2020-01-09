package ru.pages;

import annotations.ElementTitle;
import annotations.PageEntry;
import libs.AllPage;
import libs.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(title ="Выбор пассажира")
public class ChoisePassenegerPage extends AllPage {

    @FindBy(xpath = "//*[contains(text(), 'Выбрать пассажира')]/ancestor::rzd-select")
    @ElementTitle(value = "Вырать пассажира")
    private WebElement selectPassengerBtn;

    @FindBy(xpath = "//rzd-option//*[@class=\"option\"]")
    @ElementTitle(value = "Пассажир")
    private WebElement passengerBtn;

    @FindBy(xpath = "//*[contains(text(), 'К ОБРАТНОЙ ПОЕЗДКЕ')]/ancestor::button")
    @ElementTitle(value = "К обратной поездке")
    private WebElement returnTripBtn;

    public ChoisePassenegerPage() {
        PageFactory.initElements(Init.getWebDriver(), this);
        findElement("Вырать пассажира");
    }


}
