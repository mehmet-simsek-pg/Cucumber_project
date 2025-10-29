package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("Ilk step calisti");
    }

    @Then("User enters credentials")
    public void user_enters_credentials(DataTable dataTable) {

        /** POJO ile datatable kullanimi
        List<User> users = dataTable.asList(User.class);
        for (User user:users) {
            System.out.println(user.getUsername() + " " + user.getPassword() );
        }
         */
        List<Map<String,String>> users = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> user : users) {
            String username = user.get("username");
            String password = user.get("password");
            System.out.println(username + " " + password);
        }
    }
}
