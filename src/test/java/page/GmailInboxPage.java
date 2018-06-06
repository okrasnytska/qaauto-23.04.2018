package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Gmail Inbox Page Object class
 */
public class GmailInboxPage extends GmailLoginPage {

    @FindBy(xpath = "//div[@class='aim ain']//a[contains(@title, 'Inbox')]")
    private WebElement inboxMenuSelected;
    @FindBy(xpath = "//tr[1][@class='zA zE']//span[1][@email='security-noreply@linkedin.com']")
    private WebElement lastEmailLinkedin;

    /**
     * Constructor of Inbox page
     * @param webDriver - current browser instance extended from Gmail Login page
     * Page factory method initializes current class elements
     */
    public GmailInboxPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Method to check the loading of Inbox page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isGmailInboxPageDisplayed() {
        return inboxMenuSelected.isDisplayed();
    }

    /** Method to check if the last email is unread and the sender is Linkedin security
     * @return - true if email is present, false if it is not present
     */
    public boolean isLastEmailLinkedinDisplayed() {
        return lastEmailLinkedin.isDisplayed();
    }

    /**
     * Method opens Linkedin security email page
     * @return - new object of Email page
     */
    public GmailPasswordResetMailPage openLinkedinMail() {
        lastEmailLinkedin.click();
        return new GmailPasswordResetMailPage(webDriver);
    }
}
