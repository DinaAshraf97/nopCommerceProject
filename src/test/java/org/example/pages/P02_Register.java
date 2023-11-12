package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P02_Register {
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="gender-male")
    public WebElement gender;
    @FindBy(id="FirstName")
    public WebElement firstName;
    @FindBy(id="LastName")
    public WebElement lastName;
    @FindBy(name="DateOfBirthDay")
    public WebElement day;
    @FindBy(name="DateOfBirthMonth")
    public WebElement month;
    @FindBy(name="DateOfBirthYear")
    public WebElement year;
    @FindBy(id="Email")
    public WebElement email;
    @FindBy(id="Password")
    public WebElement pass;
    @FindBy(id="ConfirmPassword")
    public WebElement confirmpass;
    @FindBy(id="register-button")
    public WebElement registerBtn;
    @FindBy(className="result")
    public WebElement result;
    @FindBy(id="FirstName-error")
    public List<WebElement> firstNameError;
    @FindBy(id="LastName-error")
    public List<WebElement> lastNameError;
    @FindBy(id="Email-error")
    public List<WebElement> emailError;
    @FindBy(id="Password-error")
    public List<WebElement> passwordError;
    @FindBy(id="ConfirmPassword-error")
    public List<WebElement> ConfirmPasswordError;

}
