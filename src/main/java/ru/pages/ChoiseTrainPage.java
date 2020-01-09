package ru.pages;

import annotations.ElementTitle;
import annotations.PageEntry;
import libs.AllPage;
import libs.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@PageEntry(title ="Выбор поезда")
public class ChoiseTrainPage extends AllPage {

    @FindBy(xpath = "//*[contains(@class, 'container train-card')]")
    @ElementTitle(value = "Плитка выбора поезда")
    private WebElement trainChoiseBtn;

    public ChoiseTrainPage() {
        PageFactory.initElements(Init.getWebDriver(), this);
        findElement("Плитка выбора поезда");
    }

    public void actionClick() {
        Init.getWait().until(ExpectedConditions.visibilityOfAllElements(trainChoiseBtn));
        Actions builder = new Actions(Init.getWebDriver());
        builder.moveToElement(trainChoiseBtn).click(trainChoiseBtn);
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }

    public WebElement selectLastTrain() {
        Init.getWait().until(ExpectedConditions.visibilityOfAllElements(trainChoiseBtn));
        List<WebElement> trainList  = Init.getWebDriver().findElements(By.xpath("//*[contains(@class, 'container train-card')]"));
        return trainList.get(trainList.size()-1);
    }

    public void userOnPage(){
        findElement("Плитка выбора поезда");
    }
}
