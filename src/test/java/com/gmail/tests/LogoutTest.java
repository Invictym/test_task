package com.gmail.tests;

import com.gmail.forms.GmailLoginForm;
import com.gmail.forms.GmailMainForm;
import framework.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void loginToGmail() {
        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login("alektester13@gmail.com", "112233al");
    }

    @Test
    public void logoutTest() {
        GmailMainForm gmailMainForm = new GmailMainForm();
        gmailMainForm.logout();

        new GmailLoginForm();
    }
}
