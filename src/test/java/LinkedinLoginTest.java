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
    public Object[][] validDataProvider() {
        return new Object[][]{
               { "o.a.krasnitskaya@mail.ru", "10091971q" },
               { "O.A.KRASNITSKAYA@MAIL.RU", "10091971q" },
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");

        linkedinLoginPage.login(email, password);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(linkedinHomePage.isHomePageLoaded(), "Home page New post link is not displayed");
    }

    @DataProvider
    public Object[][] partialDataProvider() {
        return new Object[][]{
                { "o.a.krasnitskaya@mail.ru", "" },
                { "", "10091971q" },
                { "", "" },
        };
    }

    @Test (dataProvider = "partialDataProvider")
    public void failedLoginEmptyFieldsTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");

        linkedinLoginPage.login(email, password);

        sleep(3000);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");
    }

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "o.a.krasnitskaya@mail.ru", "1" },
                { "@mail.ru", "10091971q" },
                { "o.a.krasnitskayamail.ru", "10091971q" },
                { "o.a.krasnitskayamail.ru", "10091971Q" },
        };
    }

    @Test (dataProvider = "invalidDataProvider")
    public void failedLoginInvalidCredentialsTest(String email, String password) throws InterruptedException {
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
