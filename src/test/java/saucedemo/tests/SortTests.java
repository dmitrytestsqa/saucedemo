package saucedemo.tests;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import saucedemo.data.UserData;
import saucedemo.webdriverinit.WebDriverInit;
import saucedemo.pages.HomePage;
import saucedemo.pages.LoginPage;

public class SortTests extends WebDriverInit {

  @Test
  @Description(value = "Test sorts product items from A to Z by alphabetic")
  public void nameAtoZ() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSortContainerAtoZButton();
    Assert.assertEquals(homePage.getItemsSuiteString(), homePage.notSortedItemList());
  }

  @Test
  @Description(value = "Test sorts product items from Z to A by alphabetic")
  public void nameZtoA() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSortContainerZtoAButton();
    Assert.assertEquals(homePage.getItemsSuiteString(), homePage.sortListZToA());
  }

  @Test
  @Description(value = "Test sorts product items by price from low to high")
  public void priceLowToHigh() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickPriceLowToHighButton();
    Assert.assertEquals(homePage.getPriceItemsFromPage(), homePage.sortPriceLowToHigh());
  }

  @Test
  @Description(value = "Test sorts product items by price from high to low")
  public void priceHighToLow() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickPriceHighToLowButton();
    Assert.assertEquals(homePage.getPriceItemsFromPage(), homePage.sortPriceHighToLow());
  }
}
