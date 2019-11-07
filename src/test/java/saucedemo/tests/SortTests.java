package saucedemo.tests;

import org.junit.Assert;
import org.junit.Test;
import saucedemo.data.UserData;
import saucedemo.webdriverinit.WebDriverInit;
import saucedemo.pages.HomePage;
import saucedemo.pages.LoginPage;

public class SortTests extends WebDriverInit {

  @Test
  public void nameAtoZ() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSortContainerAtoZButton();
    Assert.assertEquals(homePage.getItemsSuiteString(), homePage.notSortedItemList());
  }

  @Test
  public void nameZtoA() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSortContainerZtoAButton();
    Assert.assertEquals(homePage.getItemsSuiteString(), homePage.sortListZToA());
  }

  @Test
  public void priceLowToHigh() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickPriceLowToHighButton();
    Assert.assertEquals(homePage.getPriceItemsFromPage(), homePage.sortPriceLowToHigh());
  }

  @Test
  public void priceHighToLow() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickPriceHighToLowButton();
    Assert.assertEquals(homePage.getPriceItemsFromPage(), homePage.sortPriceHighToLow());
  }
}
