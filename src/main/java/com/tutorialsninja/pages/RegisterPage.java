package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By firstNameLink=By.id("input-firstname");
    By lastNameLink=By.id("input-lastname");
    By emailLink=By.id("input-email");
    By telephoneLink=By.id("input-telephone");
    By passwordLink=By.id("input-password");
    By confirmPasswordLink=By.id("input-confirm");
    By subScribeLink=By.xpath("//fieldset[3]//input");
    By privacyPolicyLink=By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueButtonLink=By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By successMessageLink=By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueLink=By.xpath("//a[contains(text(),'Continue')]");
    public void enterFirstName(String name){
        sendTextToElement(firstNameLink,name);
    }
    public void enterLastName(String name){
        sendTextToElement(lastNameLink,name);
    }
    public void enterEmail(String email){
        sendTextToElement(emailLink,email);
    }
    public void enterPhoneNumber(String number){
        sendTextToElement(telephoneLink,number);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordLink,password);
    }
    public void enterConfirmPassword(String password){
        sendTextToElement(confirmPasswordLink,password);
    }
    public void selectSubscribe(String value){
        selectByContainsTextFromListOfElements(subScribeLink,value);
    }
    public void clickOnPrivacyPolicy(){
        clickOnElement(privacyPolicyLink);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButtonLink);
    }
    public String getSuccessMessage(){
        return getTextFromElement(successMessageLink);
    }
    public void clickOnContinue(){
        clickOnElement(continueLink);
    }
}
