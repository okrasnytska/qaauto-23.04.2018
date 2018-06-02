package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.GmailInboxPage;

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

    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public GmailInboxPage gmailLogin(String gmailEmail, String gmailPassword) throws InterruptedException {
        gmailEmailField.sendKeys(gmailEmail);
        gmailSubmitEmailButton.click();
        waitUntilElementIsClickable(gmailPasswordField, 10);
        gmailPasswordField.sendKeys(gmailPassword);
        gmailSubmitPasswordButton.click();

        return new GmailInboxPage(webDriver);
    }
}
