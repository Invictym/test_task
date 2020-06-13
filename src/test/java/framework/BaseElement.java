package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BaseElement extends BaseEntity {

  protected By locator;
  private String name;

  protected BaseElement(final By loc, final String nameOf) {
    locator = loc;
    name = nameOf;
  }

  private void waitForElementPresent() {
    new WebDriverWait(getBrowser().getDriver(), Integer.parseInt(fileWorker.getProperties("timeout")))
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }


  public void click() {
    waitForElementPresent();
    getBrowser().getDriver().findElement(locator).click();
    System.out.println(name + " click");
  }

  public String getText() {
    int attempts = 0;
    boolean result = false;
    String text = null;
    while (attempts < 2) {
      try {
        text = getBrowser().getDriver().findElement(locator).getText();
        result = true;
        break;
      } catch (StaleElementReferenceException e) {

      }
      attempts++;
    }
    Assert.assertTrue(result);
    return text;
  }
  public By getLocator() {
    return locator;
  }


  public boolean elementIsDisplayed() {
    return getBrowser().getDriver().findElement(locator).isDisplayed();
  }

  public void sendKey(String key) {
    waitForElementPresent();
    getBrowser().getDriver().findElement(locator).sendKeys(key);
    System.out.println(name + " set text: " + key);
  }

}
