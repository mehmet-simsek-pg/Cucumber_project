package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/login.feature",
                "src/test/resources/features/loginDataTable.feature",
        },
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
