package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base Page Object class
 */
public abstract class LinkedinBasePage {
    protected WebDriver webDriver;

    /**
     * Constructor of BasePage
     * @param webDriver - current browser instance
     */
    public LinkedinBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Base method to get url of current page
     * @return - url string
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Base method to get title of current page
     * @return - title string
     */
    public  String getCurrentTitle() {
        return webDriver.getTitle();
    }

    /**
     * Method to expand loading page time by waiting for element to be clickable
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
     * Method to expand loading page time by waiting for element to be visible
     * @param webElement - element expected to load
     * @param timeOutInSeconds - period of time to wait for element loading
     * @return - loaded element
     */
        public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * Base method to check the loading of Linkedin pages elements
     * @return - true if element is displayed, false if it is not displayed
     */
    abstract boolean isPageLoaded();

}
