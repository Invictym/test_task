package com.gmail.forms;

import framework.BaseForm;
import framework.ui.Button;
import org.openqa.selenium.By;

public class GmailMainForm extends BaseForm {

    private Button loginBtn = new Button(By.xpath("//div[contains(@class, \"h-c-header__cta--tier-two\")]//a[@ga-event-action=\"sign in\"]"), "Login button");

    public GmailMainForm() {
        super(By.xpath("//main[@class='g-gmail-main']"), "Gmail main form");
    }

    public void login() {
        loginBtn.click();
    }
}
