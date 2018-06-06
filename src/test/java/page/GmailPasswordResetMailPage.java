package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.GmailInboxPage;


/**
 * Linkedin mail for password reset Page Object class
 */
public class GmailPasswordResetMailPage extends GmailInboxPage {

    @FindBy(xpath = "//body//a[text()='здесь']")
    private WebElement emailPasswordResetLink;

    /**
     * Constructor of Password reset mail page
     * @param webDriver - current browser instance extended from Gmail Login page
     * Page factory method initializes current class elements
     */
    public GmailPasswordResetMailPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Password reset mail page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isEmailPasswordResetLinkDisplayed() {
        return emailPasswordResetLink.isDisplayed();
    }

    /**
     * Method to open a Linkedin link to reset password
     * @return - new object of Linkedin new password insert page
     */
    public LinkedinInsertNewPasswordPage openLinkedinInsertNewPasswordPage() {
        String passwordResetLink = emailPasswordResetLink.getAttribute("href");
        webDriver.get(passwordResetLink);
        webDriver.switchTo().alert().accept();
        return new LinkedinInsertNewPasswordPage(webDriver);
    }
}
