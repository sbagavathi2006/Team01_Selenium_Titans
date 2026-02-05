package stepDefinition;

import java.util.List;

import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding4StepDef {
	
	private TestContextSetup testContext;
	CommonMethods comMethods;

	
	public OnBoarding4StepDef(TestContextSetup testContext) {
		this.testContext = testContext;
	}
	
	@Given("User is in step Four of onboarding")
	public void user_is_in_step_four_of_onboarding() {
		  testContext.signUpPage().clickSignUpButton();
	      testContext.signUpPage().registerWithValidDynamicData(testContext);
	      testContext.onBrdPage1().clickContWithOutRt();
	      testContext.onBrdPage3().clickBtnContinue(testContext);
	      Assert.assertTrue(
					testContext.onBrdPage4().isProgressBar4_10Displayed(),
			        "User is not on onboarding step 4"
			    );
			LoggerLoad.info("User is on Step3 onboarding page");
	}

	@When("User clicks continue button after entering invalid value {string} in first name")
	public void user_clicks_continue_button_after_entering_invalid_value_in_first_name(String string) {
		testContext.onBrdPage3Fn().enterFirstName(string);
		testContext.onBrdPage3Fn().clickBtnContinueStep4();
		Assert.assertTrue(
				testContext.onBrdPage4().isProgressBar4_10Displayed(),
		        "User is not on onboarding step 4"
		    );
		LoggerLoad.info("User in Step 4 due to invalid name" );
	}
	
	@Then("Error message {string} displayed")
	public void error_message_displayed(String expectedString) {
	    Assert.assertEquals(testContext.onBrdPage3Fn().alertMsgValidationName(),expectedString );
	    LoggerLoad.info("Please enter a number - alert is displayed");
	}

	@When("User clicks continue button after entering invalid value {string} in age")
	public void user_clicks_continue_button_after_entering_invalid_value_in_age(String string) {
		testContext.onBrdPage3Fn().enterInvalidAge(string);
		testContext.onBrdPage3Fn().clickBtnContinueStep4();
		Assert.assertTrue(
				testContext.onBrdPage4().isProgressBar4_10Displayed(),
		        "User is not on onboarding step 4"
		    );
		LoggerLoad.info("User in Step 4 due to invalid age" );

	}
		@Then("Error message {string} should displayed")
	public void error_message_should_displayed(String expectedString) {
	    Assert.assertEquals(testContext.onBrdPage3Fn().alertMsgValidationAge(),expectedString );
	    LoggerLoad.info("Please enter a number - alert is displayed");
	}

	@When("User clicks continue button without selecting blood pressure staus")
	public void user_clicks_continue_button_without_selecting_blood_pressure_staus() {
		testContext.onBrdPage3Fn().clickBtnContinueStep4();
		Assert.assertTrue(
				testContext.onBrdPage4().isProgressBar4_10Displayed(),
		        "User is not on onboarding step 4"
		    );
		LoggerLoad.info("User in Step 4 due not selecting the BP status" );
	}
	
	@Then("Error message is displayed")
	public void error_message_is_displayed() {
	    Assert.assertTrue(testContext.onBrdPage3Fn().errMsgValidationBPStatus(),
	    		"Error Validation Msg not displayed - Please select your blood pressure status");
	    LoggerLoad.info("Please select your blood pressure status - error is displayed");
	}

	@When("User clicks back button in step Four")
	public void user_clicks_back_button_in_step_four() {
	    testContext.onBrdPage3Fn().clickBtnBackStep4();
	    Assert.assertTrue(testContext.onBrdPage3().isProgressBar3_10Displayed());
	    LoggerLoad.info(" User is on Step 3 after clicking back button from step 4");
	}

	@Then("Redirected to Step Three")
	public void redirected_to_step_three() {
	    Assert.assertTrue(testContext.onBrdPage3().isProgressBar3_10Displayed());
	    LoggerLoad.info(" User is on Step 3 after clicking back button from step 4");
	}

	@When("User clicks continue after entering  all required details")
	public void user_clicks_continue_after_entering_all_required_details() {
	  String firstName = (String) testContext.getScenarioData("USERNAME");
		LoggerLoad.info("UserName is: => " + firstName);

	  int age = CommonMethods.generateRandomAge();
	  testContext.setScenarioData("AGE", age);
		LoggerLoad.info("Random Age: => " + age);

	  testContext.onBrdPage3Fn().enterFirstName(firstName);
	  testContext.onBrdPage3Fn().enterValidAge(String.valueOf(age));
	  testContext.onBrdPage3Fn().randomBPStatusSelection(testContext);
	  testContext.onBrdPage3Fn().clickBtnContinueStep4();
	    Assert.assertTrue(testContext.onBrdPage4().isCurrentStep5_10Displayed(),
	    		"User is not on step 5/10");
	    LoggerLoad.info("User is on Step 5/10");
	  
	}

	@Then("Redirected to Step Five")
	public void redirected_to_step_five() {
	    Assert.assertTrue(testContext.onBrdPage4().isCurrentStep5_10Displayed(),
	    		"User is not on step 5/10");
	    LoggerLoad.info("User is on Step 5/10");
	}
	
	@Then("Onboarding progress bar is visible")
	public void visible() {
	    Assert.assertTrue(testContext.onBrdPage4().isProgressBarDisplayed(),
	    		"Onboarding progress bar is not displayed");
	    LoggerLoad.info("Onboarding progress bar is displayed");
	}

	@Then("Progress bar shows the current step as  Five of Ten")
	public void progress_bar_shows_the_current_step_as_five_of_ten() {
		Assert.assertTrue(testContext.onBrdPage4().isCurrentStep5_10Displayed(),
	    		"Progress bar not displaying step 5/10");
	    LoggerLoad.info("Progress bar displaying step 5/10");
	}
	
	@Then("Back button is displayed on Mensural Cycle page")
	public void back_button_is_displayed_on_mensural_cycle_page() {
	    Assert.assertTrue(testContext.onBrdPage4().isBackBtnDisplayed(),
	    		"BackBtn is not displayed on Mensural Cycle page");
	    LoggerLoad.info("BackBtn is displayed on Mensural Cycle page");
	}
	
	@Then("Back button should be enabled on Mensural Cycle page")
	public void back_button_should_be_enabled_on_mensural_cycle_page() {
	    Assert.assertTrue(testContext.onBrdPage4().isBackBtnEnabled(),
	    		"BackBtn is not enabled on Mensural Cycle page");
	    LoggerLoad.info("BackBtn is enabled on Mensural Cycle page");
	}
	
	@Then("Continue button should be displayed on Mensural Cycle page")
	public void continue_button_should_be_displayed_on_mensural_cycle_page() {
	    Assert.assertTrue(testContext.onBrdPage4().isContinueBtnDisplayed(),
	    		"Continue button is not displayed on Mensural Cycle page");
	    LoggerLoad.info("Continue button is displayed on Mensural Cycle page");
	}
	
	@Then("Continue button should be enabled on Mensural Cycle page")
	public void continue_button_should_be_enabled_on_mensural_cycle_page() {
	    Assert.assertTrue(testContext.onBrdPage4().isContinueBtnEnabled(),
	    		"Continue button is not enabled on Mensural Cycle page");
	    LoggerLoad.info("Continue button is enabled on Mensural Cycle page");
	}

	@Then("Should see the title Menstrual Cycle Awareness {string}")
	public void should_see_the_title_menstrual_cycle_awareness(String expectedText) {
	    Assert.assertEquals(testContext.onBrdPage4().pageHeader(), expectedText);
	    LoggerLoad.info("Menstrual Cycle Awareness header text is displayed");
	}

	@Then("Description text {string}")
	public void description_text(String expectedText) {
		Assert.assertEquals(testContext.onBrdPage4().pageHeaderDescription(), expectedText,
				"Expected: "+ expectedText + "Actual: " +testContext.onBrdPage4().pageHeaderDescription() );
	    LoggerLoad.info("Understanding your cycle helps us optimize your weight loss journey is visible");   
	}

	@Then("Question {string} should be visible")
	public void question_should_be_visible(String expectedText ) {
		Assert.assertEquals(testContext.onBrdPage4().pageHeader3(), expectedText);
	    LoggerLoad.info("Do you currently track your menstrual cycle is visible"); 
	}

	@Then("{int} radio button should be visible")
	public void radio_button_should_be_visible(Integer int1) {
	   Assert.assertEquals(testContext.onBrdPage4().countOfRadioBtns(), int1 );
	   LoggerLoad.info("4 radio buttons are visible");
	}

	@Then("Radio options {string} for  menstrual cycle awareness should be displayed")
	public void radio_options_for_menstrual_cycle_awareness_should_be_displayed(String expectedField) {
		List<String> radioBtnLabels =
	            testContext.onBrdPage4().getRadioBtnsText();
		
	        for (String label : radioBtnLabels) {
	            if (label.equals(expectedField)) {
	                Assert.assertTrue(true, 
	              "Radio Btn Label is not correct, ExpectedLabel :" + expectedField + " ActualLabel: " +label);
	                return;
	            }
	        }
	    
	    LoggerLoad.info("Each field has it correct description");
	}


}
