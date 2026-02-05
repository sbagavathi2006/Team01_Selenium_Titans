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
import io.cucumber.java.en.When;
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
		menstrualPhaseLog.waitforActiviyInsightsButton();
		menstrualPhaseLog.clickActivityInsightsButton();
	
	}
	@When("User clicks on Menstrual Phase Logs from dashboard")
	public void user_clicks_on_menstrual_phase_logs() {
	    menstrualPhaseLog.clickMenstrualPhaseLogs();
	}


	@Then("User is able to see five sections on the Menstrual Phase Logs page")
	public void verify_five_sections() {
	    Assert.assertTrue(menstrualPhaseLog.isFiveSectionsVisible(),"Five sections were not visible");
	}

	@Then("User is able to see Update Cycle Information button should be visible")
	public void verify_update_cycle_info_button() {
	    Assert.assertTrue(menstrualPhaseLog.isUpdateCycleInfoBtnVisible(),"Update Cycle Information button not found");
	}

	@Then("User is able to see Back to Dashboard button is visible")
	public void verify_back_to_dashboard_button() {
	    Assert.assertTrue(menstrualPhaseLog.isBacktoDashboardBtnVisible(),"Back to Dashboard button not visible");
	}

	@Then("User is able to see Add Period Log button should be visible")
	public void verify_add_period_log_button() {
	    Assert.assertTrue(menstrualPhaseLog.isAddPeriodLogBtnVisible(),"Add Period Log button is not visible");
	}
	@Then("Add Period Log button should be visible")
	public void add_period_log_button_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isAddPeriodLogBtnVisible(), "Add Period Log button is not visible" );
	}

	@Then("Cycle Overview tab should be visible")
	public void cycle_overview_tab_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isCycleOverviewTabVisible(), "Cycle Overview tab is not visible" );
	}

	@Then("Menstrual Calendar tab should be visible")
	public void menstrual_calendar_tab_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isMenstrualCalendarTabVisible(), "Menstrual Calendar tab is not visible" );
	}

	@Then("Period History tab should be visible")
	public void period_history_tab_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isPeriodHistoryTabVisible(), "Period History tab is not visible" );
	}

	@Then("Displays current cycle progress in the format as the values entered during onboarding process")
	public void displays_current_cycle_progress_in_the_format_as_the_values_entered_during_onboarding_process() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Current Phase, Last period started, Next period expected are displayed")
	public void current_phase_last_period_started_next_period_expected_are_displayed() {
		Assert.assertTrue( menstrualPhaseLog.isCurrentPhaseVisible(), "Current Phase section not visible" );
		Assert.assertTrue( menstrualPhaseLog.isLastPeriodStartedVisible(), "Last period started section not visible" );
		Assert.assertTrue( menstrualPhaseLog.isNextPeriodExpectedVisible(), "Next period  section not visible" );
	}
	@Then("Progress bar should be filled according to the current cycle progress")
	public void progress_bar_should_be_filled_according_to_the_current_cycle_progress() {
		Assert.assertTrue( menstrualPhaseLog.isProgressBarVisible(), "Progress bar was not visible" );
	}
	@Then("Menstrual, Follicular, Ovulation, Luteal labels are displayed below the progress bar")
	public void menstrual_follicular_ovulation_luteal_labels_are_displayed_below_the_progress_bar() {
		Assert.assertTrue( menstrualPhaseLog.isMenstrualLabelVisible(), "Menstrual label  not visible" );
		Assert.assertTrue( menstrualPhaseLog.isFollicularLabelVisible(), "Follicular label not visible" );
		Assert.assertTrue( menstrualPhaseLog.isOvulationLabelVisible(), "Ovulation label not visible" );
		Assert.assertTrue( menstrualPhaseLog.isLutealLabelVisible(), "Luteal label not visible" );
	}

	@Then("Displays correct Next period expected based on the values entered during onboarding process")
	public void displays_correct_next_period_expected_based_on_the_values_entered_during_onboarding_process() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Displays the phase based on the value entered during onboarding process")
	public void displays_the_phase_based_on_the_value_entered_during_onboarding_process() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Displays correct Last period started based on the date entered during onboarding process")
	public void displays_correct_last_period_started_based_on_the_date_entered_during_onboarding_process() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Display content should match current phase")
	public void display_content_should_match_current_phase() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Subsection heading reflects the Current Phase in the format {string}")
	public void subsection_heading_reflects_the_current_phase_in_the_format(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
