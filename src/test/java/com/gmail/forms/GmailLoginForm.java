package com.gmail.forms;

import com.gmail.entity.User;
import framework.BaseForm;
import framework.ui.Button;
import framework.ui.Input;
import org.openqa.selenium.By;

public class GmailLoginForm extends BaseForm {

    private Input emailInp = new Input(By.id("identifierId"), "Email input");
    private Button nextBtn = new Button(By.id("identifierNext"), "Next button");
    private Input passInp = new Input(By.xpath("//input[@type=\"password\"]"), "Password input");
    private Button passNextBtn = new Button(By.id("passwordNext"), "Next password button");

    public GmailLoginForm() {
        super(By.id("initialView"), "Gmail login page");
    }

    public void login(User user) {
        emailInp.sendKey(user.getEmail());
        nextBtn.click();
        passInp.sendKey(user.getPass());
        passNextBtn.click();
    }
}
