package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceLabsBackpack {

  public WebDriver driver;

  public SauceLabsBackpack(WebDriver driver) {
    this.driver = driver;
  }

  private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
  private By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");

  public void clickAddToCartButton() {
    driver.findElement(addToCartButton).click();
  }

  public void clickCartButton() {
    driver.findElement(cartButton).click();
  }
}