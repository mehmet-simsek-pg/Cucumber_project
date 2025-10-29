package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utility.BaseDriver;

public class Hooks {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @Before
    public void setup(Scenario scenario) {
        // testng.xml dosyasi icinde <parameter name='browser' olmasi durumunda
        try {
            String browserFromXML =
                    Reporter
                            .getCurrentTestResult()
                            .getTestContext()
                            .getCurrentXmlTest()
                            .getParameter("browser");
            if (browserFromXML != null) {
                BaseDriver.setBrowser(browserFromXML);
            }
        } catch (Throwable ex) {
            // Testng context yani her hangi bir xml dosyasi yoksa,
            // her durumda System.getProperty("browser","chrome"); bu calisir
        }
        WebDriver driver = BaseDriver.getDriver();
        LOGGER.info("The driver has been created.");
        LOGGER.info("Scenario Started {}", scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            WebDriver driver = BaseDriver.getDriver();
            if (scenario.isFailed() && driver instanceof TakesScreenshot) { // base64 -> png
                LOGGER.info("Scenario Failed {}", scenario.getName());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
            } else {
                LOGGER.info("Scenario passed {}", scenario.getName());
            }
        } finally {
            BaseDriver.tearDown();
            LOGGER.info("The driver quited successfully");
        }
    }
}
