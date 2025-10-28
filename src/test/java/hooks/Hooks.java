package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;
import utility.ExtendManager;

public class Hooks {

    public static WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    static ExtentReports reports;
    static ExtentTest test;

    @Before
    public void setup() {
        driver = BaseDriver.getDriver();
        LOGGER.info("The driver has been created.");

        reports = ExtendManager.getInstance();
        test = reports.createTest("Scenario has been start");
    }

    @After
    public void tearDown(Scenario scenario) {

        driver.quit();
        LOGGER.info("The driver quited successfully");
        if (scenario.isFailed()) {
            test.fail("Scenario has been failed" + scenario.getName());
        } else {
            test.pass("Scenario has been successfully" + scenario.getName());
        }

        reports.flush(); // Raporun son hali, raporu sonlandir
    }
}
