	package stepDefinition;
	
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.*;
	import driverFactorySetUp.DriverFactory;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import pageObjects.WorkoutPage;
	import utilities.ConfigReader;
	
	public class WorkoutStepDefintion {
	
	    WebDriver driver;
	    WorkoutPage workoutPage;
	
	    @Before 
	    public void setup() { 
	    ConfigReader.loadProperties(); 
	 //   DriverFactory.setupBrowser(); 
	    driver = DriverFactory.getDriver();
	    workoutPage = new WorkoutPage(driver); 
	    }
	       
	    @Given("User logged into the application")
	    public void user_logged_into_the_application() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//input[@type='email']"))); email.sendKeys("asminaresh@gmail.com");
	    	WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));password.sendKeys("asminaresh12!");
	    	WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));loginBtn.click();
	    	wait.until(ExpectedConditions.titleContains("HerBalance"));
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	
	    
	    @When("user clicks workout button on navigation bar")
	    public void user_clicks_workout_button_on_navigation_bar() {
	    	  workoutPage.ClickWorkoutButton();	    	
	    }
	    
	    @Then("User should see page title as {string}")
	    public void user_should_see_page_title_as(String string) {
	     	 workoutPage.isDashboardWorkoutsVisible(); 	
	    }
	
	    @Then("User should see the link Back to dashboard")
	    public void user_should_see_the_link_back_to_dashboard() {
	    	Assert.assertTrue(workoutPage.isBackToDashboardVisible(),"Back to dashboard link is not visible");
	       
	    }
	
	    @Then("User should see the {string} section")
	    public void user_should_see_the_section(String string) {
	    	workoutPage.isDailyWorkoutPlanVisible();
	    }

	    
	
	    
	    
	}
	
	
	
