package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import context.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelUtils;

public class DashboardStepDef {

	private TestContextSetup testContext;
	private ExcelUtils excel = new ExcelUtils(null);;
	private Map<String, String> testData;

	public DashboardStepDef(TestContextSetup context) {
		this.testContext = context;
	}

	/*-------------- Free Plan Dashboard UI --------------*/

	@When("User clicks login in button after entering  a valid credential")
	public void user_clicks_login_in_button_after_entering_a_valid_credential() {
		testContext.commonMethods().loginFromOnBoarding();
	}

	@Then("User should see {string} title")
	public void user_should_see_title(String expectedTitle) {
		Assert.assertEquals(testContext.dashboardPage().getTitle(), expectedTitle);
	}

	@Then("User should see user name on the top right side")
	public void user_should_see_user_name_on_the_top_right_side() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		Assert.assertEquals(testContext.dashboardPage().getDashboardUserName(), testData.get("First Name"));
	}

	@Then("User should see profile icon near user name")
	public void user_should_see_profile_icon_near_user_name() {
		Assert.assertTrue(testContext.dashboardPage().isIconDisplayed());
	}

	@Then("User should see bell icon for notification")
	public void user_should_see_bell_icon_for_notification() {
		Assert.assertTrue(testContext.dashboardPage().isBellIconDisplayed());
	}

	@Then("User should see search bar in dashboard")
	public void user_should_see_search_bar_in_dashboard() {
		Assert.assertTrue(testContext.dashboardPage().isSearchBarDisplayed());
	}

	@Then("User should see {string}")
	public void user_should_see(String menuName) {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		if (menuName.equalsIgnoreCase("User Name")) {
			menuName = testData.get("First Name");
		}
		List<String> actualMenus = testContext.dashboardPage().getMenusText();
		Assert.assertTrue(actualMenus.contains(menuName));
	}

	@Then("User should see below {string}")
	public void user_should_see_below(String expectedText) {
		List<String> actualPlansText = testContext.dashboardPage().getDashboardPlansText();
		Assert.assertTrue(actualPlansText.contains(expectedText));
	}

	@Then("User should see below dashboard {string}")
	public void user_should_see_below_dashboard(String expectedText) {
		List<String> actualDashboardSectionText = testContext.dashboardPage().getDashboardSectionText();
		Assert.assertTrue(actualDashboardSectionText.contains(expectedText));
	}

	@Then("User should see below body metrics {string}")
	public void user_should_see_below_body_metrics(String expectedText) {
		List<String> actualDashboardSectionText = testContext.dashboardPage()
				.getDashboardBodySectionTitle(expectedText);
		Assert.assertTrue(actualDashboardSectionText.contains(expectedText));
	}

	@Then("App should have following goal {string}")
	public void app_should_have_following_goal(String expectedText) {
		List<String> actualDashboardGoalSectionText = testContext.dashboardPage()
				.getDashboardBodySectionTitle(expectedText);
		Assert.assertTrue(actualDashboardGoalSectionText.contains(expectedText));
	}

	@Then("Should display the user’s weight as entered during the onboarding process.")
	public void should_display_the_user_s_weight_as_entered_during_the_onboarding_process() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		String tempWeight = testData.get("Weight in KG");
		Assert.assertEquals(testContext.dashboardPage().getDashboardWeight(), tempWeight.replace(".0", ""));
	}

	@Then("Should display the user’s Height as entered during the onboarding process.")
	public void should_display_the_user_s_height_as_entered_during_the_onboarding_process() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		String tempHeight = testData.get("Height in CM");
		Assert.assertEquals(testContext.dashboardPage().getDashboardHeight(), tempHeight.replace(".0", ""));
	}

	@Then("BMI should be correctly calculated using the formula")
	public void bmi_should_be_correctly_calculated_using_the_formula() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		int currentWeightInt = Integer
				.parseInt(testContext.dashboardPage().getDashboardCurrentWeight().replace(".0", "").split(" ")[0]);
		double heightInt = (Integer.parseInt(testData.get("Height in CM").replace(".0", ""))) / 100.0;
		double bmi = Math.round((currentWeightInt / (heightInt * heightInt)) * 10.0) / 10.0;
		String expectedBMI = String.valueOf(bmi);
		Assert.assertEquals(testContext.dashboardPage().getDashboardBMI(), expectedBMI);
	}

	@Then("Goal weight should be displayed as the difference from the weekly target")
	public void goal_weight_should_be_displayed_as_the_difference_from_the_weekly_target() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		String expectedGoalWeight = String.valueOf(Integer.parseInt(testData.get("Weight in KG").replace(".0", "")) - 0.7);
		Assert.assertEquals(testContext.dashboardPage().getDashboardGoalWeight(), expectedGoalWeight);
	}

	@Then("Daily weigh in should be {string}")
	public void daily_weigh_in_should_be(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getDashboardCustomText(expectedText), expectedText);
	}

	@Then("Subcription details should be present in goal section")
	public void subcription_details_should_be_present_in_goal_section() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		Assert.assertEquals(testContext.dashboardPage().getDashboardSubscription(), testData.get("Plan"));
	}

	@Then("{string} label should be visible above the slider")
	public void label_should_be_visible_above_the_slider(String string) {
		Assert.assertEquals(testContext.dashboardPage().getDashboardInfo(), "Info");
	}

	@Then("Following Message should display {string}")
	public void following_message_should_display(String expectedMessage) {
		Assert.assertEquals(testContext.dashboardPage().getDashboardFreePlanINfor(), expectedMessage);
	}

	@Then("Slider should be present in BMI reference guide")
	public void slider_should_be_present_in_bmi_reference_guide() {
		Assert.assertTrue(testContext.dashboardPage().sliderIsDisplayed());
	}

	@Then("BMI Reference Guide component should be displayed with a gradient slider and labeled ranges")
	public void bmi_reference_guide_component_should_be_displayed_with_a_gradient_slider_and_labeled_ranges() {
		Assert.assertTrue(testContext.dashboardPage().sliderCategoryIsDisplayed());
	}

	@Then("slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values")
	public void slider_should_display_a_continuous_gradient_from_blue_yellow_orange_red_representing_increasing_bmi_values() {
		SoftAssert sa = new SoftAssert();
		// Blue color
		sa.assertTrue(testContext.dashboardPage().getDashboardSlider().contains("rgb(96, 165, 250)"));
		// Green color
		sa.assertTrue(testContext.dashboardPage().getDashboardSlider().contains("rgb(74, 222, 128)"));
		// Yello/Orange color
		sa.assertTrue(testContext.dashboardPage().getDashboardSlider().contains("rgb(251, 191, 36)"));
		// Red color
		sa.assertTrue(testContext.dashboardPage().getDashboardSlider().contains("rgb(248, 113, 113)"));
		sa.assertAll();
	}

	@Then("{string} should be visible and color-coded accordingly")
	public void should_be_visible_and_color_coded_accordingly(String expectedText) {
		String labelText = testContext.dashboardPage().getDashboardSliderCategory();
		List<String> actualCategoryText = new ArrayList<>();
		for (String text : labelText.split("\\r?\\n")) {
			actualCategoryText.add(text.trim());
		}
		Assert.assertTrue(actualCategoryText.contains(expectedText.trim()));

	}

	/*-------------- Health Conditions - with condition--------------*/

	@When("User clicks login in button after entering  a valid credential with healthCondition")
	public void user_clicks_login_in_button_after_entering_a_valid_credential_with_healthCondition() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport_WithOnlyHealthCondition");
		testContext.dashboardPage().Login(testData.get("UserName"), testData.get("Password"));
	}

	@Then("Displayed condition match exactly what was selected during onboarding without requiring user input again")
	public void displayed_condition_match_exactly_what_was_selected_during_onboarding_without_requiring_user_input_again() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport_WithOnlyHealthCondition");
		String healthCondition = testData.get("Health Conditions");
		Assert.assertEquals(testContext.dashboardPage().getDashboardHealthCondition(healthCondition), healthCondition);
	}

	@Then("Displayed message appears below healthCondition card explaining how the plan is adjusted")
	public void displayed_message_appears_below_healthCondition_card_explaining_how_the_plan_is_adjusted() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport_WithOnlyHealthCondition");
		String condition = testData.get("Health Conditions");
		String expectedMessage = "";
		switch (condition) {
		case "Hypothyroidism":
			expectedMessage = "We will moderate certain foods (e.g., raw broccoli, soy) while ensuring your plan has nutrients for thyroid support.";
			break;
		case "Kidney Disease":
			expectedMessage = "Your plan will carefully manage levels of sodium, potassium, phosphorus, and protein to support kidney function.";
			break;
		case "Liver Disease":
			expectedMessage = "To reduce strain on the liver, your plan will strictly limit alcohol, processed fats, added sugars, and sodium.";
			break;
		case "Cardiovascular Disease":
			expectedMessage = "To support heart health, your plan will strictly limit sodium, saturated/trans fats, and added sugars.";
			break;
		case "Digestive Issues (IBS, Leaky Gut, etc.)":
			expectedMessage = "Your plan will be designed to limit common trigger foods (like high-FODMAPs, gluten, or dairy) to support digestive health.";
			break;
		case "Sleep Apnea":
			expectedMessage = "To improve sleep quality, your meal plan will avoid heavy meals, alcohol, and excessive caffeine near bedtime.";
			break;
		case "High Cholesterol":
			expectedMessage = "Your plan will restrict saturated and trans fats to help support healthy cholesterol levels.";
			break;
		case "Insulin Resistance / Pre-diabetes":
			expectedMessage = "We will limit high-glycemic foods and added sugars in your plan to help maintain stable blood sugar.";
			break;
		case "PCOS":
			expectedMessage = "Your plan will be adjusted to limit refined carbohydrates and sugars to support hormone balance.";
		default:
			throw new RuntimeException("No expected message defined for condition: " + condition);
		}
		String actualMessage = testContext.dashboardPage().getDashboardHealthConditionMessage(condition);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	/*-------------- Health Conditions - without condition--------------*/

	@When("User clicks login in button after entering  a valid credential without healthCondition")
	public void user_clicks_login_in_button_after_entering_a_valid_credential_without_healthCondition() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport_WithoutHealthCondition");
		testContext.dashboardPage().Login(testData.get("UserName"), testData.get("Password"));
	}

	@Then("Message like {string} or an empty state is displayed")
	public void message_like_or_an_empty_state_is_displayed(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getNoHealthText(), expectedText);
	}

	/*-------------- Blood Report Insights - report not uploaded--------------*/

	@Then("User should see the {string} button")
	public void user_should_see_the_button(String string) {
		Assert.assertTrue(testContext.dashboardPage().withoutBloodReportIsDisplayed());
	}

	@Then("{string} Message prompting them to upload their medical blood test report")
	public void message_prompting_them_to_upload_your_medical_blood_test_report(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getUploadReportText(), expectedText);
	}

	@Then("Upload Blood Report button should be enabled")
	public void upload_blood_report_button_should_be_enabled() {
		Assert.assertTrue(testContext.dashboardPage().withoutBloodReportIsEnabled());
	}

	/*-------------- Subscription Information--------------*/

	@Then("Joined date should be displayed")
	public void joined_date_should_be_displayed() {
		Assert.assertTrue(testContext.dashboardPage().dashboardSubJoinedDateIsDisplayed());
	}

	@Then("Todays date should be display")
	public void todays_date_should_be_display() {
		Assert.assertTrue(testContext.dashboardPage().dashboardSubTodayDateIsDisplayed());
	}

	@Then("Subcription plan should be displayed")
	public void subcription_plan_should_be_displayed() {
		testData = excel.getRowDataByScenario("OnBoarding", "User_WithoutReport");
		Assert.assertEquals(testContext.dashboardPage().dashboardSubPlanNameGet(), testData.get("Plan"));
	}

	@Then("{string} button should be displayed")
	public void button_should_be_displayed(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().dashboardSubUpgradeGet(), expectedText);
	}

	/*-------------- Menstrual Cycle Insights--------------*/

	@When("User click on view full cycle details link")
	public void user_click_on_view_full_cycle_details_link() {
		testContext.dashboardPage().clickdashboardviewFullCycyle();
	}

	@Then("User should be redirected to the full {string} page")
	public void user_should_be_redirected_to_the_full_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getdashboardMenstrualCycle(), expectedText);
	}

	@Then("Message {string} should be displayed")
	public void message_should_be_displayed(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getdashboardMenstrualInfo(), expectedText);
	}

	/*-------------- Dashboard - Functionality--------------*/

	@When("User clicks on profile name")
	public void user_clicks_on_profile_name() {
		testContext.editProfilePage().clickUName();
	}

	@Then("User should see below profile {string}")
	public void user_should_see_options(String expectedText) {
		List<String> actualOptionsText = testContext.dashboardPage().getdashboardMenuItem();
		Assert.assertTrue(actualOptionsText.contains(expectedText));
	}

	@When("User clicks on activity Insight")
	public void user_clicks_on_activity_insight() {
		testContext.dashboardPage().clickTrackWeight();
	}

	@When("User clicks on Diet plan button")
	public void user_clicks_on_diet_plan_button() {
		testContext.dashboardPage().clickdietPlan();
	}

	@Then("User should redirected to {string} page")
	public void user_should_redirected_to_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getdietPlanText(), expectedText);
	}

	@When("User clicks on workout button")
	public void user_clicks_on_workout_button() {
		testContext.dashboardPage().clickworkOut();
	}

	@Then("User should redirected to {string} workout page")
	public void user_should_redirected_to_workout_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getworkOutText(), expectedText);
	}

	@When("User clicks on water tracker button")
	public void user_clicks_on_water_tracker_button() {
		testContext.dashboardPage().clickwaterTracker();
	}

	@Then("User should redirected to {string} water page")
	public void user_should_redirected_to_water_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getwaterTrackerText(), expectedText);
	}

	@When("User clicks on  Upgrade to Premium")
	public void user_clicks_on_upgrade_to_premium() {
		testContext.dashboardPage().clickupgradePremium();
	}

	@Then("User should be redirected to Subcription page")
	public void user_should_be_redirected_to_subcription_page() {
		Assert.assertTrue(testContext.dashboardPage().getsubscriptionPlanText());
	}

	@When("User clicks on Generate Day Plan")
	public void user_clicks_on_generate_day_plan() {
		testContext.dashboardPage().clicksevenDayPlan();
	}

	@When("User clicks on See Premium Plans")
	public void user_clicks_on_see_premium_plans() {
		testContext.dashboardPage().clickseePremiumPlan();
	}

	/*-------------- Dashboard - Profile sub menu functionality --------------*/

	@When("User clicks on Home")
	public void user_clicks_on_home() {
		testContext.dashboardPage().clickhome();
	}

	@When("User clicks on Edit Profile")
	public void user_clicks_on_edit_profile() {
		testContext.editProfilePage().clickEditProfile();
	}

	@When("User clicks on Subscription")
	public void user_clicks_on_subscription() {
		testContext.dashboardPage().clicksubscription();
	}

	@Then("User should be redirected to {string} sub page")
	public void user_should_be_redirected_to_sub_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getsubscriptionNavText(), expectedText);
	}

	@When("User clicks on Logout")
	public void user_clicks_on_logout() {
		testContext.dashboardPage().clicklogout();
	}

	@Then("User should logout and see {string} title")
	public void user_should_logout_and_see_title(String expectedText) {
		Assert.assertEquals(testContext.editProfilePage().getEditMessage(), expectedText);
	}

	/*-------------- Dashboard - Activity Insights sub menu functionality --------------*/

	@When("User clicks on Track Weight")
	public void user_clicks_on_track_weight() {
		testContext.dashboardPage().clicktrackWeight();
	}

	@Then("User should be redirected to {string} page")
	public void user_should_be_redirected_to_page(String expecteText) {
		Assert.assertEquals(testContext.dashboardPage().gettrackWeightNavText(), expecteText);
	}

	@When("User clicks on Food Intake")
	public void user_clicks_on_food_intake() {
		testContext.dashboardPage().clickfoodIntake();
	}

	@Then("User should be redirected to {string} food intake page")
	public void user_should_be_redirected_to_food_intake_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getfoodIntakeText(), expectedText);
	}

	@When("User clicks on Menstrual Phase Logs")
	public void user_clicks_on_menstrual_phase_logs() {
		testContext.dashboardPage().clickmenstrual();
	}

	@Then("User should be redirected to {string} menstrual page")
	public void user_should_be_redirected_to_menstrual_page(String expectedText) {
		Assert.assertEquals(testContext.dashboardPage().getmenstrualText(), expectedText);

	}

}
