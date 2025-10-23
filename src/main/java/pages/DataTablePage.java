package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataTablePage extends BasePage{

    @FindBy(id = "user-name")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public DataTablePage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginMask(final String username, final String password) {
        sendKeysToElement(emailInput, username);
        sendKeysToElement(passwordInput, password);
    }

    public void clickLoginBtn() {
        clickElement(loginBtn);
    }
}
