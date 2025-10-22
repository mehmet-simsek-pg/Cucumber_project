package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreatePatientPage extends BasePage{

    @FindBy(css = "input[id='givenName']")
    private WebElement firstnameInput;

    @FindBy(css = "input[id='familyName']")
    private WebElement lastnameInput;

    // 0.Male, 1.Female, 2.Other, 3.Unknown
    @FindBy(css = "div[class='cds--radio-button-wrapper']")
    private List<WebElement> gender;

    @FindBy(css = "input[name='birthdate']")
    private WebElement birthdayInput;

    public CreatePatientPage(WebDriver driver) {
        super(driver);
    }
}
