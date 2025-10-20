package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseDriver;

public class LoginSteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @When("Navigate to the webpage")
    public void navigate_to_the_webpage() {
        driver = BaseDriver.driver("https://o3.openmrs.org/openmrs/spa/login");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Then("Enter username and password")
    public void enter_username_and_password() {
        loginPage.fillLoginMask("admin", "Admin123");
    }
    @Then("Click login button")
    public void click_login_button() {
        loginPage.clickLoginBtn();
    }
    @Then("Verify Home page opened")
    public void verify_home_page_opened() {
        homePage.verifyHomePage();
    }
}
