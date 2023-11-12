package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P01_Home {

    //without PageFactory
    public WebElement registerTab() {
        return driver.findElement(By.className("ico-register"));
    }
    public WebElement loginTab() {
        return driver.findElement(By.className("ico-login"));
    }

    //F03
    //Using PageFactory
    {
        PageFactory.initElements(driver,this);
    }
   @FindBy(id="customerCurrency")
   public WebElement currency;
   @FindBy(className ="actual-price")
   public List<WebElement> price;
   //F04
   @FindBy(className ="search-box-text")
   public WebElement searchBox;
   @FindBy(className ="search-box-button")
   public WebElement searchBtn;
    @FindBy(className ="product-item")
    public List<WebElement> itemsBox;
    @FindBy(className ="no-result")
    public List<WebElement> noResultMsg;
    @FindBy(className ="warning")
    public List<WebElement> errorMsg;
    public By nextPage = By.xpath("//li[@class=\"current-page\"]/span[text()=\"2\"]");
    @FindBy(css ="a[data-page=\"2\"]")
    public WebElement nextBtn;
    @FindBy(css ="h2[class=\"product-title\"] a[href*=\"/\"]")
    public List<WebElement> productTitle;
    @FindBy(css ="div[class=sku] span[id*=sku]")
    public WebElement skuNumber;
    //F05
    @FindBy(css ="ul[class=\"top-menu notmobile\"]>li>a")
    public List<WebElement> itemsInHeader;
    @FindBy(css ="ul[class=\"top-menu notmobile\"]>li>ul[class=\"sublist first-level\"]")
    public List<WebElement> dropdownList;
    public List<WebElement> subCategories(int categoryNum) {
        categoryNum = categoryNum + 1;
        return driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li:nth-child(" + categoryNum + ")>ul[class=\"sublist first-level\"]>li>a"));
    }
    @FindBy(className="page-title")
    public WebElement pageTitle;
    //F06
    @FindBy(className ="nivo-imageLink")
    public List<WebElement> slider;
    //F07
    @FindBy(linkText ="Facebook")
    public WebElement facebook;
    @FindBy(linkText ="Twitter")
    public WebElement twitter;
    @FindBy(linkText ="RSS")
    public WebElement rss;
    @FindBy(linkText ="YouTube")
    public WebElement youtube;
//F08
    @FindBy(className ="add-to-wishlist-button")
    public List<WebElement> wishBtn;
    @FindBy(className ="product-box-add-to-cart-button")
    public List<WebElement> addToCartBtn;
    @FindBy(css = "div[class=\"bar-notification-container\"] p[class=\"content\"]")
    public WebElement notificationMsg;
    @FindBy(css = "div[class=\"bar-notification-container\"] div[class=\"bar-notification success\"]")
    public WebElement notificationContainer;
    @FindBy(css = "div[class=\"bar-notification success\"] span[class=\"close\"]")
    public WebElement closeNotificationBar;
    @FindBy(className = "wishlist-label")
    public WebElement wishlistTab;
    @FindBy(className = "cart-label")
    public WebElement shoppingCartTab;
    @FindBy(css ="a[class=\"ico-wishlist\"] [class=\"wishlist-qty\"]")
    public WebElement wishQty;
    @FindBy(css ="a[class=\"ico-cart\"] [class=\"cart-qty\"]")
    public WebElement cartQty;
    @FindBy(className = "no-data")
    public List<WebElement> noDataMsg;
    @FindBy(className = "remove-btn")
    public List<WebElement> removeBtn;











}
