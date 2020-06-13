package framework.browser;

import org.openqa.selenium.WebDriver;

public class Browser {

  private static volatile Browser browser = null;
  private static WebDriver driver;

  private Browser() {
    driver = BrowserFactory.init();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public static Browser getBrowser() {
    Browser localBrowser = browser;
    if (localBrowser == null) {
      synchronized (BrowserFactory.class) {
        localBrowser = browser;
        if (localBrowser == null) {
          browser = new Browser();

        }
      }
    }
    return browser;
  }

  public void navigate(final String url) {
    driver.get(url);
  }
}
