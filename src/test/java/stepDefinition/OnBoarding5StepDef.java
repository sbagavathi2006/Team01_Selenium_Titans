package stepDefinition;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
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
					testContext.onBrdPage5().isStep5_10Displayed(),
			        "User is not on onboarding step 5");
			LoggerLoad.info("User is on Step 5 onboarding page");
	}

	@When("User clicks continue button without selecting menstrual cycle")
	public void user_clicks_continue_button_without_selecting_menstrual_cycle() {
		testContext.onBrdPage5().clickBtnContinueStep5(testContext);
		try {
	        String actualErr = testContext.onBrdPage5().getMenstrualCycleErrorMessage();
	        Assert.assertEquals(actualErr, "Err Msg is not displayed since continue btn is disabled");

	    } catch (NoSuchElementException   e) {
	        LoggerLoad.info(
	            "Error message not displayed as continue button is disabled"
	        );
	    }

	}
	
	@Then("Error message {string} should be displayed on menstrual cycle")
	public void error_message_should_be_displayed_on_menstrual_cycle(String string) {
	     Assert.assertTrue(
					testContext.onBrdPage5().isStep6_10Displayed(),
			        "User is not on onboarding step 6"
			    );
		LoggerLoad.info("User is on Step 6 onboarding page");

	}

	@When("User clicks back button in step Five")
	public void user_clicks_back_button_in_step_five() {
	    testContext.onBrdPage5().clickBackBtn();
	    Assert.assertTrue(
				testContext.onBrdPage4().isProgressBar4_10Displayed(),
		        "User is not on onboarding step 4"
		    );
	LoggerLoad.info("User is on Step 4 onboarding page");
	}

	@When("User clicks continue after selecting menstrual cycle info")
	public void user_clicks_continue_after_selecting_menstrual_cycle_info() {
	   testContext.onBrdPage5().clickBtnContinueRandomMenstrualCycle(testContext);
	   Assert.assertTrue(
				testContext.onBrdPage5().isStep6_10Displayed(),
		        "User is not on onboarding step 6"
		    );
	LoggerLoad.info("User is on Step 6 onboarding page");
	}
	
//	@Then("Redirected to Step Four")
//	public void redirected_to_step_four() {
//	     Assert.assertTrue(
//					testContext.onBrdPage5().isStep4_10Displayed(),
//			        "User is not on onboarding step 4"
//			    );
//		LoggerLoad.info("User is on Step 4 onboarding page");
//
//	}

	@Then("Redirected to Step Six")
	public void redirected_to_step_six() {
	     Assert.assertTrue(
					testContext.onBrdPage5().isStep6_10Displayed(),
			        "User is not on onboarding step 6"
			    );
		LoggerLoad.info("User is on Step 6 onboarding page");

	}

	@Then("UI Element {string} should be displayed on menstrual cycle info page")
	public void ui_element_should_be_displayed_on_menstrual_cycle_info_page(String element) {
	    Assert.assertTrue(
				testContext.onBrdPage5().verifyElementDisplay(element),
				element+ " is displayed"
		    );
	LoggerLoad.info(element+ " is displayed");
	}

	@Then("UI Element {string} should be enabled on menstrual cycle info page")
	public void ui_element_should_be_enabled_on_menstrual_cycle_info_page(String element) {
		Assert.assertTrue(
				testContext.onBrdPage5().verifyElementEnabled(element),
				element+ " is enabled"
		    );
	LoggerLoad.info(element+ " is enabled");	    
	}

	@Then("UI Element {string} should be matched on menstrual cycle info page")
	public void ui_element_should_be_matched_on_menstrual_cycle_info_page(String expectedText) {
	    By locator = testContext.onBrdPage5().matchElementMap().get(expectedText);

	    if (locator == null) {
	        throw new IllegalArgumentException(
	                "No UI element mapped for text: " + expectedText);
	    }

	    String actualText = testContext.onBrdPage5().GetElemenToMatch(locator);

	    Assert.assertEquals(actualText, expectedText, "ActualText: " + actualText + "ExpectedText: " + expectedText);

	    LoggerLoad.info("UI text matched successfully: " + expectedText);
	}
}
