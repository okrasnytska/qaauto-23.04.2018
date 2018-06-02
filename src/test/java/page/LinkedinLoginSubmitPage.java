package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    @FindBy(id = "session_key-login")
    private WebElement emailField;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;


    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public boolean isPageLoaded() {
        return emailField.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
