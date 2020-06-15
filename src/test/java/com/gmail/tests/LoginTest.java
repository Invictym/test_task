package com.gmail.tests;

import com.gmail.entity.User;
import com.gmail.forms.GmailLoginForm;
import com.gmail.forms.GmailMainForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Parameters({"login", "password"})
    @Test
    public void loginTest(String login, String password) {
        GmailLoginForm gmailLoginForm = new GmailLoginForm();
        gmailLoginForm.login(new User(login, password));

        Assert.assertTrue(new GmailMainForm().isFormPresent());
    }
}
