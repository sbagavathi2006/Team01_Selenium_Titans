package context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import driverFactorySetUp.DriverFactory;
import pageObjects.DashboardPage;
import pageObjects.EditYourProfilePage;
import pageObjects.OnBoarding1Page;
import pageObjects.OnBoarding3Page;
import pageObjects.SignUpPage;
import utilities.ExcelUtils;

public class TestContextSetup {

	private WebDriver driver;
	private DashboardPage dashboardPage;
    private EditYourProfilePage editProfilePage;
	private OnBoarding1Page onBrdPage1;
	private OnBoarding3Page onBrdPage4;
	private SignUpPage signUpPage;


    
    private Map<String, Object> sharedData;
    
    public final String EMAIL = "email";
    public final String PASSWORD = "password";
    
    public TestContextSetup() {
        this.driver = DriverFactory.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        this.editProfilePage = new EditYourProfilePage(driver);
        this.onBrdPage1 = new OnBoarding1Page(driver);
        this.onBrdPage4 = new OnBoarding3Page(driver);
        this.signUpPage = new SignUpPage(driver);

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
    
    public OnBoarding1Page onBrdPage1() {
        return onBrdPage1;
    }

    public OnBoarding3Page onBrdPage4() {
        return onBrdPage4;
    }
    
    public SignUpPage signUpPage() {
        return signUpPage;
    }
    
    public void setScenarioData(String key, Object value) {
    	sharedData.put(key, value);
    }
    
    public Object getScenarioData(String key) {
        return sharedData.get(key);
    }
    
    
    
    
}
