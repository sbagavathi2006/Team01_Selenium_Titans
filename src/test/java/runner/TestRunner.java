package runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import utilities.DriverFactory;


@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports/Team01_Selenium_Titans.html",
				  "json:target/cucumber-reports/Team01_Selenium_Titans.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		monochrome = false,
		
		features = {"src/test/resources/features"},
		glue = {"stepDefinition"})
		
public class TestRunner extends AbstractTestNGCucumberTests {
	//private static Logger logger = LogManager.getLogger();	
	
	@Parameters({"browser"})
	public void defineBrowser(@Optional String browser) {
	//	logger.info("Set browser type from beforetest:" + browser);
	//	DriverFactory.setBrowserName(browser);
	}
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
		
}