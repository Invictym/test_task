package framework;

import framework.logger.Log;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import java.util.Map;

public class BaseTest extends BaseEntity {

  protected Map<String, String> parameters;

  @BeforeTest
  public void setUp(ITestContext context) {
    Log.info("Get params");
    parameters = context.getCurrentXmlTest().getAllParameters();
  }
}
