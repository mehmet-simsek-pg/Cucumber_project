package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.PatientListPage;
import pages.SideBar;
import utility.BaseDriver;

public class PatientSteps {

    WebDriver driver;
    SideBar sideBar;
    PatientListPage patientListPage;

    @Then("Click patient list button")
    public void clickPatientListButton() {

        driver = BaseDriver.getDriver();

        sideBar = new SideBar(driver);
        patientListPage = new PatientListPage(driver);

        driver.get("https://o3.openmrs.org/openmrs/spa/login");

        sideBar.clickOnPatientListBtn();
    }

    @Then("Click all list button")
    public void clickAllListButton() {

        patientListPage.clickOnAllListBtn();
    }

    @Then("Verify patient name {string}")
    public void verifyPatientName(String patientName) {
        patientListPage.checkPatientName(patientName);
    }
}
