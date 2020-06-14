package com.gmail.forms;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.Label;
import framework.utils.DateFormat;
import org.openqa.selenium.By;

public class GmailMainForm extends BaseForm {

    private Button userBtn = new Button(By.xpath("//a[contains(@href,\"SignOut\")]"), "Open user view button");
    private Button writeEmailBtn = new Button(By.xpath("//div[@role=\"button\" and @gh=\"cm\"]"), " Write email button");
    private String emailXPath = "//table[@role='grid']//tr//span[text()=\"%s\"]/ancestor::tr//span[@title]//span[contains(text(),\"%s\")]";
    public GmailAccountViewForm gmailAccountViewForm;
    public GmailWriteEmailDialogForm gmailWriteEmailDialogForm;

    public GmailMainForm() {
        super(By.xpath("//*"), "Gmail main form");
    }

    public boolean isEmailDisplayed(String sub) {
        Label label;
        for (int i = 0; i < 5; i++) {
            label = new Label(By.xpath(String.format(emailXPath, sub, DateFormat.getTime())), "Email with sub: [" + sub + "]");
            label.waitWithoutException();
            if (label.elementIsDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public void logout() {
        userBtn.click();
        gmailAccountViewForm = new GmailAccountViewForm();
        gmailAccountViewForm.logout();
    }

    public void writeEmail(String to, String subject, String text) {
        writeEmailBtn.click();
        gmailWriteEmailDialogForm = new GmailWriteEmailDialogForm();
        gmailWriteEmailDialogForm.sendEmail(to, subject, text);
    }
}
