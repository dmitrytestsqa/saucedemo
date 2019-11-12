package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Finish {

  public WebDriver driver;

  public Finish(WebDriver driver) {
    this.driver = driver;
  }

  private By gratitudeNotification = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

  public String getGratitudeNotification() {
    return driver.findElement(gratitudeNotification).getText();
  }
}