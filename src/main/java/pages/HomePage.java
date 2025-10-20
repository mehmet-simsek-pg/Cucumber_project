package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "div[data-testid='patient-queue-header']>div>div>p:nth-child(1)")
    private WebElement clinicText;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
