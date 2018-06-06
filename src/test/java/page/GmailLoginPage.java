package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Gmail Login Page Object class
 */
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

    /**
     * Constructor of Inbox page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public GmailLoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Login page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isGmailLoginPageLoaded() {
        return gmailEmailField.isDisplayed();
    }

    /**
     * Method to expand loading page time by waiting for element
     * @param webElement - element expected to load
     * @param timeOutInSeconds - period of time to wait for element loading
     * @return - loaded element
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     * Method to successfully login to Gmail
     * @param gmailEmail - user email
     * @param gmailPassword - user password
     * @return - new object of Gmail inbox page
     */
    public GmailInboxPage gmailLogin(String gmailEmail, String gmailPassword) {
        gmailEmailField.sendKeys(gmailEmail);
        gmailSubmitEmailButton.click();
        waitUntilElementIsClickable(gmailPasswordField, 10);
        gmailPasswordField.sendKeys(gmailPassword);
        gmailSubmitPasswordButton.click();

        return new GmailInboxPage(webDriver);
    }
}
