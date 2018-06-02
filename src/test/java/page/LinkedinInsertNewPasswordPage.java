package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

import static java.lang.Thread.sleep;

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

    public LinkedinInsertNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();
    }

    public LinkedinPasswordResetSubmitPage submitNewPassword(String newPassword) throws InterruptedException {
        newPasswordField.sendKeys(newPassword);
        confirmNewPasswordField.sendKeys(newPassword);
        resetPasswordSubmitButton.click();
        sleep(3000);
        return new LinkedinPasswordResetSubmitPage(webDriver);
    }
}
