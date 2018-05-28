import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class GmailLoginPage {
    protected WebDriver webDriver;

    @FindBy(id = "identifierId")
    private WebElement gmailEmailField;

    @FindBy(xpath = "//span[text()='Далее']")
    private WebElement gmailSubmitEmailButton;

    @FindBy(name = "password")
    private WebElement gmailPasswordField;

    @FindBy(xpath = "//span[text()='Далее']")
    private WebElement gmailSubmitPasswordButton;

    public GmailLoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isGmailLoginPageLoaded() {
        return gmailEmailField.isDisplayed();
    }

    public GmailInboxPage gmailLogin(String gmailEmail, String gmailPassword) throws InterruptedException {
        gmailEmailField.sendKeys(gmailEmail);
        gmailSubmitEmailButton.click();
        sleep(3000);
        gmailPasswordField.sendKeys(gmailPassword);
        gmailSubmitPasswordButton.click();
        sleep(3000);
        return PageFactory.initElements(webDriver, GmailInboxPage.class);
    }
}
