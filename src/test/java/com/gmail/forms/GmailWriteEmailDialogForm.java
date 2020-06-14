package com.gmail.forms;

import framework.BaseForm;
import framework.ui.Input;
import org.openqa.selenium.By;

public class GmailWriteEmailDialogForm extends BaseForm {

    private Input subjectInp = new Input(By.xpath("//input[@name=\"subjectbox\"]"), " Subject input");
    private Input addressInput = new Input(By.xpath("//*[@id=\":8j\"]/div/input"), "addres input");

    public GmailWriteEmailDialogForm() {
        super(By.xpath("//div[@role=\"dialog\"]"), "Write email dialog form");
    }
}
