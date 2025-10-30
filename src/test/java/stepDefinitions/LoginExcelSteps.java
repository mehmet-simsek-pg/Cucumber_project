package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseDriver;
import utility.ExcelHelper;

import java.util.ArrayList;

public class LoginExcelSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @When("Navigate to home page")
    public void navigateToHomePage() {
        driver = BaseDriver.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
        LOGGER.info("Webpage opened");
    }

    @Then("Enter username password")
    public void enterUsernamePassword() {

        ArrayList<ArrayList<String>> table =
                ExcelHelper
                        .read("src/test/resources/User Credentials.xlsx",
                                "TC_Login", 2);

        loginPage.enterUsernameAndPassSauce(table.get(3).get(0), table.get(3).get(1));
        BaseDriver.threadWait(3);
    }

    @Then("Click login btn")
    public void clickLoginBtn() {

        loginPage.clickLoginBtnSauce();
    }
}
