import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password']")
    private WebElement forgotPasswordButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }


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

    public LinkedinRequestPasswordResetPage resetPassword() {
        forgotPasswordButton.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }
}
