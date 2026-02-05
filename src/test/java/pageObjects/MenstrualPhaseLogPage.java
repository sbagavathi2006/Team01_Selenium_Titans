package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

public class MenstrualPhaseLogPage {
	WebDriver driver;
	CommonMethods commonMethods;
	ExcelUtils excel ;
	
	public MenstrualPhaseLogPage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);	
		}
		
	By navbarBarItems = By.xpath("//div[@class='max-w-7xl mx-auto flex items-center justify-center space-x-4']//button");
	By activityInsightsButton = By.xpath("//button[span[text()='Activity Insights']]");
	By MentrualPhaseLogDropdown= By.xpath("//div[@role='menuitem']//a[@href='/track/menstrual-cycle']");
	By menstrualPhaseLogs = By.xpath("//a[@href='/track/menstrual-cycle']");
	By UpdateCycleInfoBtn = By.xpath("//button[span[text()='Update Cycle Information']]");
	By currentCycleStatusUI = By.xpath("//div[contains(@class,'font-medium') and contains(text(),'Day')]");
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
    By menstrualPhaseSideLabel = By.xpath("//span[contains(text(),'Menstrual Phase')]");
    By follicularPhaseSideLabel = By.xpath("//span[contains(text(),'Follicular Phase')]");
    By ovulationPhaseSideLabel = By.xpath("//span[contains(text(),'Ovulation Phase')]");
    By lutealPhaseSidelabel = By.xpath("//span[contains(text(),'Luteal Phase')]");
    By perimenopausePhaseSideLabel = By.xpath("//span[contains(text(),'Perimenopause')]");
    By CurrentPhaseUI = By.xpath("//div[text()='Current Phase']/following-sibling::div[1]");
    By lastPeriodStartedFromUI = By.xpath("//div[text()='Last period started']/following-sibling::div");
    By nextPeriodExpectedFromUI = By.xpath("//div[text()='Next period expected']/following-sibling::div");
    By currentPhaseDetailsUI = By.xpath("//div[@class='text-lg font-medium mb-4']");
    By currentPhaseDescriptionUI = By.xpath("//div[contains(@class,'rounded-md')]/p");
    By upcomingPhasesHeader = By.xpath("//h3[contains(text(),'Upcoming Phases')]");
    By UcomingPhasesText = By.xpath("//p[contains(text(),'Plan ahead with your cycle phases')]");
    By all5PhaseSideSections = By.xpath("//div[contains(@class,'p-3') and contains(@class,'rounded-lg')]");


	public void waitforActiviyInsightsButton() {
		commonMethods.waitForClickable(activityInsightsButton);
	}	
	public void clickActivityInsightsButton() {
	    WebElement activityInsights = driver.findElement(activityInsightsButton);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityInsights);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activityInsights);
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
    public boolean iscurrentCycleStatusVisible() {
		return commonMethods.waitForVisibility(currentCycleStatusUI).isDisplayed();	
		
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
    public String getLastPeriodDate() { 
    	excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
    	String value = excel.getDataAll("onBoarding").get(0) .get("Last Period Date"); 
    	return value;
    	}
    public String getLastPeriodStartedFromUI() { 
    	return driver.findElement(lastPeriodStarted).getText(); 
    } 
    public String getNextPeriodExpectedFromUI() { 
    	return driver.findElement(nextPeriodExpected).getText();
    	}
    public String NextPeriodExpected() { 
    	String lastPeriodDateFromExcel = getLastPeriodDate(); 
        DateTimeFormatter excelFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
        LocalDate lastPeriod = LocalDate.parse(lastPeriodDateFromExcel, excelFormat); 
        LocalDate nextPeriod = lastPeriod.plusDays(28); 
        DateTimeFormatter FromUIpage = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    	return nextPeriod.format(FromUIpage); 
    	}
    public String getCurrentPhaseFromUI() {
        return driver.findElement(CurrentPhaseUI).getText().trim();
    }
    public String getLastPeriodStartedText() {
    	return driver.findElement(lastPeriodStartedFromUI).getText().trim();
    }

    public String getNextPeriodExpectedText() {
        return driver.findElement(nextPeriodExpectedFromUI).getText().trim();
    }

    public String getCurrentPhaseDetailsHeadingText() {
    	return driver.findElement(currentPhaseDetailsUI).getText().trim();     
            }
    public String getCurrentPhaseDescriptionText() {
    	return driver.findElement(currentPhaseDescriptionUI).getText().trim();       
    }
    public boolean isUpcomingPhasesHeaderDisplayed() {      
        return driver.findElement(upcomingPhasesHeader).isDisplayed();
        
    }
    public boolean isUpcomingPhaseTextDisplayed() {        
       return driver.findElement(UcomingPhasesText).isDisplayed();
     }
    public boolean areAllFivePhasesVisible() {
        String menstrual     = commonMethods.waitForVisibility(menstrualPhaseSideLabel).getText();
        String follicular    = commonMethods.waitForVisibility(follicularPhaseSideLabel).getText();
        String ovulation     = commonMethods.waitForVisibility(ovulationPhaseSideLabel).getText();
        String luteal        = commonMethods.waitForVisibility(lutealPhaseSidelabel).getText();
        String perimenopause = commonMethods.waitForVisibility(perimenopausePhaseSideLabel).getText();
        LoggerLoad.info("Menstrual Phase UI text: " + menstrual);
        LoggerLoad.info("Follicular Phase UI text: " + follicular);
        LoggerLoad.info("Ovulation Phase UI text: " + ovulation);
        LoggerLoad.info("Luteal Phase UI text: " + luteal);
        LoggerLoad.info("Perimenopause UI text: " + perimenopause);
        return true;
    }

    public boolean isFivePhasesDisplayed() {
        List<WebElement> FivePhases = driver.findElements(all5PhaseSideSections);
        LoggerLoad.info("Number of phases displayed: " + FivePhases.size());
        return FivePhases.size() == 5;
    }



}





