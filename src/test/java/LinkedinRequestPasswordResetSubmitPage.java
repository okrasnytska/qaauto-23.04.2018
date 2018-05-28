import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy(id = "resend-url")
    private WebElement resendMailButton;
    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isLinkedinRequestPasswordResetSubmitPageLoaded() {
        return resendMailButton.isDisplayed();
    }

    public GmailLoginPage goToGmail(WebDriver webDriver) {
        webDriver.get("https://mail.google.com/mail/u/1/#inbox");
        return PageFactory.initElements(webDriver, GmailLoginPage.class);
    }
}
