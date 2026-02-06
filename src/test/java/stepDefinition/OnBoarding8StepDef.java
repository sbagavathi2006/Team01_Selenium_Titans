package stepDefinition;
import org.testng.Assert;
import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnBoarding6Page;
import pageObjects.OnBoarding8Page;

public class OnBoarding8StepDef {
	private OnBoarding8Page onBrdPage8;
	private OnBoarding6Page onBrdPage6;
   

	public OnBoarding8StepDef() {
		onBrdPage8 = new OnBoarding8Page(DriverFactory.getDriver());
		onBrdPage6 = new OnBoarding6Page(DriverFactory.getDriver());
	}
	
	@When("User selects {string} dietary option")
	public void user_selects_dietary_option(String dietOption) {
		onBrdPage8.selectDietOption(dietOption);
	}
	@Then("Continue button should be enabled in Step 8")
	public void continue_button_should_be_enabled_in_step_8() {
	    Assert.assertTrue(
	        onBrdPage8.isContinueButtonEnabled(),
	        "Continue button is not enabled after selecting dietary option in Step 8"
	    );
	    
	}
	@When("User clicks the Back button in Step {int}")
	public void user_clicks_the_back_button_in_step(Integer int1) {
		onBrdPage6.clickBackbutton();
	}
	@Then("User should be redirected to Step {string}")
	public void user_should_be_redirected_to_step(String string) {
		onBrdPage8.verify_step8back_button();
	}
	@When("User clicks continue after selecting any dietary options")
	public void user_clicks_continue_after_selecting_any_dietary_options() {
		onBrdPage8.selectPescatarianDietDietOption();
		onBrdPage6.clickContinueButton();
	}
	@Then("Step9 {string} should be displayed")
	public void step_should_be_displayed(String string) {
		Assert.assertTrue(onBrdPage8.verifyUIElements_forStep9(string), string + " is not displayed");

	}


}
