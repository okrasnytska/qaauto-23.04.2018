package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResultsPage;

import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest {

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
