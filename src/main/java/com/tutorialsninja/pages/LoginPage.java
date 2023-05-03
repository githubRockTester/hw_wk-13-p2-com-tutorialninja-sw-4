package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By emailLink=By.id("input-email");
    By passwordLink=By.id("input-password");
    By loginButton=By.xpath("//form[contains(@action,'login')]//input[@type='submit']");
    public void enterEmail(String email){
        sendTextToElement(emailLink,email);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordLink,password);
    }
    public void clickLoginButton(){
        clickOnElement(loginButton);
    }
}
