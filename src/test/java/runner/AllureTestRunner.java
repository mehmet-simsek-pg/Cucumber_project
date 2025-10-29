package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@Smoke", // tags eklenmek zorunda degil
        monochrome = true
)
public class AllureTestRunner extends AbstractTestNGCucumberTests {
}
