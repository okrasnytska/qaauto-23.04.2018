package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResultsPage;

import java.util.List;

/**
 * Search Test Object class
 */
public class LinkedinSearchTest extends LinkedinBaseTest {

    /**
     * Method for Linkedin search test
     * Check that 10 results are displayed on one page and each result contains search term
     * String searchTerm can be parametrized for different search term
     */
    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login("ksu.krasik@gmail.com", "10091971q");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home page New post link is not displayed.");

        LinkedinSearchResultsPage linkedinSearchResultsPage = linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchResultsPage.isPageLoaded(), "SearchResults Page is not loaded.");

        List<String> searchResultsList = linkedinSearchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 10, "Count of search result items is wrong.");

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm "+ searchTerm+"was not found in: \n"+searchResult);
        }
    }
}
