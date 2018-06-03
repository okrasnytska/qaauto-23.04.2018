package page;


import org.apache.commons.lang3.StringUtils;
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

    public boolean isPageLoaded() {
        return resendMailButton.isDisplayed();
    }

    public GmailLoginPage goToGmail(WebDriver webDriver) {
        webDriver.get("https://mail.google.com/mail/u/1/#inbox");
        return new GmailLoginPage(webDriver);
    }
    public LinkedinInsertNewPasswordPage navigateToLinkFromEmail() {
        String insertNewPasswordLink = StringUtils.substringBetween(LinkedinRequestPasswordResetPage.gmailMessage, "нажмите <a href="+'"', '"'+" style=").replace("&amp;","&");
        webDriver.get(insertNewPasswordLink);
        return new LinkedinInsertNewPasswordPage(webDriver);
    }
}
