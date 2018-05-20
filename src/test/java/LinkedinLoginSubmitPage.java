import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage {
    WebDriver webDriver;
    WebElement errorMessage;
    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
