package stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnBoarding6Page;
import pageObjects.OnBoarding7Page;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

public class OnBoarding7StepDef {
	
	private OnBoarding7Page onBrdPage7;
	private OnBoarding6Page onBrdPage6;
	
	  public OnBoarding7StepDef() {
		  onBrdPage7 = new OnBoarding7Page(DriverFactory.getDriver());
		  onBrdPage6 = new OnBoarding6Page(DriverFactory.getDriver());
	    }		
	
	@When("User clicks weight\\(kg) dropdown")
	public void user_clicks_weight_kg_dropdown() {
		onBrdPage7.clickdropDown();
	}
	@Then("Options {string} and {string} should be displayed for weight")
	public void options_and_should_be_displayed_for_weight(String string, String string2) {
		Assert.assertTrue(onBrdPage7.verifyWeightdropDown(),"Weight unit options are not displayed" ); 
	}
	@When("User clicks height\\(cm) dropdown")
	public void user_clicks_height_cm_dropdown() {
		onBrdPage7.clickdropDown();
	    
	}
	@Then("Options {string} and {string} should be displayed for height")
	public void options_and_should_be_displayed_for_height(String string, String string2) {
		Assert.assertTrue(onBrdPage7.verifyHeightdropDown(),"Weight unit options are not displayed" ); 
	}
	@When("User clicks continue button without entering current weight")
	public void user_clicks_continue_button_without_entering_current_weight() {
		onBrdPage7.clickStep7ContinueButton();
	}
	@Then("Error message {string} should be displayed for weightfield")
	public void error_message_should_be_displayed_for_weightfield(String string) {
		Assert.assertEquals(onBrdPage7.errorForWeight(),string );
	}
	@When("User clicks continue button without entering height")
	public void user_clicks_continue_button_without_entering_height() {
		onBrdPage7.clickStep7ContinueButton();
	}
	@Then("Error message {string} should be displayed for heightfield")
	public void error_message_should_be_displayed_for_heightfield(String string) {
		Assert.assertEquals(onBrdPage7.errorForHeight(),string );
	}
	@When("User clicks continue button after entering invalid weight")
	public void user_clicks_continue_button_after_entering_invalid_weight() {
		ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/step7_onboarding.xlsx");
	    List<Map<String, String>> step7Data = excel.getDataAll("OnBoardingStep7");

	   

	    for (Map<String, String> row : step7Data) {
	        String weight = row.get("Invalidweight");
	        String height = row.get("validheight");
	        onBrdPage7.enterInputValues(weight, height);
	    }

	}
	@Then("Error message {string} should be displayed for invalid heightfield")
	public void error_message_should_be_displayed_for_invalid_heightfield(String string) {
		String actualError=onBrdPage7.errorForInvalidHeight();
		Assert.assertTrue(actualError.contains(string), 
                "Weight error message is not as expected. Actual: " + actualError);
	}
	
	@Then("Error message {string} should be displayed for invalid weightfield")
	public void error_message_should_be_displayed_for_invalid_weightfield(String string) {
		String actualError=onBrdPage7.errorForInvalidWeight();
		Assert.assertTrue(actualError.contains(string), 
                "Weight error message is not as expected. Actual: " + actualError);
	}
	
	
	@When("User clicks continue button after entering invalid height")
	public void user_clicks_continue_button_after_entering_invalid_height() {
		ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/step7_onboarding.xlsx");
	    List<Map<String, String>> step7Data = excel.getDataAll("OnBoardingStep7");

	    for (Map<String, String> row : step7Data) {
	    	String weight = row.get("validweight");
	        String height = row.get("Invalidheight");
	        onBrdPage7.enterInputValues(weight, height);
	    }
	}
	@Then("User should be redirected to Step {int}")
	public void user_should_be_redirected_to_step(Integer int1) {
		onBrdPage6.verify_step7back_button();
	}
	@When("User clicks continue after entering valid weight and height")
	public void user_clicks_continue_after_entering_valid_weight_and_height() {
		ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/step7_onboarding.xlsx");
	    List<Map<String, String>> step7Data = excel.getDataAll("OnBoardingStep7");
	    for (Map<String, String> row : step7Data) {
	        String weight = row.get("validweight");
	        String height = row.get("validheight");
	        onBrdPage7.enterInputValues(weight, height);
	    }

	}
	@Then("Step8 {string} should be displayed")
	public void step_should_be_displayed( String string) {
		Assert.assertTrue(onBrdPage7.verifyStep8Element(string), string + " is not displayed");
	    
	}
}
