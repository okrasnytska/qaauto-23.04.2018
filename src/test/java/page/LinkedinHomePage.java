package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/post/new']")
    private WebElement newPostLink;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchField;

    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return newPostLink.isDisplayed();
    }

    public LinkedinSearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new LinkedinSearchResultsPage(webDriver);
    }

}
