package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseDriver {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static final ThreadLocal<String> threadBrowser = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        threadBrowser.set(browser);
    }

    public static WebDriver getDriver() {

        WebDriver driver = threadDriver.get();
        if (driver == null) {
            String browser = threadBrowser.get();
            if (browser == null) {
                // bu satir xml olmadigi durumda otomatik chrome calistirsin
                browser = System.getProperty("browser","chrome");
                threadBrowser.set(browser);
            }
            driver = createDriver(browser.toLowerCase());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            threadDriver.set(driver);
        }
        return driver;
    }

    private static WebDriver createDriver(String browser) {
        return switch (browser) {
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "chrome" -> new ChromeDriver();
            case "safari" -> new SafariDriver();
            default -> null;
        };
    }

    public static void threadWait(int second) {
        try {
            Thread.sleep(second*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tearDown() {
        WebDriver driver = threadDriver.get();

        if (driver != null) {
            driver.quit();
            threadDriver.remove();
        }
        threadBrowser.remove();
    }
}
