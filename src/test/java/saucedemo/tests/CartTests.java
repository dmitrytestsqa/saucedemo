package saucedemo.tests;

import org.junit.Assert;
import org.junit.Test;
import saucedemo.data.UserData;
import saucedemo.pages.Cart;
import saucedemo.pages.HomePage;
import saucedemo.pages.LoginPage;
import saucedemo.webdriverinit.WebDriverInit;

public class CartTests extends WebDriverInit {

  @Test
  public void addItemToCartAndDeleteIt() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.removeOneItemFromCart();
    Assert.assertEquals(0, cart.listOfItems());
  }

  @Test
  public void addAllItemsToCartAndDeleteIt() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.addAllItemsOfProductsToCart();
    homePage.clickCartButton();
    cart.removeAllItemsFromCart();
    Assert.assertEquals(0, cart.listOfItems());
  }

  @Test
  public void addItemToCartAndContinueShopping() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickContinueShoppingButton();
    Assert.assertEquals(6, homePage.getitemsSuiteInt());
  }


}