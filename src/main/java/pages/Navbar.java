package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navbar extends BasePage{

    @FindBy(css = "button[name='AddPatientIcon']")
    private WebElement addPatientBtn;

    public Navbar(final WebDriver driver) {
        super(driver);
    }

    public void clickAddPatientBtn() {
        clickElement(addPatientBtn);
    }
}
