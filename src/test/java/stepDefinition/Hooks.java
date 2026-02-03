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
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.GoogleDriveDownloader;

public class Hooks {

private static Logger logger = LogManager.getLogger();
private static boolean isExcelDownloaded = false;

@BeforeAll
public static void downloadTestData() {
	
	 if (ConfigReader.getProp() == null) {
         ConfigReader.loadProperties();
         logger.info("Config properties loaded successfully");
     }
	 
    if (!isExcelDownloaded) {
        String fileId = "1EoabtMzSHkckM33lWEhj-7crq78AJsjl"; 
        String localPath = ConfigReader.getProperty("test_data_path");
        try {
            GoogleDriveDownloader.downloadExcelFromDrive(fileId, localPath);
            isExcelDownloaded = true;
            logger.info("Test data Excel downloaded successfully: " + localPath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to download test data Excel. Tests cannot run.");
        }
    }
}

@Before
public void setUp(Scenario scenario) {

    logger.info("Executing scenario: " + scenario.getName());     
    System.out.println("Set browser type from before setup:" + DriverFactory.getBrowser());
    DriverFactory.getDriver();
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




