package framework;

import framework.logger.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.config.AutomationAppContext;
import org.testng.Assert;

public abstract class BaseElement extends BaseEntity {

  protected By locator;
  private String name;

  protected BaseElement(final By loc, final String nameOf) {
    locator = loc;
    name = nameOf;
  }

  public void waitForElementPresent() {
    waitForElementPresent(AutomationAppContext.getConfig().getTimeout());
  }

  public void waitForElementPresent(int timeout) {
    Log.info("Wait for element present: " + name);
    new WebDriverWait(getBrowser().getDriver(), timeout)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }

  public void waitWithoutException() {
    Log.info("Wait for element present: " + name);
    try {
      waitForElementPresent();
    } catch (StaleElementReferenceException ex) {
      Log.info("Info: element not found");
    }
  }

  public void click() {
    waitForElementPresent();
    getBrowser().getDriver().findElement(locator).click();
    Log.info(name + " click");
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
    Log.info("Get text from element: " + name);
    return text;
  }

  public By getLocator() {
    return locator;
  }

  public boolean elementIsDisplayed() {
    Log.info("Is element present: " + name);
    return getBrowser().getDriver().findElement(locator).isDisplayed();
  }

  public void sendKey(String key) {
    waitForElementPresent();
    getBrowser().getDriver().findElement(locator).sendKeys(key);
    Log.info(name + " set text: " + key);
  }
}
