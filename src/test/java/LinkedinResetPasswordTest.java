import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import static java.lang.Thread.sleep;

public class LinkedinResetPasswordTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() throws InterruptedException {
        webDriver = new FirefoxDriver();
        sleep(3000);
        webDriver.get("https://www.linkedin.com");
        sleep(3000);
    }
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][] {
                {"ksu.krasik@gmail.com", "ksu.krasik@gmail.com", "04121978Ljrex", "10091971q", "10091971q"},
               // {}
        };
    }
    @Test (dataProvider = "validDataProvider")
    public void successfulResetPasswordValidDataTest(String email, String gmailEmail, String gmailPassword, String newPassword, String confirmNewPassword) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertTrue(linkedinLoginPage.isLoginPageLoaded(), "Sign in button is not displayed");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.resetPassword();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isLinkedinRequestPasswordResetPageLoaded(), "Submit reset password button is not displayed.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.successfulResetPasswordSubmit(email);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isLinkedinRequestPasswordResetSubmitPageLoaded(), "Resend mail button is not displayed");

        GmailLoginPage gmailLoginPage = linkedinRequestPasswordResetSubmitPage.goToGmail(webDriver);
        sleep(3000);
        Assert.assertTrue(gmailLoginPage.isGmailLoginPageLoaded(), "Gmail email field is not displayed");
        GmailInboxPage gmailInboxPage = gmailLoginPage.gmailLogin(gmailEmail, gmailPassword);
        Assert.assertTrue(gmailInboxPage.isGmailInboxPageDisplayed(), "Gmail Inbox menu is not displayed.");
        Assert.assertTrue(gmailInboxPage.isLastEmailLinkedinDisplayed(), "Linkedin security mail is not displayed.");

        GmailPasswordResetMailPage gmailPasswordResetMailPage = gmailInboxPage.openLinkedinMail();
        Assert.assertTrue(gmailPasswordResetMailPage.isEmailPasswordResetLinkDisplayed(), "Reset password link in email is not displayed.");

        LinkedinInsertNewPasswordPage linkedinInsertNewPasswordPage = gmailPasswordResetMailPage.openLinkedinInsertNewPasswordPage();
        Assert.assertTrue(linkedinInsertNewPasswordPage.isLinkedinInsertNewPasswordPageLoaded(), "Reset password submit button is not displayed.");

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinInsertNewPasswordPage.submitNewPassword(newPassword, confirmNewPassword);
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isLinkedinPasswordResetSubmitPageDisplayed(), "End password submit button is not displayed.");

        LinkedinHomePage linkedinHomePage = linkedinPasswordResetSubmitPage.endPasswordResetGoToHomePage();
        Assert.assertTrue(linkedinHomePage.isHomePageLoaded(), "New post button is not displayed.");
    }

    @DataProvider
    public Object[][] invalidEmailDataProvider() {
        return new Object[][] {
                {},
                {}
        };
    }
    @Test
    public void failedResetPasswordInvalidEmailTest() {

    }

    @DataProvider
    public Object[][] invalidPasswordDataProvider() {
        return new Object[][] {
                {},
                {}
        };
    }
    @Test
    public void failedResetPasswordInvalidPasswordTest() {

    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
