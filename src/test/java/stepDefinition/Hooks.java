package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import driverFactorySetUp.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;


public class Hooks {

private static Logger logger = LogManager.getLogger();

@BeforeAll
public static void loadConfigProp() {
    if (ConfigReader.getProp() == null) {
       ConfigReader.loadProperties();
    }
}

@Before
public void setUp(Scenario scenario) {
    logger.info("Executing scenario: " + scenario.getName());     
    System.out.println("Set browser type from before setup:" + DriverFactory.getBrowser());
    DriverFactory.inItBrowser();
    DriverFactory.setupBrowser();
}

@AfterStep
public void afterStep(Scenario scenario) {
    if (scenario.isFailed()) {
        logger.error("Step Failed, Taking Screenshot");
        final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Failure Screenshot");
    }
}

@After
public void tearDown() {
	logger.info("Closing WebDriver...");
    DriverFactory.quitDriver(); 
}

}




