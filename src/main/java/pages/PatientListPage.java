package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PatientListPage extends BasePage {

    @FindBy(css = "button[data-tutorial-target='all-patient-lists-tab']")
    private WebElement allListBtn;

    @FindBy(xpath = "//tr/td[1]")
    private List<WebElement> patientNameList;

    public PatientListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAllListBtn() {
        clickElement(allListBtn);
    }

    public void checkPatientName(final String patientName) {
        String actual = patientNameList.get(0).getText();
        Assert.assertEquals(actual, patientName, "Patient did not registered");
    }
}
