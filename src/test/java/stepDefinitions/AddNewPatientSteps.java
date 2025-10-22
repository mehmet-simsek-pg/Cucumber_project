package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.CreatePatientPage;
import pages.Navbar;
import utility.BaseDriver;

public class AddNewPatientSteps {

    Navbar navbar;
    CreatePatientPage createPatientPage;

    @Then("Click add patient button")
    public void click_add_patient_button() {
        navbar = new Navbar(BaseDriver.getDriver());
        createPatientPage = new CreatePatientPage(BaseDriver.getDriver());

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

    @Then("Enter birthday {string}")
    public void enter_birthday(String birthday) {
        createPatientPage.enterBirthday(birthday);
    }

    @Then("Click register patient button")
    public void click_register_patient_button() {
       createPatientPage.clickRegisterBtn();
    }
}
