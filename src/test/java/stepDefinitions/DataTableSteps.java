package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.DataTablePage;
import pojo.User;

import java.util.List;

public class DataTableSteps {

    WebDriver driver;
    DataTablePage dataTablePage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
       //driver = Hooks.driver;
       //dataTablePage = new DataTablePage(driver);
        System.out.println("Ilk step calisti");
    }

    @Then("User enters credentials")
    public void user_enters_credentials(DataTable dataTable) {

        List<User> users = dataTable.asList(User.class);
        for (User user:users) {
            System.out.println(user.getUsername() + " " + user.getPassword() );
        }
    }
}
