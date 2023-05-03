package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenu extends Utility {
    By topMenuLink=By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopLink=By.linkText("Desktops");
    By laptopAndNotebookLink=By.linkText("Laptops & Notebooks");
    By componentsLink=By.linkText("Components");
    By heading=By.xpath("//h2");
    By laptopLink=By.linkText("Laptops & Notebooks");
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = getListOfElements(topMenuLink);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(topMenuLink);
        }
    }
    public void mouseHoverAndClickOnDesktops(){
        mouseHoverToElementAndClick(desktopLink);
    }
    public String getHeadingText(){
        return getTextFromElement(heading);
    }
    public void mouseHoverAndClickOnLaptopsAndNotebook(){
        mouseHoverToElementAndClick(laptopAndNotebookLink);
    }
    public void mouseHoverAndClickOnComponents(){
        mouseHoverToElementAndClick(componentsLink);
    }
}
