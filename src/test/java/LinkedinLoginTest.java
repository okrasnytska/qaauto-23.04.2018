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

    @DataProvider
    public Object[][] successfulLoginValidDataProvider() {
        return new Object[][]{
               { "o.a.krasnitskaya@mail.ru", "10091971q" },
               //{ "O.A.KRASNITSKAYA@MAIL.RU", "10091971q" },
        };
    }

    @Test(dataProvider = "successfulLoginValidDataProvider")
    public void successfulLoginValidDataTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(linkedinHomePage.isHomePageLoaded(), "Home page New post link is not displayed");
    }

    @DataProvider
    public Object[][] failedLoginPartialDataProvider() {
        return new Object[][]{
                { "o.a.krasnitskaya@mail.ru", "" },
                { "", "10091971q" },
                { "", "" },
        };
    }

    @Test (dataProvider = "failedLoginPartialDataProvider")
    public void failedLoginPartialDataTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");

        linkedinLoginPage.login(email, password);

        sleep(3000);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");
    }

    @DataProvider
    public Object[][] failedLoginInvalidDataProvider() {
        return new Object[][]{
                { "o.a.krasnitskaya@mail.ru", "@" },
                { "@mail.ru", "10091971q" },
                { "o.a.krasnitskayamail.ru", "10091971q" },
                { "o.a.krasnitskaya@mail.ru", "10091971Q" },
        };
    }

    @Test (dataProvider = "failedLoginInvalidDataProvider")
    public void failedLoginInvalidDataTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");

        linkedinLoginPage.login(email, password);

        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(), "Login-Submit page is not loaded.");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }

        @AfterMethod
    public void after() {

        webDriver.close();
    }
}
