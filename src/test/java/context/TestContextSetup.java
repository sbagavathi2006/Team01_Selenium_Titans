package context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import driverFactorySetUp.DriverFactory;
import pageObjects.DashboardPage;
import pageObjects.EditYourProfilePage;
import pageObjects.OnBoarding1Page;
import pageObjects.OnBoarding3FnPage;
import pageObjects.OnBoarding3Page;
import pageObjects.OnBoarding4Page;
import pageObjects.SignUpPage;
import utilities.ExcelUtils;

public class TestContextSetup {

	private WebDriver driver;
	private DashboardPage dashboardPage;
    private EditYourProfilePage editProfilePage;
	private OnBoarding1Page onBrdPage1;
	private OnBoarding3Page onBrdPage3;
	private OnBoarding3FnPage onBrdPage3Fn;
	private OnBoarding4Page onBrdPage4;
	private SignUpPage signUpPage;


    
    private Map<String, Object> sharedData;
    
    public final String USERNAME = "firstName";
    public final String EMAIL = "email";
    public final String PASSWORD = "password";
    public final String HC = "healthcondition"; //HC-HealthCondition
    public final int AGE = 0;
    public final String BPSTATUS = "bpstatus";
    
    public TestContextSetup() {
        this.driver = DriverFactory.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        this.editProfilePage = new EditYourProfilePage(driver);
        this.onBrdPage1 = new OnBoarding1Page(driver);
        this.onBrdPage3 = new OnBoarding3Page(driver);
        this.onBrdPage4 = new OnBoarding4Page(driver);
        this.signUpPage = new SignUpPage(driver);
        this.onBrdPage3Fn = new OnBoarding3FnPage(driver);

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

    public OnBoarding3Page onBrdPage3() {
        return onBrdPage3;
    }
    
    public OnBoarding3FnPage onBrdPage3Fn() {
        return onBrdPage3Fn;
    }
    
    public OnBoarding4Page onBrdPage4() {
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
