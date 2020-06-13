package framework;

import framework.ui.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;


public abstract class BaseForm extends BaseEntity {

  public String title;

  public BaseForm(final By formLocator, final String formTitle) {
    long before = new Date().getTime();
    title = formTitle;
    Label titlePicture = (Label) new Label(formLocator, title);
    Assert.assertTrue(titlePicture.elementIsDisplayed());
  }
}

