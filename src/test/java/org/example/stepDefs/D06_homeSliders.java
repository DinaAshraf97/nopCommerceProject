package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D06_homeSliders {
    P01_Home home = new P01_Home();

    @When("user clicks on the first slider")
    public void userClicksOnTheFirstSlider() {
        // Try to click on the first slider
        Actions action = new Actions(driver);
        action.moveToElement(home.slider.get(0)).click().perform();

        // If the click does not work, try to click on the second slider
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(home.slider.get(1)));
            home.slider.get(1).click();
        } catch (TimeoutException e) {
        }
    }
    @When("user clicks on the second slider")
    public void userClicksOnTheSecondSlider() {
        // Try to click on the first slider
        Actions action = new Actions(driver);
        action.moveToElement(home.slider.get(0)).click().perform();

        // If the click does not work, try to click on the second slider
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(home.slider.get(1)));
            home.slider.get(1).click();
        } catch (TimeoutException e) {
        }
    }
        @Then("direct user to {string}")
    public void directUserTo(String arg0) {
        //hard assertion verify navigate to desired url
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,arg0);
    }

}
