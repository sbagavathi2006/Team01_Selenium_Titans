package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditYourProfileStepDef {

	/*-------------- Free Plan Dashboard UI --------------*/
	
	@When("User clicks on profile name and click on edit profile")
	public void user_clicks_on_profile_name_and_click_on_edit_profile() {
	    
	}

	@Then("Edit your Profile should be visible")
	public void edit_your_profile_should_be_visible() {
	   
	}

	@Then("Update your personal information and preferences should be visible")
	public void update_your_personal_information_and_preferences_should_be_visible() {
	  
	}

	@Then("There should be exactly {int} tabs")
	public void there_should_be_exactly_tabs(Integer int1) {
	   
	}

	@Then("“Basic Information” ,“Body Metrics”,“Preferences & Health” tabs should be visible")
	public void basic_information_body_metrics_preferences_health_tabs_should_be_visible() {
	
	}

	@Then("Basic Information should be visible by default")
	public void basic_information_should_be_visible_by_default() {
	    
	}

	@Then("Back Button should be visible")
	public void back_button_should_be_visible() {
	  
	}
	
	/*-------------- Edit Your Profile-Basic Information -UI verifications --------------*/
	
	@When("User navigates to Edit Profile")
	public void user_navigates_to_edit_profile() {
	   
	}

	
	@When("User clicks Basic Information tab")
	public void user_clicks_basic_information_tab() {
	    
	}

	@Then("{string} should be visible inside section")
	public void should_be_visible_inside_section(String string) {
	  
	}

	@Then("{string} sub text should be visible")
	public void sub_text_should_be_visible(String string) {
	    
	}

	@Then("Should display the user’s Name and age as entered during the onboarding process.")
	public void should_display_the_user_s_name_and_age_as_entered_during_the_onboarding_process() {
	   
	}

	@Then("Name and Age fields should be properly aligned vertically with equal spacing")
	public void name_and_age_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	   
	}

	@When("User clicks {string} Button")
	public void user_clicks_button(String string) {
	   
	}

	@Then("“Next: Body Metrics” button should be visible and enabled")
	public void next_body_metrics_button_should_be_visible_and_enabled() {
	   
	}
	
	/*-------------- Edit Your Profile-Body Metrics -UI verifications --------------*/
	
	@When("User clicks Body Metrics Tab")
	public void user_clicks_body_metrics_tab() {
	 
	}

	@Then("Should display the user’s Weight and Height are as entered during the onboarding process")
	public void should_display_the_user_s_weight_and_height_are_as_entered_during_the_onboarding_process() {
	   
	}

	@Then("Please enter your height in decimal format should be visible")
	public void please_enter_your_height_in_decimal_format_should_be_visible() {
	 
	}

	@Then("\"kg\"or {string} unit values in dropdown should be visible and enabled")
	public void kg_or_unit_values_in_dropdown_should_be_visible_and_enabled(String string) {
	    
	}

	@Then("{string} or {string} unit values in dropdown should be visible and enabled")
	public void or_unit_values_in_dropdown_should_be_visible_and_enabled(String string, String string2) {
	   
	}

	@Then("Weight and Height fields should be properly aligned vertically with equal spacing")
	public void weight_and_height_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	   
	}

	@Then("BMI Calculation Number should be displayed with a gradient slider and labels")
	public void bmi_calculation_number_should_be_displayed_with_a_gradient_slider_and_labels() {
	  
	}

	@Then("BMI Category section should present with BMI Category")
	public void bmi_category_section_should_present_with_bmi_category() {
	  
	}

	@Then("BMI Category note should be visible")
	public void bmi_category_note_should_be_visible() {
	   
	}

	@Then("{string} Button should be visible and enabled")
	public void button_should_be_visible_and_enabled(String string) {
	    
	}

	@Then("“Next: Preferences” button should be visible and enabled")
	public void next_preferences_button_should_be_visible_and_enabled() {
	   
	}
	@Then("User should see Body Metric Section")
	public void user_should_see_body_metric_section() {
	
	}

	@When("User clicks on Back Button on Body Metric section")
	public void user_clicks_on_back_button_on_body_metric_section() {
	   
	}

	@Then("User should see {string} section")
	public void user_should_see_section(String string) {
	  
	}

	@Then("User should see  Prefrences & Health Section")
	public void user_should_see_prefrences_health_section() {
	   
	}

	@Then("User clicks on Back Button on  Preferences & Health section")
	public void user_clicks_on_back_button_on_preferences_health_section() {
	   
	}

	
	/*-------------- Edit Your Profile-Prefrences and Health  -UI verifications --------------*/
	
	@When("User clicks Preferences & Health Tab")
	public void user_clicks_preferences_health_tab() {
	   
	}

	@Then("{string} should be visible")
	public void should_be_visible(String string) {
	   
	}

	@Then("{string}, {string},{string}, {string} RadioButtons should be visible and enabled")
	public void radio_buttons_should_be_visible_and_enabled(String string, String string2, String string3, String string4) {
	 
	}

	@When("User clicks on Save Profile on  Preferences & Health section after editing values in any field")
	public void user_clicks_on_save_profile_on_preferences_health_section_after_editing_values_in_any_field() {
	    
	}

	@Then("User should see success message {string}")
	public void user_should_see_success_message(String string) {
	  
	}

	@When("User clicks on Add Medication button")
	public void user_clicks_on_add_medication_button() {
	  
	}

	@Then("User should see a Pop Up {string}")
	public void user_should_see_a_pop_up(String string) {
	
	}
	
	@When("User navigates to Preferences & Health Tab")
	public void user_navigates_to_preferences_health_tab() {
	  
	}
	
	/*-------------- Preferences & Health -Add Medication UI verification --------------*/
	
	@Then("Enter Medication name should be visible")
	public void enter_medication_name_should_be_visible() {
	   
	}

	@Then("Should display empty input field for entering medication name")
	public void should_display_empty_input_field_for_entering_medication_name() {
	  
	}
	
	@Then("{string} and {string} buttons should displayed")
	public void and_buttons_should_displayed(String string, String string2) {
	
	}
	
	@When("User navigates to Add Medication button")
	public void user_navigates_to_add_medication_button() {
	   
	}

	@When("User clicks on Ok button after adding medication")
	public void user_clicks_on_ok_button_after_adding_medication() {
	   
	}

	@When("User clicks on cancel button without adding medication details")
	public void user_clicks_on_cancel_button_without_adding_medication_details() {
	  
	}

	@Then("User should naviagte back to Preferences & Health Section page")
	public void user_should_naviagte_back_to_preferences_health_section_page() {
	  
	}

	
	
	
}
