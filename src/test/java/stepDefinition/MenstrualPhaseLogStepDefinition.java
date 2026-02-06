package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;
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
import utilities.ExcelUtils;
import utilities.LoggerLoad;

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
		email.sendKeys("User1@gmail.com");
		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		password.sendKeys("User1@987&");
		WebElement loginBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		loginBtn.click();
		wait.until(ExpectedConditions.titleContains("HerBalance"));
		commonMethods.waitForPopupToDisappear();
		menstrualPhaseLog.waitforActiviyInsightsButton();
		menstrualPhaseLog.clickActivityInsightsButton();
	
	}
	@When("User clicks on Menstrual Phase Logs from dashboard")
	public void user_clicks_on_menstrual_phase_logs_from_dashboard() {
	    menstrualPhaseLog.clickMenstrualPhaseLogs();
	}


	@Then("User is able to see five sections on the Menstrual Phase Logs page")
	public void user_is_able_to_see_five_sections_on_the_menstrual_phase_logs_page() {
	    Assert.assertTrue(menstrualPhaseLog.isFiveSectionsVisible(),"Five sections were not visible");
	    LoggerLoad.info("User is able to see five sections on the Menstrual Phase Logs page"); 
	}

	@Then("Update Cycle Information button should be visible")
	public void update_cycle_information_button_should_be_visible() {
	    Assert.assertTrue(menstrualPhaseLog.isUpdateCycleInfoBtnVisible(),"Update Cycle Information button not found");
	    LoggerLoad.info("Update Cycle Information button is visible"); 
	   	
	}

	@Then("Back to Dashboard button is visible")
	public void back_to_dashboard_button_is_visible() {
	    Assert.assertTrue(menstrualPhaseLog.isBacktoDashboardBtnVisible(),"Back to Dashboard button not visible");
	    LoggerLoad.info("Back to Dashboard button is visible"); 
	}

	@Then("Add Period Log button should be visible")
	public void add_period_log_button_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isAddPeriodLogBtnVisible(), "Add Period Log button is not visible" );
		 LoggerLoad.info("Add Period Log button is visible");
	}

	@Then("Cycle Overview tab should be visible")
	public void cycle_overview_tab_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isCycleOverviewTabVisible(), "Cycle Overview tab is not visible" );
		 LoggerLoad.info("Cycle Overview tab is visible");
	}

	@Then("Menstrual Calendar tab should be visible")
	public void menstrual_calendar_tab_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isMenstrualCalendarTabVisible(), "Menstrual Calendar tab is not visible" );
		 LoggerLoad.info("Menstrual Calendar tab is visible");
	}

	@Then("Period History tab should be visible")
	public void period_history_tab_should_be_visible() {
		Assert.assertTrue( menstrualPhaseLog.isPeriodHistoryTabVisible(), "Period History tab is not visible" );
		 LoggerLoad.info("Period History tab is visible");
	}
	@Then("Current Cycle Status is displayed")
	public void current_cycle_status_is_displayed() {
		 Assert.assertTrue(menstrualPhaseLog.iscurrentCycleStatusVisible(),"Cycle status not visible");
		 LoggerLoad.info("Current Cycle Status is displayed");
	}

	@Then("Displays current cycle progress in the format as the values entered during onboarding process")
	public void displays_current_cycle_progress_in_the_format_as_the_values_entered_during_onboarding_process() {
		String lastPeriodDate = menstrualPhaseLog.getLastPeriodDate();
		Assert.assertEquals("01/09/2026", lastPeriodDate);
		LoggerLoad.info("Displays current cycle progress in the format as :" +  menstrualPhaseLog.getLastPeriodDate());
	}
	@Then("Current Phase, Last period started, Next period expected are displayed")
	public void current_phase_last_period_started_next_period_expected_are_displayed() {
		Assert.assertTrue( menstrualPhaseLog.isCurrentPhaseVisible(), "Current Phase section not visible" );
		Assert.assertTrue( menstrualPhaseLog.isLastPeriodStartedVisible(), "Last period started section not visible" );
		Assert.assertTrue( menstrualPhaseLog.isNextPeriodExpectedVisible(), "Next period  section not visible" );
		LoggerLoad.info("Current Phase, Last period started, Next period expected are displayed");
	}
	@Then("Progress bar should be filled according to the current cycle progress")
	public void progress_bar_should_be_filled_according_to_the_current_cycle_progress() {
		Assert.assertTrue( menstrualPhaseLog.isProgressBarVisible(), "Progress bar was not visible" );
		LoggerLoad.info("Progress bar is filled according to the current cycle progress");
	}
	@Then("Menstrual, Follicular, Ovulation, Luteal labels are displayed below the progress bar")
	public void menstrual_follicular_ovulation_luteal_labels_are_displayed_below_the_progress_bar() {
		Assert.assertTrue( menstrualPhaseLog.isMenstrualLabelVisible(), "Menstrual label  not visible" );
		Assert.assertTrue( menstrualPhaseLog.isFollicularLabelVisible(), "Follicular label not visible" );
		Assert.assertTrue( menstrualPhaseLog.isOvulationLabelVisible(), "Ovulation label not visible" );
		Assert.assertTrue( menstrualPhaseLog.isLutealLabelVisible(), "Luteal label not visible" );
		LoggerLoad.info("Menstrual, Follicular, Ovulation, Luteal labels are displayed below the progress bar ");
	}

	@Then("Displays correct Next period expected based on the values entered during onboarding process")
	public void displays_correct_next_period_expected_based_on_the_values_entered_during_onboarding_process() {
		
		menstrualPhaseLog.getLastPeriodDate();
		LoggerLoad.info("Last Period Date from Excel is : "+ menstrualPhaseLog.getLastPeriodDate());
		menstrualPhaseLog.NextPeriodExpected();
		LoggerLoad.info("Expected Next Period Expected is :" +menstrualPhaseLog.NextPeriodExpected() );
		menstrualPhaseLog.getNextPeriodExpectedFromUI();
		LoggerLoad.info(" Next Period Captured from UI page is :" + menstrualPhaseLog.getNextPeriodExpectedFromUI() );
	}
	@Then("Displays the phase based on the value entered during onboarding process")
	public void displays_the_phase_based_on_the_value_entered_during_onboarding_process() {
	    menstrualPhaseLog.getCurrentPhaseFromUI();
	    LoggerLoad.info("Current Phase from UI page is :" + menstrualPhaseLog.getCurrentPhaseFromUI());
	}
	@Then("Displays correct Last period started based on the date entered during onboarding process")
	public void displays_correct_last_period_started_based_on_the_date_entered_during_onboarding_process() {
		menstrualPhaseLog.getLastPeriodStartedText();
		LoggerLoad.info("Correct Last Perioid from UI page is :" + menstrualPhaseLog.getLastPeriodStartedText());
	}
	@Then("Display content should match current phase")
	public void display_content_should_match_current_phase() {
		menstrualPhaseLog.getCurrentPhaseDescriptionText();
		LoggerLoad.info("Nexct Period from UI page is :" + menstrualPhaseLog.getCurrentPhaseDescriptionText());
	}
	@Then("Subsection heading reflects the Current Phase in the format Current Phase Details")
	public void subsection_heading_reflects_the_current_phase_in_the_format_current_phase_detais() {
		menstrualPhaseLog.getCurrentPhaseDetailsHeadingText();
		LoggerLoad.info("Nexct Period from UI page is :" + menstrualPhaseLog.getCurrentPhaseDetailsHeadingText());
	}

	@Then("Upcoming Phases is displayed")
	public void upcoming_phases_is_displayed() {
		Assert.assertTrue(menstrualPhaseLog.isUpcomingPhasesHeaderDisplayed(), "Upcoming Phases header was NOT displayed");
		LoggerLoad.info("Phase shown in UI is  :" + menstrualPhaseLog.isUpcomingPhasesHeaderDisplayed());
	}

	@Then("Subtext is displayed")
	public void subtext_is_displayed() {
		Assert.assertTrue(menstrualPhaseLog.isUpcomingPhaseTextDisplayed(), "Subtext isnot displayed");
		LoggerLoad.info("Text shown in UI is: " + menstrualPhaseLog.isUpcomingPhaseTextDisplayed());
	}

	@Then("Four subsections should be visible")
	public void four_subsections_should_be_visible() {
		Assert.assertTrue(menstrualPhaseLog.isFivePhasesDisplayed(), "Five Phases are not displayed");
		LoggerLoad.info("Toatal Phases on UI are : " + menstrualPhaseLog.isFivePhasesDisplayed());
	}

	@Then("Menstrual Phase, Follicular Phase, Ovulation Phase, Luteal Phase are displayed")
	public void menstrual_phase_follicular_phase_ovulation_phase_luteal_phase_are_displayed() {
		Assert.assertTrue(menstrualPhaseLog.areAllFivePhasesVisible());
		LoggerLoad.info("we can see 5 phases are avalible in UI : " + menstrualPhaseLog.areAllFivePhasesVisible());
	}

	@Then("Start date should be diaplayed correctly as per the cycle data entered during onboarding process")
	public void start_date_should_be_diaplayed_correctly_as_per_the_cycle_data_entered_during_onboarding_process() {
		Assert.assertTrue(menstrualPhaseLog.AllFourPhaseDatesDisplayed());
		LoggerLoad.info("we can see date displayed in UI : " + menstrualPhaseLog.AllFourPhaseDatesDisplayed());
	}

	@Then("All phase start dates should be displayed in {string} format")
	public void all_phase_start_dates_should_be_displayed_in_format(String string) {
		LoggerLoad.info("All phase start dates are displayed");
	}

	@Then("Current phase date should be displayed in {string} format")
	public void current_phase_date_should_be_displayed_in_format(String string) {
		Assert.assertTrue(menstrualPhaseLog.getCurrentPhaseStartedDate());
		LoggerLoad.info("Current Phase started date is :" +menstrualPhaseLog.getCurrentPhaseStartedDate());
	}

	@Then("{string} subsection is highlighted based on cycle data entered during onboarding process")
	public void subsection_is_highlighted_based_on_cycle_data_entered_during_onboarding_process(String string) {
		Assert.assertTrue(menstrualPhaseLog.isCurrentPhaseHighlighted());
		LoggerLoad.info("Subsection is highlighted on UI ");
	}

	@Then("Recommended Activities should be displayed")
	public void recommended_activities_should_be_displayed() {
		Assert.assertTrue(menstrualPhaseLog.isRecommendedActivitiesDisplayed());
		LoggerLoad.info("Recommended Activities is displayed on UI ");
	}

	@Then("Recommended Activities should be displayed as per the {string}")
	public void recommended_activities_should_be_displayed_as_per_the(String string) {
		menstrualPhaseLog.VerifyRecommendedActivitiesText();	
	}

	@Then("{string} is displayed")
	public void is_displayed(String string) {
		menstrualPhaseLog.isNutritionTipsDisplayed();
		LoggerLoad.info("Nutrition Tips is displayed on UI ");
	}

	@Then("Nutrtional Tips should be displayed as per the {string}")
	public void nutrtional_tips_should_be_displayed_as_per_the(String string) {
		menstrualPhaseLog.VerifyNutritionTipsText();
		LoggerLoad.info("Nutrition Tips Text is displayed on UI ");
	}



	
}
