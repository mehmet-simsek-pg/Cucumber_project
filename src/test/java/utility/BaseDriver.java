package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriver getDriver() {

        driver = new ChromeDriver();
        driver.get("https://o3.openmrs.org/openmrs/spa/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void threadWait(int second) {
        try {
            Thread.sleep(second*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tearDown() {
        driver.quit();
    }
}
