package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;
import util.GMailService;

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

    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String email) {
        GMailService gMailService = new GMailService();
        gMailService.connect();
        emailField.sendKeys(email);
        resetPasswordSubmitButton.click();
        gmailMessage = gMailService.waitMessage("Ksu, данное сообщение содержит ссылку для изменения пароля", "ksu.krasik@gmail.com", "security-noreply@linkedin.com", 10);
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }

    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();
    }
}
