package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.pages.TopMenu;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class DesktopTest extends BaseTest {
    TopMenu topMenu=new TopMenu();
    DesktopPage desktopPage=new DesktopPage();
    HomePage homePage=new HomePage();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        topMenu.mouseHoverAndClickOnDesktops();
        topMenu.selectMenu("Show AllDesktops");
        Thread.sleep(1000);
        List<String> expectedList=desktopPage.getList();
        Collections.reverse(expectedList);
        desktopPage.selectFromDropDown("Name (Z - A)");
        Thread.sleep(1000);
        List<String>actualList=desktopPage.getList();
        Assert.assertEquals(expectedList,actualList,"Products not displayed Z to A order");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.changeCurrency("£Pound Sterling");
        topMenu.mouseHoverAndClickOnDesktops();
        topMenu.selectMenu("Show AllDesktops");
        desktopPage.selectFromDropDown("Name (A - Z)");
        desktopPage.clickOnHP();
        Assert.assertEquals(desktopPage.getHeadingName(),"HP LP3065","Product not displayed");
        desktopPage.selectDate("30","November","2023");
        desktopPage.clickOnAddToCart();
        Assert.assertTrue(desktopPage.getSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"), "Product not added to cart");
        desktopPage.clickShoppingCart();
        Assert.assertTrue(shoppingCartPage.getHeading().contains("Shopping Cart"),"Cart not displayed");
        Assert.assertEquals(shoppingCartPage.getProductName(),"HP LP3065","Product is not correct");
        Assert.assertTrue(shoppingCartPage.getDate().contains("2023-11-30"),"Date is not matching");
        Assert.assertEquals(shoppingCartPage.getModelName(),"Product 21","Product not matched");
        Assert.assertEquals(shoppingCartPage.getTotal(),"£74.73","Price is not correct");
    }
}
