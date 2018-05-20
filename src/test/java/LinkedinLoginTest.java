import org.openqa.selenium.WebDriver;
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
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "10091971q");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(linkedinHomePage.isNewPostLinkDisplayed(), "Home page New post link is not displayed");
    }

    @Test
    public void negativeLoginTest1() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "1");
        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @Test
    public void negativeLoginTest2() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("", "10091971q");

        sleep(3000);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");
    }

    @Test
    public void negativeLoginTest3() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "");

        sleep(3000);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");
    }

    @Test
    public void negativeLoginTest4() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "10091971Q");

        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @Test
    public void negativeLoginTest5() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("@mail.ru", "10091971q");

        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @Test
    public void negativeLoginTest6() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign in button is not displayed");

        linkedinLoginPage.login("o.a.krasnitskaya@mail.ru", "@@@");

        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
