package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar extends BasePage{

    @FindBy(css = "div[data-extension-id^='patient-list']")
    private WebElement patientListBtn;

    public SideBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnPatientListBtn() {
        clickElement(patientListBtn);
    }
}
