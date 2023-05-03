package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookTest extends BaseTest {
    TopMenu topMenu = new TopMenu();
    LaptopAndNotebookPage laptopAndNotebookPage = new LaptopAndNotebookPage();
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        topMenu.mouseHoverAndClickOnLaptopsAndNotebook();
        topMenu.selectMenu("Show AllLaptops & Notebooks");
        List<String> expectedList = laptopAndNotebookPage.getList();
        Collections.sort(expectedList, Collections.reverseOrder());
        laptopAndNotebookPage.selectFromDropDown("Price (High > Low)");
        List<String> actualList = laptopAndNotebookPage.getList();
        Assert.assertEquals(expectedList, actualList, "Products not displayed high to low order");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        homePage.changeCurrency("£Pound Sterling");
        topMenu.mouseHoverAndClickOnDesktops();
        topMenu.mouseHoverAndClickOnLaptopsAndNotebook();
        topMenu.selectMenu("Show AllLaptops & Notebooks");
        laptopAndNotebookPage.selectFromDropDown("Price (High > Low)");
        laptopAndNotebookPage.clickOnMacBook();
        Assert.assertEquals(laptopAndNotebookPage.getHeadingName(), "MacBook", "Product selected is correct");
        laptopAndNotebookPage.clickOnAddToCart();
        Assert.assertTrue(desktopPage.getSuccessMessage().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        desktopPage.clickShoppingCart();
        Assert.assertTrue(shoppingCartPage.getHeading().contains("Shopping Cart"), "Cart not displayed");
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product is not correct");
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.clickOnUpdate();
        Assert.assertTrue(shoppingCartPage.getSuccessMessage().contains("Success: You have modified your shopping cart!"), "Card is not updated");
        Assert.assertEquals(shoppingCartPage.getTotal(), "£737.45", "Price is not correct");
    }
}
