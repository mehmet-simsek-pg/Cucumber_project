package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.DataTablePage;

public class DataTableSteps {

    WebDriver driver;
    DataTablePage dataTablePage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
       driver = Hooks.driver;
       dataTablePage = new DataTablePage(driver);
    }

    @Then("User enters credentials")
    public void user_enters_credentials(DataTable dataTable) {

    }
}
