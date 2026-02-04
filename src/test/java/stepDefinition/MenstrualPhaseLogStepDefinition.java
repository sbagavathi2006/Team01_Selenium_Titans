package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.MenstrualPhaseLogPage;
import pageObjects.WorkoutPage;
import utilities.CommonMethods;
import utilities.ConfigReader;

public class MenstrualPhaseLogStepDefinition {
	WebDriver driver;
	MenstrualPhaseLogPage menstrualPhaseLog;
	CommonMethods commonMethods;

	@Before
	public void setup() {
		ConfigReader.loadProperties();
		driver = DriverFactory.getDriver();
		menstrualPhaseLog = new MenstrualPhaseLogPage(driver);
		commonMethods = new CommonMethods(driver);
	}
	
	
	@Given("User clicks Activity Insights button after logged in")
	public void user_clicks_activity_insights_button_after_logged_in() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		email.sendKeys("testuser001@gmail.com");
		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		password.sendKeys("testuesr001@");
		WebElement loginBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		loginBtn.click();
		wait.until(ExpectedConditions.titleContains("HerBalance"));
		commonMethods.waitForPopupToDisappear();

	}

	@Then("User is able to see {int} sections should be visible\\(Current Cycle Status, Upcoming Phases, Recommended Activities, Nutrtion Tips, Next Period)")
	public void user_is_able_to_see_sections_should_be_visible_current_cycle_status_upcoming_phases_recommended_activities_nutrtion_tips_next_period(Integer int1) {
		menstrualPhaseLog.waitforActiviyInsightsButton();
		menstrualPhaseLog.ClickActivityInsightsButton();
		Assert.assertTrue(menstrualPhaseLog.clickMenstrualPhaseLogs(), "Activity Insights Button was not clicked");
	}

	@Then("User is able to see {string} button should be visible")
	public void user_is_able_to_see_button_should_be_visible(String expectedText) {
		Assert.assertTrue( menstrualPhaseLog.isActivityInsightsTextVisible(expectedText), "Expected text not visible: " + expectedText);
		Assert.assertTrue(menstrualPhaseLog.isUpdateCycleInfoBtnVisible());
	}
	@Then("User is able to see {string} button is visible")
	public void user_is_able_to_see_button_is_visible(String string) {
		Assert.assertTrue(menstrualPhaseLog.isBacktoDashboardBtnVisible(), "Back to dashboard is visible");
	}

	@Then("User is able to see {string} tab should be visible")
	public void user_is_able_to_see_tab_should_be_visible(String string) {
		Assert.assertTrue(menstrualPhaseLog.isAddPeriodLogBtnVisible(), "Add Period Log Button is not visible");
	}


}
