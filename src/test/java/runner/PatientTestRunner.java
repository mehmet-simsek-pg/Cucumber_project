package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/patient.feature",
                "src/test/resources/features/patientList.feature",
                "src/test/resources/features/patientNegative.feature",
        },
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class PatientTestRunner extends AbstractTestNGCucumberTests {
}
