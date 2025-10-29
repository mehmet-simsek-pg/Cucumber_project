package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

public class Hooks {

    public static WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @Before
    public void setup(Scenario scenario) {
        driver = BaseDriver.getDriver();
        LOGGER.info("The driver has been created.");
        LOGGER.info("Scenario Started {}", scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) { // base64 -> png
            LOGGER.info("Scenario Failed {}", scenario.getName());
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        } else {
            LOGGER.info("Scenario passed {}", scenario.getName());
        }
        driver.quit();
        LOGGER.info("The driver quited successfully");
    }
}
