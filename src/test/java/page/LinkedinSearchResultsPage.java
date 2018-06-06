package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Search results Page Object class
 */
public class LinkedinSearchResultsPage extends LinkedinBasePage {

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//li[contains(@class,'search-result search-result__occluded-item')]")
    private List<WebElement> searchResultElements;

    /**
     * Constructor of Search results Page
     * @param webDriver - current browser instance
     * Page factory method initializes current class elements
     */
    public LinkedinSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchResultsCount, 5);
    }

    /**
     * Method to check the loading of Search results Page element
     * @return - true if element is displayed, false if it is not displayed
     */
    public boolean isPageLoaded() {
        return searchResultsCount.isDisplayed();
    }

    /**
     * Method to get a list of search results text from a list of web elements
     * @return - list of text elements from search results
     */
    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList<>();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
