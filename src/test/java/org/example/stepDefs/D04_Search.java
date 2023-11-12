package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Examples;
import org.example.pages.P01_Home;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D04_Search {
P01_Home home= new P01_Home();


    @When("user write product name in the search box {string}")
    public void userWriteProductNameInTheSearchBox(String arg0){
        home.searchBox.sendKeys(arg0);
    }

    @And("user press on search button")
    public void userPressOnSearchButton() {
        home.searchBtn.click();
    }

    @Then("search relevant results appears {string}")
    public void searchRelevantResultsAppears(String arg0) {
        //assertions
        SoftAssert soft = new SoftAssert();
        //verify url
        boolean actualUrl = driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=");
        soft.assertTrue(actualUrl);

        //count number of items appears in (1st results' page)
        int numberofitems1 = home.itemsBox.size();

        //verify each result contains the search keyword in (1st results' page)
        int i;
        boolean wordAppears = false;
        for (i = 0; i <=numberofitems1-1; i++)
        {
            wordAppears = home.productTitle.get(i).getText().toLowerCase().contains(arg0);
            soft.assertTrue(wordAppears);
        }

        boolean next;
        try {
            next=home.nextBtn.isDisplayed();
        }
        catch (NoSuchElementException e){
            next=false;
        }

        // if there is a next button check the result in the second page
           if (next==true){
               home.nextBtn.click();

               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
               wait.until(ExpectedConditions.numberOfElementsToBe(home.nextPage,1));

               //count number of items appears in (2nd results' page)
               int numberofitems2 = home.itemsBox.size();

               //verify each result contains the search keyword in (2nd results' page)
               boolean wordAppears2 = false;
               for (i = 0; i <=numberofitems2-1; i++)
               {
                   wordAppears2 = home.productTitle.get(i).getText().toLowerCase().contains(arg0);
                   soft.assertTrue(wordAppears2);
               }
           }
           soft.assertAll();
    }

    @When("user write sku in the search box {string}")
    public void userWriteSkuInTheSearchBox(String arg0) {
        home.searchBox.sendKeys(arg0);
    }

    @And("click on the product in search result")
    public void clickOnTheProductInSearchResult() {
        home.itemsBox.get(0).click();
    }

    @Then("exact result appears {string}")
    public void exactResultAppears(String arg0) {
        //hard assertion to verify sku
        String actualSku=home.skuNumber.getText();
        String expectedSku=arg0;
        Assert.assertEquals(actualSku,expectedSku);
    }

    @Then("A massage {string} is displayed")
    public void aMassageIsDisplayed(String arg0) {
        Assert.assertFalse(home.noResultMsg.isEmpty());
        Boolean actualMsg = home.noResultMsg.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }

    @Then("error massage {string} is displayed")
    public void errorMassageIsDisplayed(String arg0) {
    }
}
