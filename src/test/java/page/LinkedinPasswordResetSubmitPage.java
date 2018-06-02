package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;
import page.LinkedinHomePage;

public class LinkedinPasswordResetSubmitPage extends LinkedinBasePage {
    @FindBy(id = "reset-password-submit-button")
    private WebElement endPasswordResetButton;

    public LinkedinPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return endPasswordResetButton.isDisplayed();
    }

    public LinkedinHomePage endPasswordResetGoToHomePage() {
        endPasswordResetButton.click();
        return new LinkedinHomePage(webDriver);
    }
}
