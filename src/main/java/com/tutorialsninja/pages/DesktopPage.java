package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    By listLink = By.xpath("//h4/a");
    By dropDownLink = By.id("input-sort");
    By hpLink = By.xpath("//a[contains(text(),'HP LP3065')]");
    By nameHeadingLink = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By dateButton = By.xpath("//div[@class = 'input-group date']//button");
    By nextButton = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By monthYear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By allDate = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");

    public void selectFromDropDown(String value) {
        selectByVisibleTextFromDropDown(dropDownLink, value);
    }

    public List getList() {
        List<WebElement> list = driver.findElements(listLink);
        List<String> orignalList = new ArrayList<>();
        for (WebElement e : list) {
            orignalList.add(e.getText());
        }
        return orignalList;
    }

    public void clickOnHP() {
        clickOnElement(hpLink);
    }

    public String getHeadingName() {
        return getTextFromElement(nameHeadingLink);
    }

    public void selectDate(String date, String month, String year) {
        clickOnElement(dateButton);
        while (true) {
            String monthAndYear = driver.findElement(monthYear).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = driver.findElements(allDate);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCartButton);
    }

    public String getSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickShoppingCart() {
        clickOnElement(shoppingCartLink);
    }
}
