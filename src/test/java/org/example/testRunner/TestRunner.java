package org.example.testRunner;
import io.cucumber.core.plugin.PrettyFormatter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ="src/main/resources/features",
        glue ={"org.example.stepDefs"},
        plugin ={"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        tags = "@Smoke"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
