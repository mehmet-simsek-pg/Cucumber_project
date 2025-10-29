package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CreatePatientPage;
import pages.Navbar;
import utility.BaseDriver;

public class AddNewPatientSteps {

    WebDriver driver;
    Navbar navbar;
    CreatePatientPage createPatientPage;

    @Then("Click add patient button")
    public void click_add_patient_button() {
        driver = BaseDriver.getDriver();
        navbar = new Navbar(driver);
        createPatientPage = new CreatePatientPage(driver);

        driver.get("https://o3.openmrs.org/openmrs/spa/login");

        navbar.clickAddPatientBtn();
    }

    @Then("Enter firstname {string} and lastname {string}")
    public void enter_firstname_and_lastname(String firstname, String lastname) {
       createPatientPage.enterFirstnameAndLastname(firstname, lastname);
    }

    @Then("Select gender {string}")
    public void selectGender(String number) {
        createPatientPage.selectGender(Integer.parseInt(number));
    }

    @Then("Click register patient button")
    public void click_register_patient_button() {
       createPatientPage.clickRegisterBtn();
    }

    @Then("Select gender")
    public void selectGender() {
        createPatientPage.selectGender(2);
    }

    @Then("Enter lastname")
    public void enterLastname() {
        createPatientPage.enterFirstnameAndLastname("", "user");

    }

    @Then("Enter firstname")
    public void enterFirstname() {
        createPatientPage.enterFirstnameAndLastname("test","");
    }

    @Then("Enter birthday year {string} month {string}")
    public void enterBirthdayYearMonth(String year, String month) {
        createPatientPage.enterBirthday(year, month);
    }
}
