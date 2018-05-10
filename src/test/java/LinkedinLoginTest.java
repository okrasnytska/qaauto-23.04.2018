import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoinTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");

        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        WebElement emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        WebElement passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        WebElement signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
        Assert.assertTrue(signInButton.isDisplayed(), "Sign in button is not displayed");
        emailField.sendKeys("o.a.krasnitskaya@mail.ru");
        passwordField.sendKeys("10091971");
        signInButton.click();
        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page Title did not change aftr sign in");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Home page title is wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(webDriver.findElement(By.xpath("//a[@href='/feed/']/*[contains(text(), 'Главная')]")).isDisplayed(),
                "Home button is not present");
    }
}
