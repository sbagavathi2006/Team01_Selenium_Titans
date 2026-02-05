package stepDefinition;

import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class OnBoarding3StepDef {
	
	private TestContextSetup testContext;
	
    public OnBoarding3StepDef(TestContextSetup context) {
   	 this.testContext = context;
   }
	
	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() {
	  testContext.signUpPage().clickSignUpButton();
      testContext.signUpPage().registerWithValidDynamicData(testContext);
		Assert.assertTrue(
				testContext.onBrdPage1().isProgressBar1_10Displayed(),
		        "User is not on onboarding step 1"
		    );
		LoggerLoad.info("User is on Step1 onboarding page");

	}

	@When("User clicks continue without report")
	public void user_clicks_continue_without_report() {
	    testContext.onBrdPage1().clickContWithOutRt();
		Assert.assertTrue(
				testContext.onBrdPage3().isProgressBar3_10Displayed(),
		        "User is not on onboarding step 1"
		    );
		LoggerLoad.info("User is on step 3 onboarding page");

	}

	@Then("Progress bar shows the current step as Three of Ten")
	public void progress_bar_shows_the_current_step_as_three_of_ten() {
		testContext.onBrdPage3().isProgressBar3_10Displayed();
		Assert.assertTrue(
				testContext.onBrdPage3().isProgressBar3_10Displayed(),
		        "User is not on onboarding step 3"
		    );
		LoggerLoad.info("Progress bar correctly shows 3/10");

	}

	@Then("Back button is displayed")
	public void back_button_is_displayed() {
	   testContext.onBrdPage3().isBackBtnDisplayed();
		Assert.assertTrue(
				testContext.onBrdPage3().isBackBtnDisplayed(),
		        "Back Btn is not displayed"
		    );
		LoggerLoad.info("Back btn displayed");

	}

	@Then("Back button should be enabled")
	public void back_button_should_be_enabled() {
	    testContext.onBrdPage3().isBackBtnEnabled();
		Assert.assertTrue(
				testContext.onBrdPage3().isBackBtnEnabled(),
		        "Back Btn is not enabled"
		    );
		LoggerLoad.info("Back Btn enabled");

	}

	@Then("Continue button should be visible")
	public void continue_button_should_be_visible() {
		Assert.assertTrue(
				
				testContext.onBrdPage3().isContinueBtnDisplayed(),
		        "Continue Btn is not displayed"
		    );
		LoggerLoad.info("Continue btn displayed");

	}

	@Then("Continue button should be enabled")
	public void continue_button_should_be_enabled() {
	    testContext.onBrdPage3().isContinueBtnEnabled();
		Assert.assertTrue(
				testContext.onBrdPage3().isContinueBtnEnabled(),
		        "Continue Btn is not enabled"
		    );
		LoggerLoad.info("Contineu Btn enabled");
   
	}

	@Then("Header should be Health condition")
	public void header_should_be_health_condition() {
	    testContext.onBrdPage3().isStep3HeaderDisplayed();
		Assert.assertTrue(
				testContext.onBrdPage3().isStep3HeaderDisplayed(),
		        "Header is not displayed-Health Condition"
		    );
		LoggerLoad.info("Header displayed Health Condition text");
	}

	@Then("Sub title should be displayed")
	public void sub_title_should_be_displayed() {
	    testContext.onBrdPage3().isSubTitleHeaderDisplayed();
		Assert.assertTrue(
				testContext.onBrdPage3().isSubTitleHeaderDisplayed(),
		        "SubTitel is not displayed- Want to manually enter any key conditions or comorbidities?"
		    );
		LoggerLoad.info("Exact sub title text displayed");
	}

	@Then("Nine radio button should be visible")
	public void nine_radio_button_should_be_visible() {
	    testContext.onBrdPage3().isNineRadioBtnDisplayed();
		Assert.assertTrue(
				testContext.onBrdPage3().isNineRadioBtnDisplayed(),
		        "9 Radio button not visible "
		    );
		LoggerLoad.info("9 radio button displayed");
	}

	@Then("Health Condition {string} should be visible")
	public void health_condition_should_be_visible(String text) {
	    testContext.onBrdPage3().isCheckBoxTextVisible(text);
		Assert.assertTrue(
				testContext.onBrdPage3().isCheckBoxTextVisible(text),
		        "Health Condition :"+text+" is not visible"
		    );
		LoggerLoad.info("Health condition text are visible");
	}

	@Then("Note text should displayed")
	public void note_text_should_displayed() {
	    testContext.onBrdPage3().isInfoNoteDisplayed();
		Assert.assertTrue(
				testContext.onBrdPage3().isInfoNoteDisplayed(),
		        "Note is not visible"
		    );
		LoggerLoad.info("Note is visible");
	}

}
