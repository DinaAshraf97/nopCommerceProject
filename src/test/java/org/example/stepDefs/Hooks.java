package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
   // Declaration for Webdriver variable
    public static WebDriver driver;

    @Before
    public void openBrowser()
    {
        //Create Object from ChromeDriver
        driver= new ChromeDriver();

        //Configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        //Navigate to URL
        driver.get("https://demo.nopcommerce.com");
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
