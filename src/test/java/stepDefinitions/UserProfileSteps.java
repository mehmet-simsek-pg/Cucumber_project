package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class UserProfileSteps {

    @Given("Navigate to register page")
    public void navigate_to_register_page() {
        System.out.println("Register page acildi");
    }

    @When("Enter user info username {string} and email {string}")
    public void enter_user_info_username_and_email(String username, String email) {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }

    @And("Fill the additional details")
    public void fill_the_additional_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> row : data) {
            String field = row.get("field");
            String value = row.get("value");

            System.out.println(field + ":" + value);
        }
    }

    @Then("Verify profile created")
    public void verify_profile_created() {
        System.out.println("Profile basariyla olusturuldu");
    }

}
