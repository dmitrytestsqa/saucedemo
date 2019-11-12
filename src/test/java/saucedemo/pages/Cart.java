package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart {

  public WebDriver driver;

  public Cart(WebDriver driver) {
    this.driver = driver;
  }

  private By checkoutButton = By.xpath("//a[@class='btn_action checkout_button']");
  private By removeButton = By.xpath("//div[@class='cart_list']/div[@class='cart_item'][1]//button[text()='REMOVE']");
  private By removeButtons = By.xpath("//button[@class='btn_secondary cart_button']");
  private By listOfItems = By.xpath("//div[@class='cart_item']");
  private By continueShoppingButton = By.xpath("//a[text()='Continue Shopping']");

  public void removeOneItemFromCart() {
    driver.findElement(removeButton).click();
  }

  public void removeAllItemsFromCart() {
    List<WebElement> removeButtonsList = driver.findElements(removeButtons);
    for (int i = 0; i < removeButtonsList.size(); i++) {
      removeButtonsList.get(i).click();
    }
  }

  public int listOfItems() {
    List<WebElement> items = driver.findElements(listOfItems);
    return items.size();
  }

  public void clickCheckoutButton() {
    driver.findElement(checkoutButton).click();
  }

  public void clickContinueShoppingButton() {
    driver.findElement(continueShoppingButton).click();
  }
}