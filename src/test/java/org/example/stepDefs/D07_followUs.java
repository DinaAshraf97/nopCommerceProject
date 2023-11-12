package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.testng.Assert;

import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D07_followUs {
    P01_Home home = new P01_Home();

    @When("user clicks on facebook icon")
    public void userClicksOnFacebookIcon() {
        home.facebook.click();
    }

    @When("user clicks on twitter icon")
    public void userClicksOnTwitterIcon() {
        home.twitter.click();
    }

    @When("user clicks on rss icon")
    public void userClicksOnRssIcon() {
        home.rss.click();
    }

    @When("user clicks on youtube icon")
    public void userClicksOnYoutubeIcon() {
        home.youtube.click();
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) {

        //switch between tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //hard assertion verify navigate to desired url
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, arg0);

        //close the current tab
        driver.switchTo().window(tabs.get(1)).close();
        //tabs=new ArrayList<>(driver.getWindowHandles()); //no need to reload window handles if one tab closed , you only need it if one new tab will be opened
        driver.switchTo().window(tabs.get(0));
    }
}