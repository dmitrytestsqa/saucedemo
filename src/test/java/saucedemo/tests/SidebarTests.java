package saucedemo.tests;

import org.junit.Assert;
import org.junit.Test;
import saucedemo.data.UserData;
import saucedemo.pages.HomePage;
import saucedemo.pages.LoginPage;
import saucedemo.webdriverinit.WebDriverInit;

public class SidebarTests extends WebDriverInit {

  @Test
  public void allItemsLink() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSideBarButton();
    homePage.clickAllItemsButton();
    Assert.assertEquals(6, homePage.getitemsSuiteInt());
  }

  @Test
  public void aboutLink() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSideBarButton();
    homePage.clickAboutButton();
    Assert.assertEquals("https://saucelabs.com/", homePage.getCurrentURL());
  }

  @Test
  public void logoutLink() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSideBarButton();
    homePage.clickLogoutButton();
    Assert.assertTrue(loginPage.loginButtonIsDisplayed());
  }
}