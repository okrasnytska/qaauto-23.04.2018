package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinLoginSubmitPage;


public class LinkedinLoginTest extends LinkedinBaseTest {

    @DataProvider
    public Object[][] successfulLoginValidDataProvider() {
        return new Object[][]{
               { "ksu.krasik@gmail.com", "10091971q" },
               //{ "KSU.KRASIK@GMAIL.COM", "10091971q" },
        };
    }

    @Test(dataProvider = "successfulLoginValidDataProvider")
    public void successfulLoginValidDataTest(String email, String password) {
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Sign in button is not displayed");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home page New post link is not displayed");
    }

    @DataProvider
    public Object[][] failedLoginPartialDataProvider() {
        return new Object[][]{
                { "ksu.krasik@gmail.com", "" },
               // { "", "10091971q" },
             //   { "", "" },
        };
    }

    @Test (dataProvider = "failedLoginPartialDataProvider")
    public void failedLoginPartialDataTest(String email, String password) {
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Sign in button is not displayed");

        LinkedinLoginPage linkedinLoginPage1 = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinLoginPage1.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage1.isPageLoaded(), "Sign in button is not displayed");
    }

    @DataProvider
    public Object[][] failedLoginInvalidDataProvider() {
        return new Object[][]{
                { "ksu.krasik@gmail.com", "@" },
                //{ "@mail.ru", "10091971q" },
                //{ "ksu.krasik@gmailcom", "10091971q" },
               // { "ksu.krasik@gmail.com", "10091971Q" },
        };
    }

    @Test (dataProvider = "failedLoginInvalidDataProvider")
    public void failedLoginInvalidDataTest(String email, String password) {
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Sign in button is not displayed");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit", "Login-Submit page url is wrong");
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(), "Login-Submit page is not loaded.");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");
    }


}
