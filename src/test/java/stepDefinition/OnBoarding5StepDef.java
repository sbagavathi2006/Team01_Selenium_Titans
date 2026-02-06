package stepDefinition;

import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding5StepDef {

	private TestContextSetup testContext;
	CommonMethods comMethods;
	
	public OnBoarding5StepDef(TestContextSetup testContext) {
		this.testContext = testContext;
	}
	
	@Given("User is in step Five of onboarding")
	public void user_is_in_step_five_of_onboarding() {
		  testContext.signUpPage().clickSignUpButton();
	      testContext.signUpPage().registerWithValidDynamicData(testContext);
	      testContext.onBrdPage1().clickContWithOutRt();
	      testContext.onBrdPage3().clickBtnContinue(testContext);
	      
		  String firstName = (String) testContext.getScenarioData("USERNAME");
		  int age = CommonMethods.generateRandomAge();
		  testContext.onBrdPage3Fn().enterFirstName(firstName);
		  testContext.onBrdPage3Fn().enterValidAge(String.valueOf(age));
		  testContext.onBrdPage3Fn().randomBPStatusSelection(testContext);
		  testContext.onBrdPage3Fn().clickBtnContinueStep4();
	      
	      Assert.assertTrue(
					testContext.onBrdPage4().isProgressBar4_10Displayed(),
			        "User is not on onboarding step 4"
			    );
			LoggerLoad.info("User is on Step3 onboarding page");
	}

	@When("User clicks continue button without selecting menstrual cycle")
	public void user_clicks_continue_button_without_selecting_menstrual_cycle() {
	   
	}

	@When("User clicks back button in step Five")
	public void user_clicks_back_button_in_step_five() {
	    
	}

	@When("User clicks continue after selecting menstrual cycle info")
	public void user_clicks_continue_after_selecting_menstrual_cycle_info() {
	   
	}

	@Then("Redirected to Step Six")
	public void redirected_to_step_six() {
	   
	}

	@Then("UI Element {string} should be displayed on menstrual cycle info page")
	public void ui_element_should_be_displayed_on_menstrual_cycle_info_page(String string) {
	    
	}

	@Then("UI Element {string} should be enabled on menstrual cycle info page")
	public void ui_element_should_be_enabled_on_menstrual_cycle_info_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("UI Element {string} should be matched on menstrual cycle info page")
	public void ui_element_should_be_matched_on_menstrual_cycle_info_page(String string) {
	    
	}
}
