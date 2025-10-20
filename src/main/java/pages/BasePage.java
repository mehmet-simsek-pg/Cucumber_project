package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickElement(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
            LOGGER.debug("Element clicked");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .perform();
                LOGGER.debug("Element clicked with Actions");
            } catch (Exception e2){
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    LOGGER.debug("Element clicked with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("Hicbir click metodu ise yaramadi");
                }
            }
        }
    }

    public void sendKeysToElement(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            element.clear();
            element.sendKeys(text);
            LOGGER.debug("Text sent to element");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .sendKeys(text)
                        .build()
                        .perform();
                LOGGER.debug("Text sent to element with Actions");
            } catch (Exception e2) {
                try {
                    ((JavascriptExecutor) driver)
                            .executeScript("arguments[0].value = arguments[1];", element, text);
                    LOGGER.debug("Text sent to element with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("Tüm sendKeys islemleri basarisiz oldu");
                }
            }
        }

    }

    public void verifyDisplayed(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), text);
    }
}
