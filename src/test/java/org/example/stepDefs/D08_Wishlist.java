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

public class D08_Wishlist {
    P01_Home home = new P01_Home();
    @When("user clicks on wish button for element {int}")
    public void userClicksOnWishButtonForElement(int arg0) {
        home.wishBtn.get(arg0-1).click();
    }
    @Then("success notification displayed")
    public void successNotificationDisplayed() {
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
    @Then("{string} massage appears on page")
    public void massageAppearsOnPage(String arg0) {
        Assert.assertFalse(home.noDataMsg.isEmpty());
        Boolean actualMsg = home.noDataMsg.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }
    @And("user close success notification bar")
    public void userCloseSuccessNotificationBar() {
        home.closeNotificationBar.click();
    }
    @When("user go to wishlist page")
    public void userGoToWishlistPage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(home.wishlistTab));
        home.wishlistTab.click();
    }
    @Then("item added to the wishlist")
    public void itemAddedToTheWishlist() {
        // hard assertion to verify item added to the wishlist
        String Qty = home.wishQty.getText();
        Assert.assertNotEquals(Qty,"(0)");
    }
    @When("User re-click on wish button for the same element {int}")
    public void userReClickOnWishButtonForTheSameElement(int arg0) {
        home.wishBtn.get(arg0-1).click();
    }
    @And("user clicks on x sign")
    public void userClicksOnXSign() {
        home.removeBtn.get(0).click();
    }
    @Then("item removed from wishlist")
    public void itemRemovedFromWishlist() {
        // hard assertion to verify item added to the wishlist
        String Qty = home.wishQty.getText();
        Assert.assertEquals(Qty,"(0)");
    }

}

