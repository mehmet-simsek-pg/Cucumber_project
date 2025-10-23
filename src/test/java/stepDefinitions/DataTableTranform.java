package stepDefinitions;

import io.cucumber.java.DataTableType;
import pojo.User;

import java.util.Map;

public class DataTableTranform {

    @DataTableType
    public User userEntry(Map<String, String> row) {
        return new User(
                row.get("username"),
                row.get("password")
        );
    }
}
