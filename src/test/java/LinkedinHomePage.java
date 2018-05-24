import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkedinHomePage extends LinkedinBasePage {

    private WebElement newPostLink;

    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements() {
        newPostLink = webDriver.findElement(By.xpath("//a[@href='https://www.linkedin.com/post/new']"));
    }

    public boolean isHomePageLoaded() {
        return newPostLink.isDisplayed();
    }
}
