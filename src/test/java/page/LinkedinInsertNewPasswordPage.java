package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

/**
 * Insert new password Page Object class
 */
public class LinkedinInsertNewPasswordPage extends LinkedinBasePage {

    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmNewPasswordField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    @FindBy(id = "new-password-error")
    private WebElement newPasswordErrorMessage;

    @FindBy(id = "confirm-password-error")
    private WebElement confirmNewPasswordErrorMessage;

    /**
     * Constructor of Insert new password page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinInsertNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Insert new password page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();
    }

    /**
     * Method for submitting of new user password
     * @param newPassword - new user password and password confirmation
     * @return - new object of Password reset Submit page class
     */
    public LinkedinPasswordResetSubmitPage submitNewPassword(String newPassword) {
        newPasswordField.sendKeys(newPassword);
        confirmNewPasswordField.sendKeys(newPassword);
        resetPasswordSubmitButton.click();
        return new LinkedinPasswordResetSubmitPage(webDriver);
    }
}
