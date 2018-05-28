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


    public LinkedinHomePage validDataLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }
    public LinkedinLoginPage partialDataLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinLoginPage.class);
    }
    public LinkedinLoginSubmitPage invalidDataLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinLoginSubmitPage.class);
    }
    public boolean isLoginPageLoaded(){
        return signInButton.isDisplayed();
    }

    public LinkedinRequestPasswordResetPage resetPassword() {
        forgotPasswordButton.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }
}
