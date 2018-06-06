package page;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Request password reset submit Page Object class
 */
public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy(id = "resend-url")
    private WebElement resendMailButton;

    /**
     * Constructor of Request password reset submit page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Request password reset submit page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return resendMailButton.isDisplayed();
    }

    /**
     * Method to open Gmail login page
     * @param webDriver - current browser instance
     * @return - new object of Gmail login page class
     */
    public GmailLoginPage goToGmail(WebDriver webDriver) {
        webDriver.get("https://mail.google.com/mail/u/1/#inbox");
        return new GmailLoginPage(webDriver);
    }

    /**
     * Method to get link from Linkedin email via Gmail Service methods and open it
     * @return - new object of Insert new password page class
     */
    public LinkedinInsertNewPasswordPage navigateToLinkFromEmail() {
        String insertNewPasswordLink = StringUtils.substringBetween(LinkedinRequestPasswordResetPage.gmailMessage, "нажмите <a href="+'"', '"'+" style=").replace("&amp;","&");
        webDriver.get(insertNewPasswordLink);
        return new LinkedinInsertNewPasswordPage(webDriver);
    }
}
