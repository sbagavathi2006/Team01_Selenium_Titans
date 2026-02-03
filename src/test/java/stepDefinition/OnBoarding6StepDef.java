package stepDefinition;

import org.testng.Assert;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnBoarding6Page;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding6StepDef {
	private OnBoarding6Page onBrdPage6;
	
	
	  public OnBoarding6StepDef() {
		  onBrdPage6 = new OnBoarding6Page(DriverFactory.getDriver());
	    }
	
	@Given("User completes onboarding until step {int}")
	public void user_completes_onboarding_until_step(Integer int1) {
		onBrdPage6.continueToStep1_2();
		LoggerLoad.info("On boarding for step1&2 is succesfull");
		onBrdPage6.continueToStep3();
		LoggerLoad.info("On boarding for step3 is succesfull");
		onBrdPage6.continueToStep4();
		LoggerLoad.info("On boarding for step4 is succesfull");
		onBrdPage6.continueToStep5();
		LoggerLoad.info("On boarding for step5 is succesfull");
		LoggerLoad.info("sucessfull on step6");
	}

	@When("User clicks continue button without selecting last menstrual date")
	public void user_clicks_continue_button_without_selecting_last_menstrual_date() {
		onBrdPage6.clickstep6ContinueButton();
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String expectedError) {
	    String actualError=onBrdPage6.Error_without_mensuraldate();
	    Assert.assertEquals(actualError,expectedError);
	}
	@When("User clicks back button in step {int}")
	public void user_clicks_back_button_in_step(Integer int1) {
		onBrdPage6.click_step6back_button();
	}
	@Then("User should be navigated back to step {string}")
	public void user_should_be_navigated_back_to_step(String expectedError) {
		String actualError=onBrdPage6.verify_step6back_button();
	    Assert.assertEquals(actualError,expectedError);
	}

}
