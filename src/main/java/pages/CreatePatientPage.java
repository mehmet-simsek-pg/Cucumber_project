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

    @FindBy(xpath = "(//button[@class='cds--content-switcher-btn'])[2]")
    private WebElement birthdayNoBtn;

    @FindBy(css = "input[id='monthsEstimated']")
    private WebElement ageInMonthInput;

    @FindBy(css = "input[id='yearsEstimated']")
    private WebElement ageInYearInput;

    @FindBy(css = "button[type='submit']")
    private WebElement registerBtn;

    public CreatePatientPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstnameAndLastname(final String firstname, final String lastname) {
        sendKeysToElement(firstnameInput, firstname);
        sendKeysToElement(lastnameInput, lastname);
    }

    public void selectGender(final int select) {
        gender.get(select).click();
    }

    public void enterBirthday(final String year, final String month) {
        clickElement(birthdayNoBtn);
        sendKeysToElement(ageInYearInput, year);
        sendKeysToElement(ageInMonthInput, month);
    }

    public void clickRegisterBtn() {
        clickElement(registerBtn);
    }
}
