package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShoppingCartPage extends Utility {
   By cartHeading=By.xpath("//div[@id='content']//h1");
   By productNameLink=By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
   By dateLink=By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
   By modelNameLink=By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
   By totalLink=By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By quantityLink=By.xpath("//input[contains(@name, 'quantity')]");
    By updateLink=By.xpath("//button[contains(@data-original-title, 'Update')]");
    By successMessageLink=By.xpath("//div[@id='checkout-cart']/div[1]");

    public String getHeading(){
       return getTextFromElement(cartHeading);
   }
    public String getProductName(){
        return getTextFromElement(productNameLink);
    }
    public String getDate(){
        return getTextFromElement(dateLink);
    }
    public String getModelName(){
        return getTextFromElement(modelNameLink);
    }
    public String getTotal(){
        return getTextFromElement(totalLink);
    }
    public void changeQuantity(String quantity){
        driver.findElement(quantityLink).sendKeys(Keys.BACK_SPACE);
        sendTextToElement(quantityLink,quantity);
    }
    public void clickOnUpdate(){
        clickOnElement(updateLink);
    }
    public String getSuccessMessage(){
        return getTextFromElement(successMessageLink);
    }
}
