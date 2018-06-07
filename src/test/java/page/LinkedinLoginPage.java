package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;
import page.LinkedinHomePage;

/**
 * Login Page Object class
 */
public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password']")
    private WebElement forgotPasswordButton;

    /**
     * Constructor of Login page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Login page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }


    /**
     * Method to login to Linkedin account with multiple results
     * @param email - user email (valid or invalid)
     * @param password - user password (valid or invalid)
     * @param <T> - type of Page object that will be returned
     * @return - page object class depending on user email and password inserted (valid or invalid)
     */
    public <T> T login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(webDriver);
        }
        else if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(webDriver);
        }
        else {
            return (T) this;
        }
    }

    /**
     * Method to start reset of Linkedin password
     * @return - new object of Request password reset page class
     */
    public LinkedinRequestPasswordResetPage clickResetPasswordLink() {
        forgotPasswordButton.click();
        return new LinkedinRequestPasswordResetPage(webDriver);
    }
}
