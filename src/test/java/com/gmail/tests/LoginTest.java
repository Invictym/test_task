package com.gmail.tests;

import com.gmail.forms.GmailLoginForm;
import com.gmail.forms.GmailMainForm;
import framework.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
//        GmailMainForm gmailMainForm = new GmailMainForm();
//        gmailMainForm.login();

        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login("alektester13@gmail.com", "112233al");
    }
}
