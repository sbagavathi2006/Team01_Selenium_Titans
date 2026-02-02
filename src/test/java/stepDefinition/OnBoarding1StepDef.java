package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoarding1StepDef {
	
	@Given("User is on sign up page")
	public void user_is_on_sign_up_page() {

	}

	@When("User clicks register button after entering valid details")
	public void user_clicks_register_button_after_entering_valid_details() {
	   
	}

	@Then("Title of the page should be Upload Your Recent Blood Work")
	public void title_of_the_page_should_be_upload_your_recent_blood_work() {

	}
	
	@Then("Step {int} should have supporting text")
	public void step_should_have_supporting_text(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
