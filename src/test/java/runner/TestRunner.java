package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import driverFactorySetUp.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports/Team01_Selenium_Titans.html",
				  "json:target/cucumber-reports/Team01_Selenium_Titans.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		monochrome = false,

		//tags = "@checking",

		features = {"src/test/resources/features/"},
		glue = {"stepDefinition"})

public class TestRunner extends AbstractTestNGCucumberTests {
	@Parameters({ "browser" })
	public void defineBrowser(@Optional String browser) {
		DriverFactory.setBrowserName(browser);
	}

@Override
@DataProvider(parallel = false)
public Object[][] scenarios() {
		return super.scenarios();
	}

}
