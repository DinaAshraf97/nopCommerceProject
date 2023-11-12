package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D09_ShoppingCart {
    P01_Home home = new P01_Home();

    @When("user click on Add to cart button for element {int}")
    public void userClickOnAddToCartButtonForElement(int arg0) {
        home.addToCartBtn.get(arg0-1).click();
    }
    @Then("success notification appeared")
    public void successNotificationAppeared() {
        //soft assertions
        SoftAssert soft=new SoftAssert();

        //verify success message content
        boolean actualMsg=home.notificationMsg.getText().contains("The product has been added");
        soft.assertTrue(actualMsg);

        //verify success message background color
        String actualColor= Color.fromString(home.notificationContainer.getCssValue("background-color")).asHex();
        soft.assertEquals(actualColor,"#4bb07a");
        soft.assertAll();
    }
    @Then("massage {string} appears on page")
    public void massageAppearsOnPage(String arg0) {
        Assert.assertFalse(home.noDataMsg.isEmpty());
        Boolean actualMsg = home.noDataMsg.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }
    @And("user close notification bar")
    public void userCloseNotificationBar() {
        home.closeNotificationBar.click();
    }

    @When("user go to shopping cart page")
    public void userGoToShoppingCartPage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(home.shoppingCartTab));
        home.shoppingCartTab.click();
    }
    @Then("item added to the shopping cart")
    public void itemAddedToTheShoppingCart() {
        // hard assertion to verify item added to the shopping cart
        String Qty = home.cartQty.getText();
        Assert.assertNotEquals(Qty,"(0)");
    }

    @When("User click on Add to cart button three times on the same element {int}")
    public void userClickOnAddToCartButtonThreeTimesOnTheSameElement(int arg0) throws InterruptedException {
        for(int i=1;i<=3;i++){
            home.addToCartBtn.get(arg0-1).click();
            Thread.sleep(1000);
        }
    }

    @Then("item quantity increased in shopping cart")
    public void itemQuantityIncreasedInShoppingCart() {
        // hard assertion to verify item added to the wishlist
        String Qty = home.cartQty.getText();
        Assert.assertEquals(Qty,"(3)");
    }

    @And("user click on x sign")
    public void userClickOnXSign() {
        home.removeBtn.get(0).click();
    }

    @Then("item removed from shopping cart")
    public void itemRemovedFromShoppingCart() {
        // hard assertion to verify item added to the wishlist
        String Qty = home.cartQty.getText();
        Assert.assertEquals(Qty,"(0)");
    }
}

