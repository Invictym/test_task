package com.gmail.tests;

import com.gmail.entity.User;
import com.gmail.forms.GmailLoginForm;
import com.gmail.forms.GmailMainForm;
import framework.BaseTest;
import framework.logger.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Parameters({"login", "password"})
    @BeforeMethod
    public void loginToGmail(String login, String password) {
        Log.info("Set preconditions");
        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login(new User(login, password));
    }

    @Test
    public void logoutTest() {
        Log.info("Logout from gmail");
        GmailMainForm gmailMainForm = new GmailMainForm();
        gmailMainForm.logout();

        Log.info("Verify login form present");
        Assert.assertTrue(new GmailLoginForm().isFormPresent());
    }
}
