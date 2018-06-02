package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.*;


import static java.lang.Thread.sleep;

public class LinkedinResetPasswordTest extends LinkedinBaseTest {


    @Test
    public void successfulResetPasswordValidDataTest() throws InterruptedException {
        String userEmail = "ksu.krasik@gmail.com";
        String newUserPassword = "10091971q";

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Sign in button is not displayed");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickResetPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(), "Submit reset password button is not displayed.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(), "Resend mail button is not displayed");



        /*GmailLoginPage gmailLoginPage = linkedinRequestPasswordResetSubmitPage.goToGmail(webDriver);

        Assert.assertTrue(gmailLoginPage.isGmailLoginPageLoaded(), "Gmail email field is not displayed");
        GmailInboxPage gmailInboxPage = gmailLoginPage.gmailLogin(gmailEmail, gmailPassword);
        Assert.assertTrue(gmailInboxPage.isGmailInboxPageDisplayed(), "Gmail Inbox menu is not displayed.");
        Assert.assertTrue(gmailInboxPage.isLastEmailLinkedinDisplayed(), "Linkedin security mail is not displayed.");

        GmailPasswordResetMailPage gmailPasswordResetMailPage = gmailInboxPage.openLinkedinMail();
        Assert.assertTrue(gmailPasswordResetMailPage.isEmailPasswordResetLinkDisplayed(), "Reset password link in email is not displayed.");
*/
        LinkedinInsertNewPasswordPage linkedinInsertNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinInsertNewPasswordPage.isPageLoaded(), "Reset password submit button is not displayed.");

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinInsertNewPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(), "End password submit button is not displayed.");

        LinkedinHomePage linkedinHomePage = linkedinPasswordResetSubmitPage.endPasswordResetGoToHomePage();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "New post button is not displayed.");
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

}
