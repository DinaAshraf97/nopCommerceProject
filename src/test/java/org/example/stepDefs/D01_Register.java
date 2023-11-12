package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Home;
import org.example.pages.P02_Register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D01_Register {
    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    P01_Home home =new P01_Home();
    P02_Register register =new P02_Register();

    @Given("user go to register page")
    public void userGoToRegisterPage() {

        home.registerTab().click();
    }
    @When("user select gender type")
    public void userSelectGenderType() {
        register.gender.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstName.sendKeys(arg0);
        register.lastName.sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select birthDay = new Select(register.day);
        birthDay.selectByValue("6");
        Select birthMonth = new Select(register.month);
        birthMonth.selectByValue("3");
        Select birthYear = new Select(register.year);
        birthYear.selectByValue("1997");
    }

    @And("user enter valid email {string}")
    public void userEnterValidEmail(String arg0) {
        register.email.sendKeys(arg0);
    }
    @And("user enter valid email")
    public void userEnterValidEmail(){

        register.email.sendKeys(randomEmail());
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.pass.sendKeys(arg0);
        register.confirmpass.sendKeys(arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {

        register.registerBtn.click();
    }
    @Then("user redirected to register result page and success message is displayed")
    public void userRedirectedToRegisterResultPageAndSuccessMessageIsDisplayed() {
        //assertions
        SoftAssert soft =new SoftAssert();
        //verify redirection to register result page
        String expectedUrl="https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        soft.assertEquals(driver.getCurrentUrl(),expectedUrl);

        //verify success registration message contains "Your registration completed"
        Boolean actualMsg = register.result.getText().contains("Your registration completed");
        soft.assertTrue(actualMsg);

        //verify color of success registration message
        String actualColor= Color.fromString(register.result.getCssValue("color")).asHex();
        soft.assertEquals(actualColor,"#4cb17c");
        soft.assertAll();
    }
    
    @And("user leave first name empty and enter last name {string}")
    public void userLeaveFirstNameEmptyAndEnterLastName(String arg0) {
        register.lastName.sendKeys(arg0);
    }

    @Then("error message {string} is displayed under first name field")
    public void errorMessageIsDisplayedUnderFirstNameField(String arg0) {
        Assert.assertFalse(register.firstNameError.isEmpty());
        Boolean actualMsg = register.firstNameError.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }

    @And("user enter first name {int} and last name {string}")
    public void userEnterFirstNameAndLastName(int arg0, String arg1) {
        register.firstName.sendKeys(String.valueOf(arg0));
        register.lastName.sendKeys(arg1);
    }

    @And("user enter first name {string} and leave last name empty")
    public void userEnterFirstNameAndLeaveLastNameEmpty(String arg0) {
        register.firstName.sendKeys(arg0);
    }

    @Then("error message {string} is displayed under last name field")
    public void errorMessageIsDisplayedUnderLastNameField(String arg0) {
        Assert.assertFalse(register.lastNameError.isEmpty());
        Boolean actualMsg = register.lastNameError.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }

    @And("user enter first name {string} and last name {int}")
    public void userEnterFirstNameAndLastName(String arg0, int arg1) {
        register.firstName.sendKeys(arg0);
        register.lastName.sendKeys(String.valueOf(arg1));
    }

    @And("user leave email field empty")
    public void userLeaveEmailFieldEmpty() {
        
    }

    @Then("error message {string} is displayed under email field")
    public void errorMessageIsDisplayedUnderEmailField(String arg0) {
        Assert.assertFalse(register.emailError.isEmpty());
        Boolean actualMsg = register.emailError.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }

    @And("user leave Password fields Empty")
    public void userLeavePasswordFieldsEmpty() {
    }

    @Then("error message {string} is displayed under password fields")
    public void errorMessageIsDisplayedUnderPasswordFields(String arg0) {
        Assert.assertFalse(register.passwordError.isEmpty());
        Assert.assertFalse(register.ConfirmPasswordError.isEmpty());
        Boolean actualMsg1 = register.passwordError.get(0).getText().contains(arg0);
        Boolean actualMsg2 = register.ConfirmPasswordError.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg1);
        Assert.assertTrue(actualMsg2);
    }

    @Then("error message contains {string} is displayed under password field")
    public void errorMessageContainsIsDisplayedUnderPasswordField(String arg0) {
        Assert.assertFalse(register.passwordError.isEmpty());
        Boolean actualMsg = register.passwordError.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }

    @Then("error message {string} is displayed under confirm password field")
    public void errorMessageIsDisplayedUnderConfirmPasswordField(String arg0) {
        Assert.assertFalse(register.ConfirmPasswordError.isEmpty());
        Boolean actualMsg = register.ConfirmPasswordError.get(0).getText().contains(arg0);
        Assert.assertTrue(actualMsg);
    }

}
