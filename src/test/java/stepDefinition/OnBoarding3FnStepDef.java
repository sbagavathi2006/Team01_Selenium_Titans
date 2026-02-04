package stepDefinition;

import java.util.List;

import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class OnBoarding3FnStepDef {

	private TestContextSetup testContext;
	
	public OnBoarding3FnStepDef(TestContextSetup testContext) {
		this.testContext = testContext;
	}
	
	@Given("User is in step Three of onboarding")
	public void user_is_in_step_three_of_onboarding() {
		  testContext.signUpPage().clickSignUpButton();
	      testContext.signUpPage().registerWithValidDynamicData(testContext);
	      testContext.onBrdPage1().clickContWithOutRt();
	      Assert.assertTrue(
					testContext.onBrdPage3().isProgressBar3_10Displayed(),
			        "User is not on onboarding step 3"
			    );
			LoggerLoad.info("User is on Step3 onboarding page");
	}

	@When("User clicks continue selects health condition")
	public void user_clicks_continue_selects_health_condition() {
		testContext.onBrdPage3().clickBtnContinue(testContext);

	      Assert.assertTrue(
					testContext.onBrdPage3Fn().isProgressBar4_10Displayed(),
			        "User is not on onboarding step 4"
			    );
			LoggerLoad.info("User is on Step4 onboarding page");
	}

	@Then("Redirected to Step Four")
	public void redirected_to_step_four() {
	      Assert.assertTrue(
					testContext.onBrdPage3Fn().isProgressBar4_10Displayed(),
			        "User is not on onboarding step 4"
			    );
			LoggerLoad.info("User is on Step4 onboarding page");
	}

	@Then("Progress bar shows the current step as Four of Ten")
	public void progress_bar_shows_the_current_step_as_four_of_ten() {
		Assert.assertTrue(
				testContext.onBrdPage3Fn().isProgressBar4_10Displayed(),
		        "User is not on onboarding step 4"
		    );
		LoggerLoad.info("Progress bar correctly shows 4/10");
	}

	@Then("Should see the title Personal Details")
	public void should_see_the_title_personal_details() {
		Assert.assertTrue(
				testContext.onBrdPage3Fn().isStep4HeaderDisplayed(),
		        "Header is not displayed-Personal Details"
		    );
		LoggerLoad.info("Header displayed Personal Details text");
	}

	@Then("Description text should be displayed")
	public void description_text_should_be_displayed() {
		Assert.assertTrue(
				testContext.onBrdPage3Fn().isDescriptionDisplayed(),
		        "Description is not displayed- Let's get to know you better to personalize your experience."
		    );
		LoggerLoad.info("Header description text displayed");
	}

	@Then("Input box should be two {int}")
	public void input_box_should_be_two(int expectedInt) {
	    Assert.assertEquals(testContext.onBrdPage3Fn().countInputBoxes(), expectedInt);
	    LoggerLoad.info("Input box count is 2");
	}

	@Then("Field labels should be {string} displayed")
	public void input_box_should_be_displayed(String labels) {
		Assert.assertTrue(testContext.onBrdPage3Fn().isfieldLabelDisplayed(labels),
				"Field label is not displayed" + labels);
	    LoggerLoad.info("Field Label displayed");
	}

	@Then("Under each {string} field helper text {string} should be matched")
	public void under_each_field_helper_text_should_be_matched(String expectedField, String expectedFieldDesc) {
		 List<String> fieldLabels =
		            testContext.onBrdPage3Fn().getFieldLabelList();

		    List<String> fieldLabelDescs =
		            testContext.onBrdPage3Fn().getFieldLabelDescList();

		    for (String field : fieldLabels) {
		        for (String desc : fieldLabelDescs) {
		            if (field.equals(expectedField) &&
		            		desc.equals(expectedFieldDesc)) {

		                Assert.assertTrue(true);
		                return;
		            }
		        }
		    }
		    LoggerLoad.info("Each field has it correct description");
	}

	@Then("Radio button should be visible")
	public void radio_button_should_be_visible() {
	  Assert.assertTrue(testContext.onBrdPage3Fn().isRadioButtonDisplayed(), 
			  "Radio buttons are not displayed") ;
	    LoggerLoad.info("Radio buttons are displayed");

	}

	@Then("Text {string} displayed")
	public void text_displayed(String text) {
	    Assert.assertTrue(testContext.onBrdPage3Fn().isradioBtnTextsDisplayed(text),
	    		"Radio button description is not displayed" + text);
	    LoggerLoad.info("Radio button description is displayed");

	}
	
}
