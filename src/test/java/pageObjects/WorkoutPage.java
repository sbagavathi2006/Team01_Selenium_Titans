package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class WorkoutPage {

	WebDriver driver;
	CommonMethods commonMethods;
	
	public WorkoutPage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);			
	}
	
	By navbarItems = By.xpath("//div[@class='max-w-7xl mx-auto flex items-center justify-center space-x-4']//button");
	By backToDashboard = By.xpath("//*[@class='text-sm']");
	By workoutButton =  By.xpath("//a[@href='/workouts']/button"); 
	By toastCloseBtn = By.xpath("//button[@toast-close]"); 


	By DailyPersonalisedWorkout = By.xpath("//h1[text()='Daily Personalized Workouts']");
	By DailyWorkoutPlan = By.xpath("//h2[text()='Daily Workout Plan']");
	By AIDescription = By.xpath("//*[contains(text(), 'Fresh AI-powered workout tailored to your current cycle phase')]");
	By messageContainer = By.xpath("//div[contains(@class,'text-center')]");
	By WorkoutText = By.xpath("//h3[contains(text(), 'No workout plan found')]");
	By GenerateWorkoutPlanButton = By.xpath("//button[contains(text(),'Generate Workout Plan')]");
	By LeutalPhaseText = By.xpath("//h3[contains(text(),'Phase Workouts')]");
	By LeutalPhaseDescription = By.xpath("//p[contains(text(),'hormone level')]");
	By BenfitsOfCycleText=By.xpath("//h3[contains(text(),'Benefits of Cycle')]");
	By BenfitsOfCycleDescription= By.xpath("//p[contains(text(),'personalized 7-day workout plan')]");
	By Icons = By.xpath("//div[contains(@class,'bg-purple-100')]");
	By GenratePlanText= By.xpath("//button[contains(text(),'Generate 7-Day Plan')]");
    By FreePlanSpecialbox = By.xpath("//p[contains(text(),'Get your complete weekly workout plan')]");
    By Generate7DayPlanBtn = By.xpath("//button[@data-testid='button-generate-7-day-plan']");
    By PremiumPlanSection=By.xpath("//h3[contains(text(),'Ready to Transform Your Health Journey?')]");
    By PremiumPlanSectionDescription = By.xpath("//p[contains(text(),'Upgrade to access personalized')]");
    By SeePremiumPlansBtn = By.xpath("//button[contains(text(),'See Premium Plans')]");
    
    public void waitforWorkoutButton() {
		commonMethods.waitForClickable(workoutButton);
	}	
    public void ClickWorkoutButton() {
    	
    	    List<WebElement> items = driver.findElements(navbarItems);
    	    WebElement workout = items.get(2);

    	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", workout);
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", workout);
    	}    
    public String getWorkoutButtonText() { 
    	WebElement btn = commonMethods.waitForVisibility(workoutButton);
    	return btn.getText(); 
    	}
    
	public void ClickBackToDashboard() {
		commonMethods.waitForClickable(backToDashboard).click();
		LoggerLoad.info("BackToDashboard link clicked");
	}

	public boolean isBackToDashboardVisible() {
		return commonMethods.waitForVisibility(backToDashboard).isDisplayed();
	}

	public boolean isDailyPersonalizedWorkoutVisible() {
		return commonMethods.waitForVisibility(DailyPersonalisedWorkout).isDisplayed();	
	}

	public boolean isDailyWorkoutPlanVisible() {
		return commonMethods.waitForVisibility(DailyWorkoutPlan).isDisplayed();
	}	
	public boolean isAIDescriptionVisible() {
		return commonMethods.waitForVisibility(AIDescription).isDisplayed();
	}
	public void messageAlignment() {
		WebElement element = commonMethods.waitForVisibility(messageContainer); 
		String textAlign = element.getCssValue("text-align"); 
		Assert.assertEquals(textAlign, "center", "Text is not center-aligned");
	}
	public boolean isWorkoutTextVisible() {
		return commonMethods.waitForVisibility(WorkoutText).isDisplayed();
	}	
	public boolean isGenerateWorkoutPlanButtonVisible() {
		return commonMethods.waitForVisibility(GenerateWorkoutPlanButton).isDisplayed();
	}	
	public boolean isLeutalPhaseTextVisible() {
		return commonMethods.waitForVisibility(LeutalPhaseText).isDisplayed();
	}
	public boolean LeutalPhaseDescription() {
		return commonMethods.waitForVisibility(LeutalPhaseDescription).isDisplayed();
	}	
	public boolean isBenfitsOfCycleTextVisible() {
		return commonMethods.waitForVisibility(BenfitsOfCycleText).isDisplayed();
	}
	public boolean isBenfitsOfCycleDescriptionVisible() {
		return commonMethods.waitForVisibility(BenfitsOfCycleDescription).isDisplayed();
	}
	public void IconsDisplayed() {
		List<WebElement> icons = driver.findElements(Icons);
		Assert.assertEquals(icons.size(), 4);	
	}
	public boolean isGenratePlanTextVisible() {
		return commonMethods.waitForVisibility(GenratePlanText).isDisplayed();
	}
	public boolean isGreenColorVisible() {
		return commonMethods.waitForVisibility(FreePlanSpecialbox).isDisplayed();
	}
	public void getColor() {
	    WebElement element = commonMethods.waitForVisibility(FreePlanSpecialbox);
	    String color = element.getCssValue("color");
	    Assert.assertEquals(color, "rgba(220, 252 ,231,1)","Color is not green");
	}
	public boolean isSpecialPlanTextDescriptionVisible() {
		return commonMethods.waitForVisibility(FreePlanSpecialbox).isDisplayed();
	}
	public boolean isGenerate7DayPlanBtnVisible() {
		return commonMethods.waitForVisibility(Generate7DayPlanBtn).isDisplayed();
	}
   public void PremiumPlanSectionAlignment() {	
		    WebElement element = commonMethods.waitForVisibility(PremiumPlanSection);
		    int elementX = element.getLocation().getX();
		    int elementWidth = element.getSize().getWidth();
		    int elementCenter = elementX + (elementWidth / 2);
		    int pageWidth = driver.manage().window().getSize().getWidth();
		    int pageCenter = pageWidth / 2;
		    Assert.assertTrue(elementCenter > pageCenter, "Premium Plans card is not on the right side of the page");
		}

   public void getPurpleColor() {
	    WebElement element = commonMethods.waitForVisibility(PremiumPlanSection);
	    String color = element.getCssValue("color");
	    Assert.assertEquals(color, "rgb(168, 85, 247)","Color is not Purple");
	}
   public boolean isPremiumPlanSectionDescriptionVisible() {
		return commonMethods.waitForVisibility(PremiumPlanSectionDescription).isDisplayed();
	}
      public boolean isSeePremiumPlansBtnVisible() {
		return commonMethods.waitForVisibility(SeePremiumPlansBtn).isDisplayed();
	}
 }
	
	
	
	


