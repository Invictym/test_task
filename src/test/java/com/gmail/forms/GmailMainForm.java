package com.gmail.forms;

import framework.BaseForm;
import framework.ui.Button;
import org.openqa.selenium.By;

public class GmailMainForm extends BaseForm {

    private Button loginBtn = new Button(By.xpath("//div[contains(@class, \"h-c-header__cta--tier-two\")]//a[@ga-event-action=\"sign in\"]"), "Login button");
    private Button userBtn = new Button(By.xpath("//a[contains(@href,\"SignOut\")]"), "Open user view button");
    private Button writeEmailBtn = new Button(By.xpath("//*[@id=\":3b\"]//div[@role=\"button\"]"), " Write email button");
    public GmailAccountViewForm gmailAccountViewForm;

    public GmailMainForm() {
        super(By.xpath("//*"), "Gmail main form");
    }

    public void login() {
        loginBtn.click();
    }

    public void logout() {
        userBtn.click();
        gmailAccountViewForm = new GmailAccountViewForm();
        gmailAccountViewForm.logout();
    }

    public void writeEmail() {
        writeEmailBtn.click();
    }
}
