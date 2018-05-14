import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoinTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");

        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        WebElement emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        WebElement passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        WebElement signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
        Assert.assertTrue(signInButton.isDisplayed(), "Sign in button is not displayed");
        String actualEmail = "o.a.krasnitskaya@mail.ru";
        String actualPassword = "10091971q";
        String homePageTitle = "LinkedIn";

        // negative case 1: email is empty, password is right
        emailField.clear();
        passwordField.sendKeys(actualPassword);
        signInButton.click();
        Assert.assertFalse(webDriver.getCurrentUrl() == homePageTitle, "User is logged in without email inserted");
        sleep(3000);

        // negative case 2: email is right, password is empty
        emailField.sendKeys(actualEmail);
        passwordField.clear();
        signInButton.click();
        Assert.assertFalse(webDriver.getCurrentUrl() == homePageTitle, "User is logged in without password inserted");
        webDriver.navigate().back();
        sleep(3000);

        // negative case 3: email is right, password is equal to actual, but with caps
        emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
        emailField.sendKeys(actualEmail);
        passwordField.sendKeys("10091971Q");
        signInButton.click();
        Assert.assertFalse(webDriver.getCurrentUrl() == homePageTitle, "User is logged in with wrong password (caps is on)");
        webDriver.navigate().back();
        sleep(3000);

        // negative case 4: email is wrong, password is right
        emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
        emailField.sendKeys("@mail.ru");
        passwordField.sendKeys(actualPassword);
        signInButton.click();
        Assert.assertFalse(webDriver.getCurrentUrl() == homePageTitle, "User is logged in with wrong email");
        webDriver.navigate().back();
        sleep(3000);

        // negative case 5: email is right, password is wrong
        emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
        emailField.sendKeys(actualEmail);
        passwordField.sendKeys("@@@");
        signInButton.click();
        Assert.assertFalse(webDriver.getCurrentUrl() == homePageTitle, "User is logged in with wrong password");
        webDriver.navigate().back();
        sleep(3000);


        // positive case
        emailField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-email']"));
        passwordField = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//form[@class='login-form']/input[@class='login submit-button']"));
        emailField.sendKeys(actualEmail);
        passwordField.sendKeys(actualPassword);
        signInButton.click();
        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page Title did not change after sign in");
        Assert.assertEquals(webDriver.getTitle(), homePageTitle, "Home page title is wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(webDriver.findElement(By.xpath("//a[@href='/feed/']/*[contains(text(), 'Главная')]")).isDisplayed(),
                "Home button is not present");
    }
}
