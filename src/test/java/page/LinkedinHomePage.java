package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home Page Object class
 */
public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/post/new']")
    private WebElement newPostLink;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchField;

    /**
     * Constructor of Home page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check the loading of Home page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return newPostLink.isDisplayed();
    }

    /**
     * Method to search for any search term
     * @param searchTerm - insert term you want to search for
     * @return - new object of Search results page class
     */
    public LinkedinSearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new LinkedinSearchResultsPage(webDriver);
    }

}
