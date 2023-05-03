package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNotebookPage extends Utility {
    By productLink=By.xpath("//p[@class ='price']");
    By dropDownLink=By.id("input-sort");
    By macBookLink=By.linkText("MacBook");
    By nameHeadingLink=By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCartButton=By.xpath("//button[@id='button-cart']");
    public void selectFromDropDown(String value){
        selectByVisibleTextFromDropDown(dropDownLink,value);
    }
    public List getList(){
        List<WebElement> products = driver.findElements(productLink);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }return originalProductsPrice;
    }
    public void clickOnMacBook(){
        clickOnElement(macBookLink);
    }
    public String getHeadingName(){
        return getTextFromElement(nameHeadingLink);
    }
    public void clickOnAddToCart(){
        clickOnElement(addToCartButton);
    }
}
