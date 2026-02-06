package stepDefinition;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import context.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelUtils;

public class EditYourProfileStepDef {

	private TestContextSetup testContext;
	private ExcelUtils excel = new ExcelUtils(null);;
	private Map<String, String> testData;

	public EditYourProfileStepDef(TestContextSetup context) {
		this.testContext = context;
	}

	@When("User is on Dashboard page")
	public void user_is_on_dashboard_page() {
		testContext.commonMethods().loginFromOnBoarding();
	}

	/*-------------- Free Plan Dashboard UI --------------*/

	@When("User clicks on profile name and click on edit profile")
	public void user_clicks_on_profile_name_and_click_on_edit_profile() {
		testContext.editProfilePage().clickUName();
		testContext.editProfilePage().clickEditProfile();
	}

	@Then("{string} should be visible")
	public void should_be_visible(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getEditProfileText(), expectedText);
	}

	@Then("{string} text should be visible")
	public void text_should_be_visible(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getEditProfileSubText(), expectedText);
	}

	@Then("User should see below tabs {string}")
	public void user_should_see_below_tabs(String expectedTab) {
		List<String> actualTab = testContext.editProfilePage().getEditYourProfileTabs();
		Assert.assertTrue(actualTab.contains(expectedTab));
	}

	@Then("{string} should be visible by default")
	public void should_be_visible_by_default(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getEditYourProfileTabs().get(0), expectedText);
	}

	@Then("Back button should be visible")
	public void back_button_should_be_visible() {
		Assert.assertTrue(testContext.editProfilePage().backIsDisplayed());
	}

	/*-------------- Edit Your Profile-Basic Information -UI verifications --------------*/

	@Then("Basic Information should be visible inside section")
	public void basic_information_should_be_visible_inside_section() {
		Assert.assertTrue(testContext.editProfilePage().basicInfoTabIsDisplayed());
	}

	@Then("{string} sub text should be visible")
	public void sub_text_should_be_visible(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getBasicInfoSubText(), expectedText);
	}

	@Then("Should display the user’s Name and age as entered during the onboarding process.")
	public void should_display_the_user_s_name_and_age_as_entered_during_the_onboarding_process() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		Assert.assertEquals(testContext.editProfilePage().getBasicInfoName(), testData.get("First Name"));
		Assert.assertEquals(testContext.editProfilePage().getBasicInfoAge().replace(".0", ""),
				testData.get("Age").replace(".0", ""));
	}

	@When("User clicks {string} button")
	public void user_clicks_button(String string) {
		testContext.editProfilePage().clickNextBodyMetrics();
	}

	@Then("User should see {string} next Section")
	public void user_should_see_next_section(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getBodyMetricsText(), expectedText);
	}

	@When("User clicks on Back button on Body Metric section")
	public void user_clicks_on_back_button_on_body_metric_section() {
		testContext.editProfilePage().clickBackSub();
	}

	@Then("User should see {string} previous section")
	public void user_should_see_previous_section(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getBasicInfoText(), expectedText);
	}

	/*-------------- Edit Your Profile-Body Metrics -UI verifications --------------*/

	@When("User clicks Body Metrics Tab")
	public void user_clicks_body_metrics_tab() {
		testContext.editProfilePage().clickBodyMetricsTab();
	}

	@Then("Should display the user’s Weight and Height are as entered during the onboarding process")
	public void should_display_the_user_s_weight_and_height_are_as_entered_during_the_onboarding_process() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		Assert.assertEquals(testContext.editProfilePage().getBodyMetricsWeight().replace(".0", ""),
				testData.get("Weight in KG").replace(".0", ""));
		Assert.assertEquals(testContext.editProfilePage().getBodyMetricsHeight().replace(".0", ""),
				testData.get("Height in CM").replace(".0", ""));
	}

	@When("User clicks on Weight Dropdown")
	public void users_clicks_on_weight_dropdown() {
		testContext.editProfilePage().clickBodyMetricsDD();
	}

	@Then("following {string} should be visible")
	public void following__should_be_visible(String expectedText) {
		List<String> actualText = testContext.editProfilePage().getBodyMetricsWeightDD();
		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Then("{string} button should be visible and enabled")
	public void button_should_be_visible_and_enabled(String string) {
		Assert.assertTrue(testContext.editProfilePage().backSubIsDisplayed());
	}

	@When("User clicks {string} next button")
	public void user_clicks_next_button(String string) {
		testContext.editProfilePage().clickBodyMetricsNext();
	}

	@Then("User should see {string} last section")
	public void user_should_see_last_section(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getPreferenceTab(), expectedText);
	}

	@Then("User clicks on Back button on  Preferences & Health section")
	public void user_clicks_on_back_button_on_preferences_health_section() {
		testContext.editProfilePage().clickBackSub();
	}

	@Then("User should see {string} section")
	public void user_should_see_section(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getBodyMetricsText(), expectedText);
	}

	@Then("BMI Calculation Number should be displayed with a gradient slider and labels")
	public void bmi_calculation_number_should_be_displayed_with_a_gradient_slider_and_labels() {
		String actualText = testContext.editProfilePage().getBMICalcText();
		Assert.assertTrue(actualText.contains("BMI Calculation"));
	}

	@Then("BMI Category section should present with BMI Category")
	public void bmi_category_section_should_present_with_bmi_category() {
		String actualText = testContext.editProfilePage().getBMICategoryText();
		Assert.assertTrue(actualText.contains("BMI Category"));
	}

	@Then("BMI Category note should be visible")
	public void bmi_category_note_should_be_visible() {
		Assert.assertTrue(testContext.editProfilePage().BMICategoryNoteIsDisplayed());
	}

	@Then("edit slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values")
	public void edit_slider_should_display_a_continuous_gradient_from_blue_yellow_orange_red_representing_increasing_bmi_values() {
		SoftAssert sa = new SoftAssert();
		// Blue color
		sa.assertTrue(testContext.editProfilePage().getEditSlider().contains("from-[#90CAF9]"));
		// Green color
		sa.assertTrue(testContext.editProfilePage().getEditSlider().contains("via-[#A5D6A7]"));
		// Yello/Orange color
		sa.assertTrue(testContext.editProfilePage().getEditSlider().contains("via-[#FFB74D]"));
		// Red color
		sa.assertTrue(testContext.editProfilePage().getEditSlider().contains("to-[#EF5350]"));
		sa.assertAll();
	}

	/*-------------- Edit Your Profile-Prefrences and Health  -UI verifications --------------*/

	@When("User clicks Preferences & Health Tab")
	public void user_clicks_preferences_health_tab() {
		testContext.editProfilePage().clickPreferencesTab();
	}

	@Then("{string} should be visible in edit profile")
	public void should_be_visible_in_edit_profile(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getPreferenceTab(), expectedText);
	}

	@Then("{string} preference should be visible")
	public void preference_should_be_visible(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getPreferenceSubText(), expectedText);
	}

	@Then("{string} radioButtons should be visible and enabled")
	public void radio_buttons_should_be_visible_and_enabled(String expectedText) {
		List<String> actualText = testContext.editProfilePage().getPreferencesDiet();
		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Then("{string} preference button should be visible and enabled")
	public void preference_button_should_be_visible_and_enabled(String string) {
		Assert.assertTrue(testContext.editProfilePage().isDisplayedAddMedication());
	}

	@Then("{string} medication should be visible")
	public void medication_should_be_visible(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getPreferenceMedication(), expectedText);
	}

	@Then("{string} save button should be visible and enabled")
	public void save_button_should_be_visible_and_enabled(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getSaveEditButton(), expectedText);
	}

	@When("User navigates to Preferences & Health Tab")
	public void user_navigates_to_preferences_health_tab() {
		testContext.editProfilePage().clickUName();
		testContext.editProfilePage().clickEditProfile();
		testContext.editProfilePage().clickPreferencesTab();
	}

	@When("User clicks on Save Profile on  Preferences & Health section after editing values in any field")
	public void user_clicks_on_save_profile_on_preferences_health_section_after_editing_values_in_any_field() {
		testContext.editProfilePage().clickSaveEditButton();
	}

	@Then("User should see success message {string}")
	public void user_should_see_success_message(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getEditMessage(), expectedText);
	}

	@When("User clicks on Add Medication button")
	public void user_clicks_on_add_medication_button() {
		testContext.editProfilePage().clickAddMedication();
	}

	@Then("User should see a Pop Up {string}")
	public void user_should_see_a_pop_up(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getAlertMedication(), expectedText);
	}

	/*-------------- Preferences & Health -Add Medication UI verification --------------*/

	@Then("{string} alert should be visible")
	public void alert_should_be_visible(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getAlertMedication(), expectedText);
	}

	@When("User navigates to Add Medication button")
	public void user_navigates_to_add_medication_button() {
		testContext.editProfilePage().clickUName();
		testContext.editProfilePage().clickEditProfile();
		testContext.editProfilePage().clickPreferencesTab();
		testContext.editProfilePage().clickAddMedication();
	}

	@When("User clicks on Ok button after adding medication")
	public void user_clicks_on_ok_button_after_adding_medication() throws Exception {
		testData = excel.getRowDataByScenario("EditYourProfile", "AlertText");
		String medicationName = testData.get("Value");
		testContext.editProfilePage().enterMedicationIsDisplayed(medicationName);
	}

	@When("User clicks on cancel button without adding medication details")
	public void user_clicks_on_cancel_button_without_adding_medication_details() {
		testContext.editProfilePage().cancelAlert();
	}

	@Then("User should naviagte back to {string} Section page")
	public void user_should_naviagte_back_to_preferences_health_section_page(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getPreferenceTab(), expectedText);

	}

}
