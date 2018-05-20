import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkedinHomePage {
    WebDriver webDriver;
    WebElement newPostLink;

    public LinkedinHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        newPostLink = webDriver.findElement(By.xpath("//a[@href='https://www.linkedin.com/post/new']"));
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    public boolean isNewPostLinkDisplayed() {
        return newPostLink.isDisplayed();
    }
}
