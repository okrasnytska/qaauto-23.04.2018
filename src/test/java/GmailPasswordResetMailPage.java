import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class GmailPasswordResetMailPage extends GmailInboxPage {

    @FindBy(xpath = "//body//a[text()='здесь']")
    private WebElement emailPasswordResetLink;

    public GmailPasswordResetMailPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isEmailPasswordResetLinkDisplayed() {
        return emailPasswordResetLink.isDisplayed();
    }

    public LinkedinInsertNewPasswordPage openLinkedinInsertNewPasswordPage() throws InterruptedException {
        String passwordResetLink = emailPasswordResetLink.getAttribute("href");
        webDriver.get(passwordResetLink);
        webDriver.switchTo().alert().accept();
        sleep(5000);
        return PageFactory.initElements(webDriver, LinkedinInsertNewPasswordPage.class);
    }
}
