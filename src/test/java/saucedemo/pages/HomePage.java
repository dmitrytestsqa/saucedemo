package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePage {

  public WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  private By homePageTitle = By.xpath("//title[text()='Swag Labs']");
  private By sauceLabsBackpack = By.xpath("//div[text()='Sauce Labs Backpack']");
  private By sauceLabsOnesie = By.xpath("//div[text()='Sauce Labs Onesie']");
  private By sauceLabsFleeceJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
  private By ShirtRed = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");
  private By addCartSauceLabsBackpackToCartButton = By.xpath("//div[@class='inventory_list']/div[1]//button[text()='ADD TO CART']");
  private By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");
  private By cartButtonWithQuantity = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
  private By sortContainer = By.xpath("//select[@class='product_sort_container']");
  private By sortAtoZButton = By.xpath("//select[@class='product_sort_container']//option[@value='az']");
  private By sortZtoAButton = By.xpath("//select[@class='product_sort_container']//option[@value='za']");
  private By sortPriceLowToHigh = By.xpath("//select[@class='product_sort_container']//option[@value='lohi']");
  private By sortPriceHighToLow = By.xpath("//select[@class='product_sort_container']//option[@value='hilo']");
  private By sidebarButton = By.xpath("//div[@class='bm-burger-button']");
  private By allItemsLink = By.xpath("//a[@id='inventory_sidebar_link']");
  private By aboutLink = By.xpath("//a[@id='about_sidebar_link']");
  private By logoutLink = By.xpath("//a[@id='logout_sidebar_link']");
  private By itemsSuite = By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']");
  private By itemsPrice = By.xpath("//div[@class='inventory_item_price']");
  private By addToCartButtons = By.xpath("//button[@class='btn_primary btn_inventory']");
  private By buttonAddToCart = By.xpath("//button[text()='ADD TO CART']");


  public ArrayList<String> sortListAToZ() {
    ArrayList<String> obtainedList = new ArrayList();
    List<WebElement> elementList = driver.findElements(itemsSuite);

    for (int i = 0; i < elementList.size(); i++) {
      obtainedList.add(elementList.get(i).getText());
    }
    Collections.sort(obtainedList);
    return obtainedList;
  }

  public ArrayList<String> sortListZToA() {
    ArrayList<String> obtainedList = new ArrayList();
    List<WebElement> elementList = driver.findElements(itemsSuite);

    for (int i = 0; i < elementList.size(); i++) {
      obtainedList.add(elementList.get(i).getText());
    }
    obtainedList.sort(Comparator.reverseOrder());
    return obtainedList;
  }

  public ArrayList<String> notSortedItemList() {
    ArrayList<String> obtainedList = new ArrayList();
    List<WebElement> itemsList = driver.findElements(itemsSuite);

    for (int i = 0; i < itemsList.size(); i++) {
      obtainedList.add(itemsList.get(i).getText());
    }
    return obtainedList;
  }

  public ArrayList<Double> sortPriceLowToHigh() {
    List<WebElement> priceItems = driver.findElements(itemsPrice);
    ArrayList<String> sortLowHigh = new ArrayList();
    ArrayList<Double> price = new ArrayList();

    for (int i = 0; i < priceItems.size(); i++) {
      sortLowHigh.add(priceItems.get(i).getText().toString());
    }

    for (int i = 0; i < sortLowHigh.size(); i++) {
      price.add(Double.parseDouble(sortLowHigh.get(i).toString().replace("$", "")));
    }
    price.sort(Comparator.naturalOrder());
    return price;
  }

  public ArrayList<Double> sortPriceHighToLow() {
    List<WebElement> priceItems = driver.findElements(itemsPrice);
    ArrayList<String> sortLowHigh = new ArrayList();
    ArrayList<Double> price = new ArrayList();

    for (int i = 0; i < priceItems.size(); i++) {
      sortLowHigh.add(priceItems.get(i).getText().toString());
    }

    for (int i = 0; i < sortLowHigh.size(); i++) {
      price.add(Double.parseDouble(sortLowHigh.get(i).toString().replace("$", "")));
    }
    price.sort(Comparator.reverseOrder());
    return price;
  }

  public ArrayList<Double> getPriceItemsFromPage() {
    List<WebElement> priceItems = driver.findElements(itemsPrice);
    ArrayList<Double> price = new ArrayList();
    for (int i = 0; i < priceItems.size(); i++) {
      price.add(Double.parseDouble(priceItems.get(i).getText().replace("$", "")));
    }
    return price;
  }

  public void addSeveralItemsToCart() {
    List<WebElement> buttonAddToCart = new ArrayList();
    buttonAddToCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
    for (int i = 0; i < 3; i++) {
      buttonAddToCart.get(i).click();
    }
  }

  public int getitemsSuiteInt() {
    List<WebElement> itemsSuiteList = driver.findElements(itemsSuite);
    return itemsSuiteList.size();
  }

  public List<String> getItemsSuiteString() {
    List<WebElement> obtainedList = driver.findElements(itemsSuite);
    List<String> itemsList = new ArrayList<>();

    for (int i = 0; i < obtainedList.size(); i++) {
      itemsList.add(obtainedList.get(i).getText());
    }
    return itemsList;
  }

  public WebElement getVisibleCartButton() {
    WebElement visibleCartButton = driver.findElement(cartButton);
    return visibleCartButton;
  }

  public void clickSauceLabsBackpack() {
    driver.findElement(sauceLabsBackpack).click();
  }

  public void clickAddCartSauceLabsBackpackButton() {
    driver.findElement(addCartSauceLabsBackpackToCartButton).click();
  }

  public void clickCartButton() {
    driver.findElement(cartButton).click();

  }

  public void addAllItemsOfProductsToCart() {
    List<WebElement> allProductsAddToCartButtons = driver.findElements(addToCartButtons);
    for (int i = 0; i < allProductsAddToCartButtons.size(); i++) {
      allProductsAddToCartButtons.get(i).click();
    }
  }

  public void clickSideBarButton() {
    driver.findElement(sidebarButton).click();
  }

  public void clickAllItemsButton() {
    driver.findElement(allItemsLink).click();
  }

  public void clickAboutButton() {
    driver.findElement(aboutLink).click();
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl().toString();
  }

  public void clickLogoutButton() {
    driver.findElement(logoutLink).click();
  }

  public void clickSortContainerAtoZButton() {
    driver.findElement(sortContainer).click();
    driver.findElement(sortAtoZButton).click();
  }

  public void clickSortContainerZtoAButton() {
    driver.findElement(sortContainer).click();
    driver.findElement(sortZtoAButton).click();
  }

  public void clickPriceLowToHighButton() {
    driver.findElement(sortContainer).click();
    driver.findElement(sortPriceLowToHigh).click();
  }

  public void clickPriceHighToLowButton() {
    driver.findElement(sortContainer).click();
    driver.findElement(sortPriceHighToLow).click();
  }
}