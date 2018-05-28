import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    @FindBy(xpath = "//li-icon[@type='error-pebble-icon']")
    private WebElement accountNotFoundMessage;

    @FindBy(id = "user-name-error")
    private WebElement userNameErrorMessage;

    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinRequestPasswordResetSubmitPage successfulResetPasswordSubmit(String email) {
        emailField.sendKeys(email);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetSubmitPage.class);
    }

    public boolean isLinkedinRequestPasswordResetPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();
    }
}
