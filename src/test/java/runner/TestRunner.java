package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature", // features dosyalarinin yolu
        // tüm feature dosyalarini calistirabilirim, ya da sectigim feature dosyalarini calistirabilirim
        glue = {"stepDefinitions", "hooks"}, // Java kodlarinin oldugu klasörler
        plugin = {"pretty", "html:target/cucumber-report.html"}
        // {"json:target/cucumber-report.json"}
        // {"junit:target/cucumber-report.xml"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
