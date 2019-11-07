package saucedemo.tests;

import org.junit.Assert;
import org.junit.Test;
import saucedemo.data.UserData;
import saucedemo.pages.*;
import saucedemo.webdriverinit.WebDriverInit;

public class BuyProductTests extends WebDriverInit {

  @Test
  public void buyProduct() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    Checkout checkout = new Checkout(driver);
    Overview overview = new Overview(driver);
    Finish finish = new Finish(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    overview.clickFinishButton();
    Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish.getGratitudeNotification());
  }

  @Test
  public void buyProductFromItsPage() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    SauceLabsBackpack sauceLabsBackpack = new SauceLabsBackpack(driver);
    Cart cart = new Cart(driver);
    Checkout checkout = new Checkout(driver);
    Overview overview = new Overview(driver);
    Finish finish = new Finish(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSauceLabsBackpack();
    sauceLabsBackpack.clickAddToCartButton();
    sauceLabsBackpack.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    overview.clickFinishButton();
    Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish.getGratitudeNotification());
  }

  @Test
  public void buyProductWithEmptyFirstName() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    Checkout checkout = new Checkout(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.emptyString, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    Assert.assertEquals(checkout.getErrorFirstNameNotification(), checkout.errorNotification());
  }

  @Test
  public void buyProductWithIncorrectLastName() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    Checkout checkout = new Checkout(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.emptyString, UserData.postalCode);
    checkout.clickContinueButton();
    Assert.assertEquals(checkout.getErrorLastNameNotification(), checkout.errorNotification());
  }

  @Test
  public void buyProductWithIncorrectPostalCode() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    Checkout checkout = new Checkout(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.emptyString);
    checkout.clickContinueButton();
    Assert.assertEquals(checkout.getErrorPostalCodeNotification(), checkout.errorNotification());
  }

  @Test
  public void cancelPurchase() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Cart cart = new Cart(driver);
    Checkout checkout = new Checkout(driver);
    Overview overview = new Overview(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    overview.clickCancelButton();
    Assert.assertEquals(6, homePage.getitemsSuiteInt());
  }
}