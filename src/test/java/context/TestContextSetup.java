package context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import driverFactorySetUp.DriverFactory;
import pageObjects.DashboardPage;
import pageObjects.EditYourProfilePage;

public class TestContextSetup {

	private WebDriver driver;
	private DashboardPage dashboardPage;
    private EditYourProfilePage editProfilePage;
    
    private Map<String, Object> sharedData;
    
    public TestContextSetup() {
        this.driver = DriverFactory.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        this.editProfilePage = new EditYourProfilePage(driver);
        this.sharedData = new HashMap<>();
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public DashboardPage dashboardPage() {
        return dashboardPage;
    }

    public EditYourProfilePage editProfilePage() {
        return editProfilePage;
    }

    public void setScenarioData(String key, Object value) {
    	sharedData.put(key, value);
    }
    
    public Object getScenarioData(String key) {
        return sharedData.get(key);
    }
    
    
    
    
}
