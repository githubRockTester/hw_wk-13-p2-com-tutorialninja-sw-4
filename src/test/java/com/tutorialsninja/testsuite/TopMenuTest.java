package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.TopMenu;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    TopMenu topMenu=new TopMenu();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        topMenu.mouseHoverAndClickOnDesktops();
        topMenu.selectMenu("Show AllDesktops");
        Assert.assertEquals(topMenu.getHeadingText(),"Desktops","Navigation not successful");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        topMenu.mouseHoverAndClickOnLaptopsAndNotebook();
        topMenu.selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(topMenu.getHeadingText(),"Laptops & Notebooks","Navigation not successful");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        topMenu.mouseHoverAndClickOnComponents();
        topMenu.selectMenu("Show AllComponents");
        Assert.assertEquals(topMenu.getHeadingText(),"Components","Navigation not successful");
    }
}
