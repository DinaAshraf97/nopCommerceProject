package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P03_Login {
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="Email")
    public WebElement email;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(className="login-button")
    public WebElement loginBtn;
    @FindBy(className="ico-account")
    public WebElement myAccountTab;
    @FindBy(className="validation-summary-errors")
    public List<WebElement> validationErrorMsg ;
    @FindBy(id="Email-error")
    public List<WebElement> emailError;

}
