import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage {

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements() {
        emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }
}
