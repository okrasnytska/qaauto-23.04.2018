package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;
import util.GMailService;

/**
 * Request password reset Page Object class
 */
public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    @FindBy(xpath = "//li-icon[@type='error-pebble-icon']")
    private WebElement accountNotFoundMessage;

    @FindBy(id = "user-name-error")
    private WebElement userNameErrorMessage;

    public static String gmailMessage;

    /**
     * Constructor of Request password reset Page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to submit user email and get Linkedin message from gmail via GmailService methods
     * @param email - user email
     * @return - new object of Request password reset submit page class
     */
    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String email) {
        GMailService gMailService = new GMailService();
        gMailService.connect();
        emailField.sendKeys(email);
        resetPasswordSubmitButton.click();
        gmailMessage = gMailService.waitMessage("Ksu, данное сообщение содержит ссылку для изменения пароля", "ksu.krasik@gmail.com", "security-noreply@linkedin.com", 10);
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }

    /**
     * Method to check the loading of Request password reset Page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();
    }
}
