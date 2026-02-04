package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class WorkoutStepDefintion {

	WebDriver driver;
	WorkoutPage workoutPage;
	CommonMethods commonMethods;

	@Before
	public void setup() {
		ConfigReader.loadProperties();
		driver = DriverFactory.getDriver();
		workoutPage = new WorkoutPage(driver);
		commonMethods = new CommonMethods(driver);
	}

	@Given("User logged into the application")
	public void user_logged_into_the_application() {
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

	@When("user clicks workout button on navigation bar")
	public void user_clicks_workout_button_on_navigation_bar() {
		  workoutPage.ClickWorkoutButton();	
		  Assert.assertEquals(workoutPage.getWorkoutButtonText(), "Workout");
	}
	

	@Then("User should see page title as {string}")
	public void user_should_see_page_title_as(String string) {

		workoutPage.isDailyPersonalizedWorkoutVisible();		
		Assert.assertTrue(workoutPage.isDailyPersonalizedWorkoutVisible());
		LoggerLoad.info("Daily Personalized Workout is visible");
	}

	@Then("User should see link text as {string}")
	public void user_should_see_link_text_as(String string) {
		Assert.assertTrue(workoutPage.isBackToDashboardVisible());
		LoggerLoad.info("link Back to dashboard Exists");
	}

	@Then("User should see workout section title as {string}")
	public void user_should_see_workout_section_title_as(String string) {
		Assert.assertTrue(workoutPage.isDailyWorkoutPlanVisible());
		LoggerLoad.info("Daily Personalized Workout is visible");
	}

	@Then("User should see plan text description as {string}")
	public void user_should_see_plan_text_description_as(String string) {
		Assert.assertTrue(workoutPage.isAIDescriptionVisible());
		LoggerLoad.info("plan text description is visible");
	}

	@Then("User should see message as {string}")
	public void user_should_see_message_as(String string) {
		Assert.assertTrue(workoutPage.isWorkoutTextVisible());
		
	}

	@Then("User should see message alignment as {string}")
	public void user_should_see_message_alignment_as(String string) {
		workoutPage.messageAlignment();
	}
	@Then("User should see button text as {string}")
	public void user_should_see_button_text_as(String string) {
		Assert.assertTrue(workoutPage.isGenerateWorkoutPlanButtonVisible());
	}

	@Then("User should see luteal phase workout section text as {string}")
	public void user_should_see_luteal_phase_workout_section_text_as(String string) {
		Assert.assertTrue(workoutPage.isLeutalPhaseTextVisible());
	}

	@Then("User should see luteal phase workout section description as {string}")
	public void user_should_see_luteal_phase_workout_section_description_as(String string) {
		Assert.assertTrue(workoutPage.LeutalPhaseDescription());
	}

	@Then("User should see presence of benefits of cycle as {string}")
	public void user_should_see_presence_of_benefits_of_cycle_as(String string) {
		Assert.assertTrue(workoutPage.isBenfitsOfCycleTextVisible());
	}

	@Then("User should see benefits of cycle description as {string}")
	public void user_should_see_benefits_of_cycle_description_as(String string) {
		Assert.assertTrue(workoutPage.isBenfitsOfCycleDescriptionVisible());
	}

	@Then("User should see icons under benefits of cycle section as {string}")
	public void user_should_see_icons_under_benefits_of_cycle_section_as(String string) {
		workoutPage.IconsDisplayed();
	}

	@Then("User should see Free Plan Special card on right panel as {string}")
	public void user_should_see_free_plan_special_card_on_right_panel_as(String string) {
		Assert.assertTrue(workoutPage.isGenratePlanTextVisible());
	}
	@Then("User should see background colour of Free Plan Special card as {string}")
	public void user_should_see_background_colour_of_free_plan_special_card_as(String string) {
		workoutPage.getColor();
	}
	@Then("User should see Free plan Special card section description as {string}")
	public void user_should_see_free_plan_special_card_section_description_as(String string) {
		Assert.assertTrue(workoutPage.isSpecialPlanTextDescriptionVisible());
	}
	@Then("User should see 7 Day Plan button as {string}")
	public void user_should_see_7_day_plan_button_as(String string) {
		Assert.assertTrue(workoutPage.isGenerate7DayPlanBtnVisible());
	}
	@Then("User should see Premium Plan section on Right panel as {string}")
	public void user_should_see_premium_plan_section_on_right_panel_as(String string) {
		workoutPage.PremiumPlanSectionAlignment();
	}
	@Then("User should see Premium Plan Card background color as {string}")
	public void user_should_see_premium_plan_card_background_color_as(String string) {
		workoutPage.getPurpleColor();
	}
	@Then("User should see premium plan section description as {string}")
	public void user_should_see_premium_plan_section_description_as(String string) {
		Assert.assertTrue(workoutPage.isSpecialPlanTextDescriptionVisible());
	}
	@Then("User should see See premium plans button as {string}")
	public void user_should_see_see_premium_plans_button_as(String string) {
		Assert.assertTrue(workoutPage.isSeePremiumPlansBtnVisible());
	}
	
}
