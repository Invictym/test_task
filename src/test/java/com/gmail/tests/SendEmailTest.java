package com.gmail.tests;

import com.gmail.entity.User;
import com.gmail.forms.GmailLoginForm;
import com.gmail.forms.GmailMainForm;
import framework.BaseTest;
import framework.logger.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {

    @Parameters({"login", "password"})
    @BeforeMethod
    public void loginToGmail(String login, String password) {
        Log.info("Set preconditions");
        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login(new User(login, password));
    }

    @Parameters({"send_address", "email_subject", "email_body"})
    @Test
    public void sendEmailTest(String address, String emailSubject, String emailBody) {
        Log.info("Sent email");
        GmailMainForm gmailMainForm = new GmailMainForm();
        gmailMainForm.writeEmail(address, emailSubject, emailBody);

        Log.info("Verify email");
        Assert.assertTrue(gmailMainForm.isEmailDisplayed(emailSubject));
    }

    @AfterMethod
    public void logoutFromGmail() {
        Log.info("Logout from gmail");
        GmailMainForm gmailMainForm = new GmailMainForm();
        gmailMainForm.logout();
    }
}
