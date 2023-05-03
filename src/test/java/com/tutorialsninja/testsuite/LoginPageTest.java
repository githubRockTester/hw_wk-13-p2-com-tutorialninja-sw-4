package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    RegisterPage registerPage=new RegisterPage();
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmail("prime12345@gmail.com");
        loginPage.enterPassword("test1234");
        loginPage.clickLoginButton();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");

    }
}
