package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/userProfile.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class DataTableOutlineRunner extends AbstractTestNGCucumberTests {
}
