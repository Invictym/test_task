package framework;

import framework.ui.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;

public abstract class BaseForm extends BaseEntity {

  public String title;
  private By locator;

  public BaseForm(final By formLocator, final String formTitle) {
    locator = formLocator;
    title = formTitle;
    Label titlePicture = new Label(formLocator, title);
    titlePicture.waitWithoutException();
    Assert.assertTrue(titlePicture.elementIsDisplayed());
  }

  public boolean isFormPresent() {
    return new Label(locator, title).elementIsDisplayed();
  }
}

