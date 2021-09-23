package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailErrorPopup;

    @FindBy(xpath = "//div[@class='error-block']")
    private WebElement errorMessageContainer;

    @FindBy(xpath = "//div[@class='error-block']//li[@id='loginErrorMessage']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameFieldVisible() {
        return usernameField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public void clickOnUsernameField() {
        usernameField.click();
    }

    public void enterTextToUsernameField(final String keyword) {
        usernameField.clear();
        usernameField.sendKeys(keyword);
    }

    public void clickOnPasswordField() {
        passwordField.click();
    }

    public boolean isEmailErrorPopupAppears() {
        return emailErrorPopup.isDisplayed();
    }

    public WebElement getEmailErrorPopup() {
        return emailErrorPopup;
    }

    public void enterTextToPasswordField(final String keyword) {
        passwordField.clear();
        passwordField.sendKeys(keyword);
    }

    public boolean isErrorMessageContainerAppears() {
        return errorMessageContainer.isDisplayed();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

}
