package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By currencyLink=By.xpath("//span[contains(text(),'Currency')]");
    By dropDownLink=By.xpath("//ul[@class = 'dropdown-menu']/li");
    By accountOptionsList=By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");
    By myAccountLink=By.xpath("//span[contains(text(),'My Account')]");
    By headingText=By.xpath("//div[@id='content']//h1");
    By loginHeading=By.xpath("//h2[contains(text(),'Returning Customer')]");
    By logOutMessage=By.xpath("//h1[contains(text(),'Account Logout')]");
    public void changeCurrency(String text){
        clickOnElement(currencyLink);
        selectByContainsTextFromListOfElements(dropDownLink,text);
    }
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(accountOptionsList);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(accountOptionsList);
        }
    }
    public void clickOnMyAccount(){
        clickOnElement(myAccountLink);
    }
    public String getHeadingText(){
        return getTextFromElement(headingText);
    }
    public String getLoginHeadingText(){
        return getTextFromElement(loginHeading);
    }
    public String getLogoutMessage(){
        return getTextFromElement(logOutMessage);
    }
}
