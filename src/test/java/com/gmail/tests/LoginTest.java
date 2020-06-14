package com.gmail.tests;

import com.gmail.forms.GmailLoginForm;
import framework.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login("alektester13@gmail.com", "112233al");
    }
}
