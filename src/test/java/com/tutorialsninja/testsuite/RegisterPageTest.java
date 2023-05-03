package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("prime" + getAlphaNumericString(5));
        registerPage.enterLastName("test" + getAlphaNumericString(5));
        registerPage.enterEmail("prime" + getAlphaNumericString(5) + "@gmail.com");
        registerPage.enterPhoneNumber("07988112233");
        registerPage.enterPassword("test1234");
        registerPage.enterConfirmPassword("test1234");
        registerPage.selectSubscribe("Yes");
        registerPage.clickOnPrivacyPolicy();
        registerPage.clickOnContinueButton();
        Assert.assertEquals(registerPage.getSuccessMessage(),"Your Account Has Been Created!","Registration is not successful");
        registerPage.clickOnContinue();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getLogoutMessage(),"Account Logout","Log out not done");
        registerPage.clickOnContinue();
    }
}
