package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

public class Hooks {

    public static WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @Before
    public void setup() {
        driver = BaseDriver.getDriver();
        LOGGER.info("The driver has been created.");
    }

    @After
    public void tearDown() {
        driver.quit();
        LOGGER.info("The driver quited successfully");
    }
}
