package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
		By backToDashboard = By.xpath("//*[@class='text-sm']");
	    By workoutLink = By.xpath("//a[@href='/workouts']/button");	  
	    By DailyPersonalisedWorkout= By.xpath("//h1[text()='Daily Personalized Workouts']");
	    By DailyWorkoutPlan= By.xpath("//h2[text()='Daily Workout Plan']");
	    
		public void ClickWorkoutButton() {			
			commonMethods.waitForClickable(workoutLink).click();
			LoggerLoad.info("WorkoutButton clicked");

		}
		public void ClickBackToDashboard() { 
		commonMethods.waitForClickable(backToDashboard).click(); 		
		LoggerLoad.info("BackToDashboard link clicked"); 
		}
		
		public boolean isBackToDashboardVisible() {
		    return commonMethods.waitForVisibility(backToDashboard).isDisplayed();		   
		}
		
		public boolean isDashboardWorkoutsVisible() {
			return commonMethods.waitForVisibility(DailyPersonalisedWorkout).isDisplayed();		
		}
		
		public boolean isDailyWorkoutPlanVisible() {
			return commonMethods.waitForVisibility(DailyWorkoutPlan).isDisplayed();
		}



}
