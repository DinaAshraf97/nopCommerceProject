package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_Currencies {
    P01_Home home= new P01_Home();

    @When("user select Euro currency")
    public void userSelectEuroCurrency() {
        Select euro =new Select( home.currency);
        euro.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }

    @Then("Euro Symbol is shown on products displayed in Home page")
    public void euroSymbolIsShownOnProductsDisplayedInHomePage() {
        //hard assertion
        //Euro Symbol displayed on the 4 products price
       int i;
        for(i=0;i<=3;i++) {
            Boolean actualPrices = home.price.get(i).getText().contains("€");
            Assert.assertTrue(actualPrices);
        }

    }
}
