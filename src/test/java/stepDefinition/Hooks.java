package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driverFactorySetUp.DriverFactory;
import io.cucumber.java.After;
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
    String browser = DriverFactory.getBrowserName();
    System.out.println("Set browser type from before setup:" + browser);
    if (browser == null) {
       browser = ConfigReader.getProperty("browser");
    }
    DriverFactory.inItBrowser();
    DriverFactory.setupBrowser();
}
}




