package ru.pages;

import annotations.ElementTitle;
import annotations.PageEntry;
import libs.AllPage;
import libs.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Calendar;
import java.util.List;

@PageEntry(title ="Выбор места")
public class ChoiseTrainSeatsPage extends AllPage {

    @FindBy(xpath = "//rzd-select-car//*[contains(@class, 'swiper-slide ng-star-inserted')]")
    @ElementTitle(value = "Выбор вагона")
    private WebElement railwayСarriageChoiseBtn;

    @FindBy(xpath = "//*[contains(@class, 'seat_available seat_secondary')]")
    @ElementTitle(value = "Выбор свободного места")
    private WebElement seatChoiseBtn;

    @FindBy(xpath = "//*[@type=\"terminal\"]//*[contains(text(), 'ПРОДОЛЖИТЬ')]/ancestor::button")
    @ElementTitle(value = "Кнопка продолжить")
    private WebElement nextBtn;

    public ChoiseTrainSeatsPage() {
        PageFactory.initElements(Init.getWebDriver(), this);
        findElement("Выбор вагона");
    }

    public void selectFreeSpaceSeat() {

        Init.getWait().until(ExpectedConditions.visibilityOfAllElements(seatChoiseBtn));
        List<WebElement> freeSeats = Init.getWebDriver().findElements(this.getXpathFindBy("Выбор свободного места"));

        long deadline = Calendar.getInstance().getTimeInMillis() + (Init.getTimeOut() * 1000);
        while (deadline > Calendar.getInstance().getTimeInMillis()) {
            if (freeSeats.get(0).isDisplayed()) {
                this.clickButton("Выбор свободного места");
            } else {
                this.clickButton("Выбор вагона");
            }
        }
    }
}
