package com.gmail.forms;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.Input;
import org.openqa.selenium.By;

public class GmailWriteEmailDialogForm extends BaseForm {

    private Input subjectInp = new Input(By.xpath("//input[@name=\"subjectbox\"]"), " Subject input");
    private Input addressInp = new Input(By.xpath("//textarea[@role=\"combobox\"]"), "addres input");
    private Input textInp = new Input(By.xpath("//table[@id='undefined']//div[@aria-label]"), "Body input");
    private Button sendBtn = new Button(By.xpath("//div[contains(@aria-label,\"Enter\")]"), "Send button");

    public GmailWriteEmailDialogForm() {
        super(By.xpath("//div[@role=\"dialog\"]"), "Write email dialog form");
    }

    public void sendEmail(String address, String subject, String text) {
        addressInp.sendKey(address);
        subjectInp.sendKey(subject);
        textInp.sendKey(text);
        sendBtn.click();
    }
}
