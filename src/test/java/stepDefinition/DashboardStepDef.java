package stepDefinition;

import org.testng.Assert;
import context.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStepDef{

		private TestContextSetup testContext;
	    private String userName = "mathu";
	    
	    public DashboardStepDef(TestContextSetup context) {
	    	 this.testContext = context;
	    }
	       
	    
	/*-------------- Free Plan Dashboard UI --------------*/
	
	@When("User clicks login in button after entering  a valid credential")
	public void user_clicks_login_in_button_after_entering_a_valid_credential() {
		testContext.dashboardPage().tempLogin();
		// **** Setting the Shared data 
//		String weight = "mathu";
//		testContext.setScenarioData("Onboardingweight", weight);
	}
	
	@Then("User should see {string} title")
	public void user_should_see_title(String expectedTitle) {
		Assert.assertEquals(testContext.dashboardPage().getTitle(), expectedTitle);
//		////******* Getting the Shared data 
//		System.out.println("Getting shared data "+ testContext.getScenarioData("sharableData"));
	}
	
	@Then("User should see user name on the top right side")
	public void user_should_see_user_name_on_the_top_right_side() {
    Assert.assertEquals(testContext.dashboardPage().getDashboardUserName(), userName);
	}
	
	@Then("User should see profile icon near user name")
	public void user_should_see_profile_icon_near_user_name() {
		  Assert.assertEquals(testContext.dashboardPage().isIconDisplayed(),true);
	}

	@Then("User should see bell icon for notification")
	public void user_should_see_bell_icon_for_notification() {
		Assert.assertEquals(testContext.dashboardPage().isIconDisplayed(),true);
	}

	
	@Then("Weekly target should be {double} kg")
	public void weekly_target_should_be_kg(Double double1) {
	      
	}
	
	@Then("Slider should be present in BMI reference guide")
	public void slider_should_be_present_in_bmi_reference_guide() {
	      
	}
	@Then("BMI Reference Guide component should be displayed with a gradient slider and labeled ranges")
	public void bmi_reference_guide_component_should_be_displayed_with_a_gradient_slider_and_labeled_ranges() {
	      
	}
	
	
	@Then("{string} label should be visible above the slider")
	public void label_should_be_visible_above_the_slider(String string) {
	      
	}
	
	@Then("{int} section should be visible")
	public void section_should_be_visible(Integer int1) {
	      
	}
	
	@Then("Weight & Body Metrics,Health Conditions,Blood Report Insights,Menstrual Cycle Insights,Subscription Information")
	public void weight_body_metrics_health_conditions_blood_report_insights_menstrual_cycle_insights_subscription_information() {
	      
	}
	

	
	@Then("Should display weight entered by user")
	public void should_display_weight_entered_by_user() {
	      
	}

	

	
	@Then("Goal weight should be displayed as the difference from the weekly target")
	public void goal_weight_should_be_displayed_as_the_difference_from_the_weekly_target() {
	      
	}
	
	@Then("Subcription details should be present in {int}-day goal section")
	public void subcription_details_should_be_present_in_day_goal_section(Integer int1) {
	      
	}
	
	@Then("Should display the user’s Height as entered during the onboarding process.")
	public void should_display_the_user_s_height_as_entered_during_the_onboarding_process() {
	      
	}
	
	@Then("App should have Starting weight, Goal , Weekly target, Daily Weigh-in")
	public void app_should_have_starting_weight_goal_weekly_target_daily_weigh_in() {
	      
	}
	
	@Then("BMI should be correctly calculated using the formula \\(Weight in kg \\/ \\(Height in m)^{int})")
	public void bmi_should_be_correctly_calculated_using_the_formula_weight_in_kg_height_in_m(Integer int1) {
	      
	}
	
	@Then("User should see  {string},{string}")
	public void user_should_see(String string, String string2) {
	      
	}
	
	@Then("Sub text should be located at the centre of the page")
	public void sub_text_should_be_located_at_the_centre_of_the_page() {
	      
	}
	
	@Then("Slider should not allow manual movement; it should remain fixed based on the user’s BMI")
	public void slider_should_not_allow_manual_movement_it_should_remain_fixed_based_on_the_user_s_bmi() {
	      
	}
	
	@Then("Should display the user’s weight as entered during the onboarding process.")
	public void should_display_the_user_s_weight_as_entered_during_the_onboarding_process() {
	      
	}
	
	
	@Then("Weight , Height , BMI , {int}-Day Goal,BMI Reference Guide")
	public void weight_height_bmi_day_goal_bmi_reference_guide(Integer int1) {
	      
	}
	
	
	
	@Then("Daily weigh in should be {string}")
	public void daily_weigh_in_should_be(String string) {
	      
	}
	
	@Then("User should see search bar in dashboard")
	public void user_should_see_search_bar_in_dashboard() {
	      
	}
	
	@Then("slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values")
	public void slider_should_display_a_continuous_gradient_from_blue_yellow_orange_red_representing_increasing_bmi_values() {
	      
	}
	
	@Then("Message “Free plan includes {int} days of limited tracking” should be displayed clearly below the slider")
	public void message_free_plan_includes_days_of_limited_tracking_should_be_displayed_clearly_below_the_slider(Integer int1) {
	      
	}
	

	
	@Then("Labels {string}, {string}, {string}, and {string} should be visible and color-coded accordingly")
	public void labels_and_should_be_visible_and_color_coded_accordingly(String string, String string2, String string3, String string4) {
	      
	}
	
	@Then("Circular pointer should automatically be positioned on the slider corresponding to the user’s BMI value")
	public void circular_pointer_should_automatically_be_positioned_on_the_slider_corresponding_to_the_user_s_bmi_value() {
	      
	}
	
	@Then("User should see {int} menus in dashboard")
	public void user_should_see_menus_in_dashboard(Integer int1) {
	      
	}
	
	@Then("User Name, {string},{string},{string},{string},  {string},{string}, {string},{string},  {string}")
	public void user_name(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
	      
	}

	
	/*-------------- Health Conditions - with condition--------------*/
	
	@Given("User has completed onboarding and selected one or more health conditions")
	public void user_has_completed_onboarding_and_selected_one_or_more_health_conditions() {
	      
	}
	
	
	@Then("Displayed condition\\(s) match exactly what was selected during onboarding, without requiring user input again")
	public void displayed_condition_s_match_exactly_what_was_selected_during_onboarding_without_requiring_user_input_again() {
	      
	}
	
	@Then("{string} appears below {string} card explaining how the plan is adjusted")
	public void appears_below_card_explaining_how_the_plan_is_adjusted(String string, String string2) {
	      
	}
	
	@Then("Card includes heart icon, condition name , and info icon with related text")
	public void card_includes_heart_icon_condition_name_and_info_icon_with_related_text() {
	      
	}
	
	
	/*-------------- Health Conditions - without condition--------------*/

	@Given("User has completed onboarding  without health conditions")
	public void user_has_completed_onboarding_without_health_conditions() {
	      
	}
	
	@Then("Message like “No health conditions selected” or an empty state is displayed")
	public void message_like_no_health_conditions_selected_or_an_empty_state_is_displayed() {
	      
	}
	
	
	/*-------------- Blood Report Insights - report uploaded--------------*/

	@Given("User has completed onboarding and uploaded report")
	public void user_has_completed_onboarding_and_uploaded_report() {
	      
	}
	
	@Then("Blood Report Insights section should display the personalized values and insights")
	public void blood_report_insights_section_should_display_the_personalized_values_and_insights() {
	      
	}
	
	/*-------------- Blood Report Insights - report not uploaded--------------*/

	@Given("User has completed onboarding and not uploaded report")
	public void user_has_completed_onboarding_and_not_uploaded_report() {
	      
	}
	
	@Then("User should see the {string} button")
	public void user_should_see_the_button(String string) {
	      
	}
	
	@Then("\"Upload your medical blood test report to receive AI-powered insights on how your results impact weight management and overall health.\"Message prompting them to upload their medical blood test report")
	public void upload_your_medical_blood_test_report_to_receive_ai_powered_insights_on_how_your_results_impact_weight_management_and_overall_health_message_prompting_them_to_upload_their_medical_blood_test_report() {
	      
	}
	
	@Then("{string} button should be enabled")
	public void button_should_be_enabled(String string) {
	      
	}
	
	/*-------------- Subscription Information--------------*/

	@Then("Joined date should be displayed")
	public void joined_date_should_be_displayed() {
	      
	}
	
	@Then("Todays date should be display")
	public void todays_date_should_be_display() {
	      
	}
	
	@Then("Subcription plan should be displayed")
	public void subcription_plan_should_be_displayed() {
	      
	}

	@Then("Status of plan should be displayed\\(how many days left out of {int} days free plan)")
	public void status_of_plan_should_be_displayed_how_many_days_left_out_of_days_free_plan(Integer int1) {
	      
	}

	@Then("{string} button should be displayed")
	public void button_should_be_displayed(String string) {
	      
	}
	
	/*-------------- Menstrual Cycle Insights--------------*/
	
	
	@Given("User has completed onboarding and last period start date as input")
	public void user_has_completed_onboarding_and_last_period_start_date_as_input() {
	      
	}
	
	@Then("Should display current menstrual phase in cycle insights section based on onboarding input")
	public void should_display_current_menstrual_phase_in_cycle_insights_section_based_on_onboarding_input() {
	      
	}
	
	@Then("Should display accurate number of days left in the cycle")
	public void should_display_accurate_number_of_days_left_in_the_cycle() {
	      
	}
	
	@Then("{string} should be displayed accurately based on onboarding input")
	public void should_be_displayed_accurately_based_on_onboarding_input(String string) {
	      
	}
	
	@Then("{string} count displayed should match the number of days since the last period start date")
	public void count_displayed_should_match_the_number_of_days_since_the_last_period_start_date(String string) {
	      
	}
	
	@Then("Filled portion should visually represent the proportion of days completed in the current cycle")
	public void filled_portion_should_visually_represent_the_proportion_of_days_completed_in_the_current_cycle() {
	      
	}
	
	@Then("Should display “x days” as the countdown to the next period")
	public void should_display_x_days_as_the_countdown_to_the_next_period() {
	      
	}
	
	@Then("User should be redirected to the full Menstrual cycle Tracker page")
	public void user_should_be_redirected_to_the_full_menstrual_cycle_tracker_page() {
	      
	}
	
	@Then("Message {string} should be displayed")
	public void message_should_be_displayed(String string) {
	      
	}
	
	@Then("Hormonal Impact on Weight message should match the expected text for that phase")
	public void hormonal_impact_on_weight_message_should_match_the_expected_text_for_that_phase() {
	      
	}
	
	@Then("Symptoms listed should correspond to the expected symptoms for that phase")
	public void symptoms_listed_should_correspond_to_the_expected_symptoms_for_that_phase() {
	      
	}
	
	@Then("Cravings displayed should match the expected cravings for that phase")
	public void cravings_displayed_should_match_the_expected_cravings_for_that_phase() {
	      
	}
	
	
	/*-------------- Dashboard - Functionality--------------*/
	
	@When("User clicks on profile name")
	public void user_clicks_on_profile_name() {
	      
	}

	@Then("User should see {string}, {string}, {string} , {string} options")
	public void user_should_see_options(String string, String string2, String string3, String string4) {
	      
	}
	
	@When("User clicks on activity Insight")
	public void user_clicks_on_activity_insight() {
	      
	}

	@Then("User should see  Track Weight\", Food Intake\" , {string}")
	public void user_should_see_track_weight_food_intake(String string) {
	      
	}
	
	@When("User clicks on Diet plan button")
	public void user_clicks_on_diet_plan_button() {
	      
	}

	@Then("User should redirected to diet-plan page")
	public void user_should_redirected_to_diet_plan_page() {
	      
	}

	@When("User clicks on workout button")
	public void user_clicks_on_workout_button() {
	      
	}

	@Then("User should redirected to workout page")
	public void user_should_redirected_to_workout_page() {
	      
	}
	
	@When("User clicks on water tracker button")
	public void user_clicks_on_water_tracker_button() {
	      
	}

	@Then("User should redirected to water tracker page")
	public void user_should_redirected_to_water_tracker_page() {
	      
	}
	
	@When("User clicks on View Full Cycle Details")
	public void user_clicks_on_view_full_cycle_details() {
	      
	}

	@Then("User should be redirected to Menstrual cycle tracker page")
	public void user_should_be_redirected_to_menstrual_cycle_tracker_page() {
	      
	}
	
	@When("User clicks on Upload Blood report")
	public void user_clicks_on_upload_blood_report() {
	      
	}

	@Then("User should be redirected to explorer to choose the file")
	public void user_should_be_redirected_to_explorer_to_choose_the_file() {
	      
	}
	
	@When("User clicks on  Upgrade to Premium")
	public void user_clicks_on_upgrade_to_premium() {
	      
	}

	@Then("User should be redirected to Subcription page")
	public void user_should_be_redirected_to_subcription_page() {
	      
	}
	
	@When("User clicks on Generate {int}-Day Plan")
	public void user_clicks_on_generate_day_plan(Integer int1) {
	      
	}

	@Then("User should be redirected to diet-plan page")
	public void user_should_be_redirected_to_diet_plan_page() {
	      
	}
	
	@When("User clicks on See Premium Plans")
	public void user_clicks_on_see_premium_plans() {
	      
	}
	
	
	/*-------------- Dashboard - Profile sub menu functionality --------------*/
	
	@When("User clicks on Home")
	public void user_clicks_on_home() {
	      
	}

	@Then("User should be redirected to dashboard option")
	public void user_should_be_redirected_to_dashboard_option() {
	      
	}
	
	@When("User clicks on Edit Profile")
	public void user_clicks_on_edit_profile() {
	      
	}

	@Then("User should be redirected to Edit Your Profile page")
	public void user_should_be_redirected_to_edit_your_profile_page() {
	      
	}
	
	@When("User clicks on Subscription")
	public void user_clicks_on_subscription() {
	      
	}

	@Then("User should be redirected to Subscription Management page")
	public void user_should_be_redirected_to_subscription_management_page() {
	      
	}
	
	@When("User clicks on Logout")
	public void user_clicks_on_logout() {
	      
	}

	@Then("User should be logged out of the application")
	public void user_should_be_logged_out_of_the_application() {
	      
	}

	/*-------------- Dashboard - Activity Insights sub menu functionality --------------*/
	
	@When("User clicks on Track Weight")
	public void user_clicks_on_track_weight() {
	      
	}

	@Then("User should be redirected to  track weight page")
	public void user_should_be_redirected_to_track_weight_page() {
	      
	}
	
	@When("User clicks on Food Intake")
	public void user_clicks_on_food_intake() {
	      
	}

	@Then("User should be redirected to food intake page")
	public void user_should_be_redirected_to_food_intake_page() {
	      
	}

	@When("User clicks on Menstrual Phase Logs")
	public void user_clicks_on_menstrual_phase_logs() {
	     
	}

	@Then("User should be redirected to menstrual phase log page")
	public void user_should_be_redirected_to_menstrual_phase_log_page() {
	   
	}


	
	
	
	
	
	
	
	
	
	
}
