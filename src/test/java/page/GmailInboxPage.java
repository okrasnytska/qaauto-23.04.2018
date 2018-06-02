package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailInboxPage extends GmailLoginPage {

    @FindBy(xpath = "//div[@class='aim ain']//a[contains(@title, 'Inbox')]")
    private WebElement inboxMenuSelected;
    @FindBy(xpath = "//tr[1][@class='zA zE']//span[1][@email='security-noreply@linkedin.com']")
    private WebElement lastEmailLinkedin;

    public GmailInboxPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public boolean isGmailInboxPageDisplayed() {
        return inboxMenuSelected.isDisplayed();
    }

    public boolean isLastEmailLinkedinDisplayed() {
        return lastEmailLinkedin.isDisplayed();
    }

    public GmailPasswordResetMailPage openLinkedinMail() {
        lastEmailLinkedin.click();
        return new GmailPasswordResetMailPage(webDriver);
    }
}
