package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

/**
 * Login submit Page Object class
 */
public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    @FindBy(id = "session_key-login")
    private WebElement emailField;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;

    /**
     * Constructor of Login submit page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Login submit page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return emailField.isDisplayed();
    }

    /**
     * Method to get text of error message element
     * @return - text of error message element
     */
    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
