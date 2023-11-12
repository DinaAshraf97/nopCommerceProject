package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategories {
    P01_Home home = new P01_Home();
    public String text;

    @When("user hover on main categories and select random category")
    public void userHoverOnMainCategoriesAndSelectRandomCategory() throws InterruptedException {

        int sizeHeader = home.itemsInHeader.size();
        int randomCategory = ThreadLocalRandom.current().nextInt(0,sizeHeader-1);

        //Hover on random main category
        Actions action = new Actions(driver);
        action.moveToElement(home.itemsInHeader.get(randomCategory)).perform();

        try {
            // Waiting till options in drop down are visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(home.dropdownList.get(randomCategory)));

            List<WebElement> itemsInDropdown = home.subCategories(randomCategory);
            int randomSubList = ThreadLocalRandom.current().nextInt(0,itemsInDropdown.size()-1);
            text=itemsInDropdown.get(randomSubList).getText().toLowerCase();
            itemsInDropdown.get(randomSubList).click();
        }
        catch (IndexOutOfBoundsException e) {
            text=home.itemsInHeader.get(randomCategory).getText().toLowerCase();
            home.itemsInHeader.get(randomCategory).click();
        }


    }
    @Then("user directed to the selected category")
    public void userDirectedToTheSelectedCategory() {
       String actualTitle = home.pageTitle.getText().toLowerCase();
       Assert.assertEquals(actualTitle,text);
    }

    @When("user accidentally hovers over the categories")
    public void userAccidentallyHoversOverTheCategories() {
        // Move the mouse cursor over the main categories element without intending to hover over it
        Actions action = new Actions(driver);
        action.moveToElement(home.itemsInHeader.get(1), 10, 10).perform();
    }

    @Then("unintended effects should occur on the page")
    public void unintendedEffectsShouldOccurOnThePage() {
        // Check if any unintended effects occur on the page, such as the hover effect appearing even though the user is not hovering over the main categories element
        // For example, you could check if the hover effect is causing other elements on the page to disappear or become unresponsive
    }

}

