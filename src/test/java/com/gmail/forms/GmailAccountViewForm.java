package com.gmail.forms;

import framework.BaseForm;
import framework.ui.Button;
import org.openqa.selenium.By;

public class GmailAccountViewForm extends BaseForm {

    private Button logoutBtn = new Button(By.xpath("//a[contains(@href, \"Logout\")]"), "Logout button");

    public GmailAccountViewForm() {
        super(By.xpath("//div[@img-loaded]"), "Account view");
    }

    public void logout() {
        logoutBtn.click();
    }
}
