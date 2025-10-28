package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "Regression",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RegressionTestRunner extends AbstractTestNGCucumberTests {
}
