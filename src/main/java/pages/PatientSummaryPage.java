package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientSummaryPage extends BasePage{

    @FindBy(css = "span[class='_3QvC113UMQvMOBhW+z79+Q==']")
    private WebElement patientName;

    public PatientSummaryPage(WebDriver driver) {
        super(driver);
    }
}
