package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;


public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/post/new']")
    private WebElement newPostLink;

    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return newPostLink.isDisplayed();
    }

}
