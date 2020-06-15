package framework.browser;

import org.openqa.selenium.WebDriver;

public class Browser {

  private static volatile Browser browser = null;
  private static WebDriver driver;

  private Browser(String browser, int timeout) {
    driver = BrowserFactory.init(browser, timeout);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public static Browser getBrowser(String browserType, int timeout) {
    Browser localBrowser = browser;
    if (localBrowser == null) {
      synchronized (BrowserFactory.class) {
        localBrowser = browser;
        if (localBrowser == null) {
          browser = new Browser(browserType, timeout);

        }
      }
    }
    return browser;
  }

  public void navigate(final String url) {
    driver.get(url);
  }

  public void close() {
    driver.quit();
    browser = null;
  }
}
