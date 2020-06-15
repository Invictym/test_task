package framework;

import framework.browser.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import framework.config.AutomationAppContext;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntity {

  @BeforeClass
  public void init() {
    getBrowser().navigate(AutomationAppContext.getConfig().getUrl());
  }

  public Browser getBrowser() {
    return Browser.getBrowser(AutomationAppContext.getConfig().getBrowser(), AutomationAppContext.getConfig().getTimeout());
  }

  @AfterClass
  public void exit() {
    getBrowser().close();
  }

  public void openNewWindow() {
    new WebDriverWait(getBrowser().getDriver(), AutomationAppContext.getConfig().getTimeout())
        .until(new ExpectedCondition<Boolean>() {
          @Override
          public Boolean apply(WebDriver driver) {
            return new ArrayList<String>(driver.getWindowHandles()).size() > 1;
          }
        });
    List<String> tabs2 = new ArrayList<String>(getBrowser().getDriver().getWindowHandles());
    getBrowser().getDriver().switchTo().window(tabs2.get(1));
  }
}
