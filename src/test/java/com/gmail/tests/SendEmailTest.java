package com.gmail.tests;

import com.gmail.forms.GmailLoginForm;
import com.gmail.forms.GmailMainForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest extends BaseTest {

    @BeforeMethod
    public void loginToGmail() {
        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login("alektester13@gmail.com", "112233al");
    }

    @Test
    public void sendEmailTest() {
        GmailMainForm gmailMainForm = new GmailMainForm();
        gmailMainForm.writeEmail("alektester13@gmail.com", "sub", "text");
        Assert.assertTrue(gmailMainForm.isEmailDisplayed("sub"));
    }

    @AfterMethod
    public void logoutFromGmail() {
        GmailMainForm gmailMainForm = new GmailMainForm();
        gmailMainForm.logout();
    }
}
