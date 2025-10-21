package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "input[id='username']")
    private WebElement emailInput;

    @FindBy(css = "button[class^='-esm-login']")
    private WebElement continueBtn;

    @FindBy(css = "input[id='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[class^='-esm-login']")
    private WebElement loginBtn;

    @FindBy(css = "div[role='status']>div>div>div:nth-child(1)")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginMask(final String username, final String password) {
        sendKeysToElement(emailInput, username);
        clickElement(continueBtn);
        sendKeysToElement(passwordInput, password);
    }

    public void clickLoginBtn() {
        clickElement(loginBtn);
    }

    public void verifyErrorMessage() {
        verifyDisplayed(errorMessage, "Error");
    }
}
