package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @When("Navigate to the webpage")
    public void navigate_to_the_webpage() {
        driver = Hooks.driver;
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Then("Enter username and password")
    public void enter_username_and_password() {
        loginPage.fillLoginMask("admin123", "Admin123");
    }
    @Then("Click login button")
    public void click_login_button() {
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }
    @Then("Verify Home page opened")
    public void verify_home_page_opened() {
        homePage.verifyHomePage();
        LOGGER.info("Home page opened");
    }

    @Then("Enter invalid username and password")
    public void enterInvalidUsernameAndPassword() {
        loginPage.fillLoginMask("admin", "incorrect");
        LOGGER.info("Incorrect user credentials entered");
    }

    @Then("Verify error message")
    public void verifyErrorMessage() {
        loginPage.verifyErrorMessage();
        LOGGER.info("Error message displayed");
    }

    @Then("Enter username {string} and password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.fillLoginMask(username,password);
        LOGGER.info("User enter login credentials");
    }

    @Then("Verify result {string}")
    public void verifyResult(String result) {
        if (result.equals("home page")) {
            verify_home_page_opened();
        } else {
            verifyErrorMessage();
        }
    }
}
