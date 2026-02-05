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
	By activityInsightsButton = By.xpath("//button[span[text()='Activity Insights']]");
	By MentrualPhaseLogDropdown= By.xpath("//div[@role='menuitem']//a[@href='/track/menstrual-cycle']");
	By menstrualPhaseLogs = By.xpath("//a[@href='/track/menstrual-cycle']");
	By UpdateCycleInfoBtn = By.xpath("//button[span[text()='Update Cycle Information']]");
	By currentCycleStatus = By.xpath("//h2[contains(., 'Current Cycle Status')]");
    By BacktoDashboard = By.xpath("//span[contains(text(),'Back to Dashboard')]");
    By AddPeriodLog = By.xpath("//button[span[text()='Add Period Log']]");
    By cycleOverviewTab = By.xpath("//button[text()='Cycle Overview']");
    By menstrualCalendarTab = By.xpath("//button[text()='Menstrual Calendar']");
    By periodHistoryTab = By.xpath("//button[text()='Period History']");
    By currentPhase = By.xpath("//div[text()='Current Phase']");
    By lastPeriodStarted = By.xpath("//div[text()='Last period started']");
    By nextPeriodExpected = By.xpath("//div[text()='Next period expected']");
    By cycleText = By.xpath("//div[contains(text(),'day cycle')]");
    By progressBar = By.xpath("//div[@role='progressbar']");
    By progressBarFill = By.xpath("//div[@role='progressbar']//div");
    By menstrualLabel = By.xpath("//div[text()='Menstrual']");
    By follicularLabel = By.xpath("//div[text()='Follicular']");
    By ovulationLabel = By.xpath("//div[text()='Ovulation']");
    By lutealLabel = By.xpath("//div[text()='Luteal']");

	public void waitforActiviyInsightsButton() {
		commonMethods.waitForClickable(activityInsightsButton);
	}	
	public void clickActivityInsightsButton() {
	    WebElement activityInsights = driver.findElement(activityInsightsButton);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityInsights);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activityInsights);
	//	commonMethods.waitForClickable(activityInsightsButton).click();
	}
     
    public boolean isActivityInsightsTextVisible(String expectedText) {
        WebElement btn = commonMethods.waitForVisibility(activityInsightsButton);
        return btn.getText().equals(expectedText);
    }

    

    public boolean clickMenstrualPhaseLogs() {         
          WebElement logs = commonMethods.waitForClickable(menstrualPhaseLogs); 
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logs); 
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logs);    
            return true; 
        }
    
    public boolean isUpdateCycleInfoBtnVisible() {
        WebElement btn = commonMethods.waitForVisibility(UpdateCycleInfoBtn);
        return btn.isDisplayed();
    }

    
    public boolean isBacktoDashboardBtnVisible() {
		return commonMethods.waitForVisibility(BacktoDashboard).isDisplayed();	
	}
    
    public boolean isAddPeriodLogBtnVisible() {
		return commonMethods.waitForVisibility(AddPeriodLog).isDisplayed();	
	}
    public boolean isUpdateCycleInfoPresent() {
        List<WebElement> buttons = driver.findElements(
            By.xpath("//div[contains(@class,'flex-col')]//button")
        );
        for (WebElement btn : buttons) {
             btn.getText().trim().equals("Update Cycle Information") ;
        }
        return true;
    }
    public boolean isFiveSectionsVisible() {       
       commonMethods.waitForVisibility(By.xpath("//h3[text()='Current Cycle Status']"));
      commonMethods.waitForVisibility(By.xpath("//h3[text()='Upcoming Phases']"));
      commonMethods.waitForVisibility(By.xpath("//h3[text()='Recommended Activities']"));
       commonMethods.waitForVisibility(By.xpath("//h3[text()='Nutrition Tips']"));
       commonMethods.waitForVisibility(By.xpath("//h3[text()='Next Period']"));
            return true;
        }
    public boolean isCycleOverviewTabVisible() {
        return commonMethods.waitForVisibility(cycleOverviewTab).isDisplayed();
    }
    public boolean isMenstrualCalendarTabVisible() {
        return commonMethods.waitForVisibility(menstrualCalendarTab).isDisplayed();
    }
    public boolean isPeriodHistoryTabVisible() {
        return commonMethods.waitForVisibility(periodHistoryTab).isDisplayed();
    }
    public boolean isCurrentPhaseVisible() {
        return commonMethods.waitForVisibility(currentPhase).isDisplayed();
    }

    public boolean isLastPeriodStartedVisible() {
        return commonMethods.waitForVisibility(lastPeriodStarted).isDisplayed();
    }

    public boolean isNextPeriodExpectedVisible() {
        return commonMethods.waitForVisibility(nextPeriodExpected).isDisplayed();
    }
    public boolean isProgressBarVisible() {
       commonMethods.waitForVisibility(cycleText);
       commonMethods.waitForVisibility(progressBar);
       commonMethods.waitForVisibility(progressBarFill);
            return true;      
    }
    public boolean isMenstrualLabelVisible() {      
            return commonMethods.waitForVisibility(menstrualLabel).isDisplayed();                 
    }
    public boolean isFollicularLabelVisible() {        
            return commonMethods.waitForVisibility(follicularLabel).isDisplayed();        
    }
    public boolean isOvulationLabelVisible() {
          return commonMethods.waitForVisibility(ovulationLabel).isDisplayed();        
    }

    public boolean isLutealLabelVisible() {     
            return commonMethods.waitForVisibility(lutealLabel).isDisplayed();        
    }




}
