package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;

public class MenstrualPhaseLogPage {
	WebDriver driver;
	CommonMethods commonMethods;
	
	public MenstrualPhaseLogPage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);	
		}
		
	By navbarBarItems = By.xpath("//div[@class='max-w-7xl mx-auto flex items-center justify-center space-x-4']//button");
	By ActivityInsightsButton =  By.xpath("//span[contains(text(),'Activity Insights')]"); 
	By MentrualPhaseLogDropdown= By.xpath("//a[@href='/track/menstrual-cycle']");
    By UpdateCycleInfoBtn = By.xpath("//span[contains(text(),'Update Cycle Information')]");
    By BacktoDashboard = By.xpath("//span[contains(text(),'Back to Dashboard')]");
    By AddPeriodLog = By.xpath("//span[contains(text(),'Add Period Log')]");
    
	public void waitforActiviyInsightsButton() {
		commonMethods.waitForClickable(ActivityInsightsButton);
	}	
    public void ClickActivityInsightsButton() {
    	
    	    List<WebElement> items = driver.findElements(navbarBarItems);
    	    WebElement activityInsights = items.get(0);

    	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityInsights);
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activityInsights);
    	}    
  
    public boolean isActivityInsightsTextVisible(String expectedText) {
        WebElement btn = commonMethods.waitForVisibility(ActivityInsightsButton);
        return btn.getText().equals(expectedText);
    }

    By menstrualPhaseLogs = By.xpath("//a[@href='/track/menstrual-cycle']");

    public boolean clickMenstrualPhaseLogs() {
        WebElement element = commonMethods.waitForClickable(menstrualPhaseLogs);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return true;
    }
    public boolean isUpdateCycleInfoBtnVisible() {
		return commonMethods.waitForVisibility(UpdateCycleInfoBtn).isDisplayed();	
	}
    
    public boolean isBacktoDashboardBtnVisible() {
		return commonMethods.waitForVisibility(BacktoDashboard).isDisplayed();	
	}
    
    public boolean isAddPeriodLogBtnVisible() {
		return commonMethods.waitForVisibility(AddPeriodLog).isDisplayed();	
	}
}
