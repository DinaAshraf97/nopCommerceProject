package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.example.pages.P03_Login;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D02_Login {
    P01_Home home =new P01_Home();
    P03_Login login =new P03_Login();

    @Given("user go to login page")
    public void userGoToLoginPage() {
        home.loginTab().click();
    }

    @When("user login with {string} and {string}")
    public void userLoginWithAnd(String arg0, String arg1) {
        login.email.sendKeys(arg0);
        login.password.sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        //assertions
        SoftAssert soft = new SoftAssert();

        //verify URL
        String actualUrl=driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/");

        //"My Account" tab isDisplayed
        boolean myAccountTab =login.myAccountTab.isDisplayed();
        soft.assertTrue(myAccountTab);
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/login?returnurl=%2F");
    }

    @And("error massage contains {string} appeared")
    public void errorMassageContainsAppeared(String arg0) {
        //assertions
        SoftAssert soft =new SoftAssert();

        Boolean actualMsg = login.validationErrorMsg.get(0).getText().contains(arg0);
        soft.assertTrue(actualMsg);

        //verify color of error message
        String actualColor= Color.fromString(login.validationErrorMsg.get(0).getCssValue("color")).asHex();
        soft.assertEquals(actualColor,"#e4434b");
        soft.assertAll();
    }

    @And("error massage {string} appeared under email field")
    public void errorMassageAppearedUnderEmailField(String arg0) {
        //assertions
        SoftAssert soft =new SoftAssert();
        //verify error message contains "Wrong email"
        Boolean actualMsg = login.emailError.get(0).getText().contains(arg0);
        soft.assertTrue(actualMsg);

        //verify color of error message
        String actualColor= Color.fromString(login.emailError.get(0).getCssValue("color")).asHex();
        soft.assertEquals(actualColor,"#e4434b");
        soft.assertAll();
    }
}
