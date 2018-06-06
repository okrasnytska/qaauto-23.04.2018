package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;
import page.LinkedinHomePage;

/**
 * Password reset submit Page Object class
 */
public class LinkedinPasswordResetSubmitPage extends LinkedinBasePage {
    @FindBy(id = "reset-password-submit-button")
    private WebElement endPasswordResetButton;

    /**
     * Constructor of Password reset submit page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        waitUntilElementIsClickable(endPasswordResetButton, 10);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Password reset submit page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return endPasswordResetButton.isDisplayed();
    }

    /**
     * Method to end reset of Linkedin password and return to Home page
     * @return - new object of Home page class
     */
    public LinkedinHomePage endPasswordResetGoToHomePage() {
        endPasswordResetButton.click();
        return new LinkedinHomePage(webDriver);
    }
}
