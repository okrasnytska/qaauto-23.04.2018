package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.*;

/**
 * Password reset Test Object class
 */
public class LinkedinResetPasswordTest extends LinkedinBaseTest {


    /**
     * Method for successful password reset test
     * Can be realized using GmailService class or Gmail pages objects
     * Strings userEmail and newUserPassword can be parametrized for other account
     */
    @Test
    public void successfulResetPasswordValidDataTest() {
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

}
