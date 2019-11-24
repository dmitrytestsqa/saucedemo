package saucedemo.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import saucedemo.data.UserData;
import saucedemo.pages.HomePage;
import saucedemo.webdriverinit.WebDriverInit;
import saucedemo.pages.LoginPage;

public class LoginPageTests extends WebDriverInit {

  @Test
  @Description(value = "Try to login with correct Username and Password")
  public void CorrectLogin() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    Assert.assertTrue(homePage.getVisibleCartButton().isDisplayed());
  }

  @Test
  @Description(value = "Try to login with empty Username")
  public void LoginWithEmptyUsername() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(UserData.emptyString, UserData.userNameLogin);
    Assert.assertEquals(loginPage.getErrorNotificationUsername(), loginPage.notificationUsername());
  }

  @Test
  @Description(value = "Try to login with empty Password")
  public void LoginWithEmptyPassword() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(UserData.userNameLogin, UserData.emptyString);
    Assert.assertEquals(loginPage.getErrorNotificationPassword(), loginPage.notificationPassword());
  }

  @Test
  @Description(value = "Try to login with empty Username and Password")
  public void loginWithEmptyUsernameAndPassword() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(UserData.emptyString, UserData.emptyString);
    Assert.assertEquals(loginPage.getErrorNotificationUsername(), loginPage.notificationUsername());
  }

  @Test
  @Description(value = "Try to login with incorrect Username")
  public void incorrectLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(UserData.incorrectUsername, UserData.userPassword);
    Assert.assertEquals(loginPage.getStrUsernameAndPassDoNotMatch(), loginPage.notificationUsernameAndPassword());
  }

  @Test
  @Description(value = "Try to login with incorrect Password")
  public void incorrectPassword() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(UserData.userNameLogin, UserData.incorrectPassword);
    Assert.assertEquals(loginPage.getStrUsernameAndPassDoNotMatch(), loginPage.notificationUsernameAndPassword());
  }

  @Test
  @Description(value = "Try to login with incorrect Username and Password")
  public void incorrectLoginAndPassword() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(UserData.incorrectUsername, UserData.incorrectPassword);
    Assert.assertEquals(loginPage.getStrUsernameAndPassDoNotMatch(), loginPage.notificationUsernameAndPassword());
  }
}