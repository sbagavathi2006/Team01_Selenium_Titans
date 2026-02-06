package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;

public class LaunchStepDef {

	private WebDriver driver;
	private LaunchPage launchPage;

	public LaunchStepDef(TestContextSetup Context) {
		this.driver = Context.getDriver();
		this.launchPage = Context.launchPage();
	}

	@Given("User is on the browser")
	public void user_is_on_the_browser() {
		assertTrue(driver != null, "Driver is not initialized");
	}

	@When("User enters the Her Balance application URL")
	public void user_enters_application_url() {
		assertTrue(driver.getCurrentUrl().contains("herbalance"), "User is not on Her Balance site");
	}

	@Then("{string} should be visiblee")
	public void element_should_be_visiblee(String element) {

		switch (element) {
		case "Login button":
			assertTrue(launchPage.isLoginButtonVisible());
			break;
		case "Sign Up button":
			assertTrue(launchPage.isSignUpButtonVisible());
			break;
		case "Get Started Now button":
			assertTrue(launchPage.isGetStartedNowButtonVisible());
			break;
		case "Start Your Personalized Journey button":
			assertTrue(launchPage.isStartPersonalizedJourneyButtonVisible());
			break;
		default:
			throw new IllegalArgumentException("Unknown element: " + element);
		}
	}

	@Then("Cycle phase cards should be displayed")
	public void cycle_phase_cards_should_be_displayed(DataTable dataTable) {

		List<String> phases = dataTable.asList();

		for (String phase : phases) {
			assertTrue(launchPage.isCyclePhaseVisible(phase), phase + " is not visible");
		}
	}

	@Then("Background color should be light purple")
	public void background_color_should_be_light_purple() {
		assertTrue(launchPage.getBackgroundColor() != null, "Background color not applied");
	}

	@Then("Text content should be readable")
	public void text_content_should_be_readable() {
		assertTrue(launchPage.isTextContentPresent(), "Text content not present");
	}

	@Given("User is on Her Balance home page")
	public void user_is_on_home_page() {
		assertTrue(driver.getCurrentUrl().contains("/home"), "User is not on home page");
	}

	@When("User clicks on Login button")
	public void user_clicks_login() {
		launchPage.clickLogin();
	}

	@When("User clicks on Sign Up button")
	public void user_clicks_sign_up() {
		launchPage.clickSignUp();
	}

	@When("User clicks on Get Started Now button")
	public void user_clicks_get_started_now() {
		launchPage.clickGetStartedNow();
	}

	@When("User clicks on Start Your Personalized Journey button")
	public void user_clicks_start_journey() {
		launchPage.clickStartPersonalizedJourney();
	}

	@Then("User should be navigated to authentication page with Login tab selected")
	public void navigated_to_login_tab() {
		assertTrue(driver.getCurrentUrl().contains("auth"), "Auth page not opened");
	}

	@Then("User should be navigated to authentication page with Sign Up tab selected")
	public void navigated_to_sign_up_tab() {
		assertTrue(driver.getCurrentUrl().contains("auth"), "Auth page not opened");
	}

	@Then("Details about the {string} and its features should be displayed")
	public void details_about_the_app_should_be_displayed(String section) {
		switch (section) {
		case "Cycle Tracking App":
			Assert.assertTrue(launchPage.isCycleTrackingAppVisible(), section + " is not visible");
			break;
		default:
			throw new IllegalArgumentException("Unknown section: " + section);
		}
	}

	@Then("Images in {string} section should be displayed")
	public void images_in_section_should_be_displayed(String section) {
		switch (section) {
		case "Sync your weight loss journey":
			Assert.assertTrue(launchPage.isSyncWeightLossImagesVisible(), section + " images are not visible");
			break;
		default:
			throw new IllegalArgumentException("Unknown section: " + section);
		}
	}

	@Then("Display information about hormonal shifts and metabolism during the menstrual cycle")
	public void display_information_about_hormonal_shifts() {
		Assert.assertTrue(launchPage.isEmpowerTextVisible(),
				"Informational text under Empower weight loss section is not visible");
	}

}
