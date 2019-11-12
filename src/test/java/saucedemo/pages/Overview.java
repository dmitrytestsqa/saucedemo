package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Overview {

  public WebDriver driver;

  public Overview(WebDriver driver) {
    this.driver = driver;
  }

  private By finishButton = By.xpath("//a[@class='btn_action cart_button']");
  private By cancelButton = By.xpath("//a[@class='cart_cancel_link btn_secondary']");

  public void clickFinishButton() {
    driver.findElement(finishButton).click();
  }

  public void clickCancelButton() {
    driver.findElement(cancelButton).click();
  }
}