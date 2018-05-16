import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() throws InterruptedException {
        webDriver = new FirefoxDriver();
        sleep (3000);
        webDriver.get("https://www.linkedin.com");
    }
    @Test
    public void successfulLoinTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "10091971q");

        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page Title did not change after sign in");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Home page title is wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(webDriver.findElement(By.xpath("//a[@href='/feed/']/*[contains(text(), 'Главная')]")).isDisplayed(),
                "Home button is not present");
    }

    @Test
    public void negativeLoginTest1() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "1");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(currentPageTitle, "Войти в LinkedIn", "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @Test
    public void negativeLoginTest2() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("", "10091971q");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/", "Login page url is wrong");
        Assert.assertEquals(currentPageTitle, "LinkedIn: Войти или зарегистрироваться", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

    }

    @Test
    public void negativeLoginTest3() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "");

        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/", "Login page url is wrong");
        Assert.assertEquals(currentPageTitle, "LinkedIn: Войти или зарегистрироваться", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");
    }

    @Test
    public void negativeLoginTest4() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "10091971Q");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(currentPageTitle, "Войти в LinkedIn", "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @Test
    public void negativeLoginTest5() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("@mail.ru", "10091971q");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(currentPageTitle, "Войти в LinkedIn", "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @Test
    public void negativeLoginTest6() throws InterruptedException {
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "@@@");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(currentPageTitle, "Войти в LinkedIn", "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
