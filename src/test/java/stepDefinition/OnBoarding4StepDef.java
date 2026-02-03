package stepDefinition;

import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class OnBoarding4StepDef {
	
	private TestContextSetup testContext;
	
    public OnBoarding4StepDef(TestContextSetup context) {
   	 this.testContext = context;
   }
	
	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() throws InterruptedException {
		Thread.sleep(2000);
		testContext.onBrdPage1().isOBPage1TitleDisplayed();		
	}

	@When("User clicks continue without report")
	public void user_clicks_continue_without_report() throws InterruptedException {
		Thread.sleep(5000);
	    testContext.onBrdPage1().clickContWithOutRt();

	}

	@Then("Progress bar shows the current step as Three of Eleven")
	public void progress_bar_shows_the_current_step_as_three_of_eleven() throws InterruptedException{
		Thread.sleep(5000);

		testContext.onBrdPage4().isProgressBar3_10Displayed();
		Thread.sleep(1000);
	}

	@Then("Back button is displayed")
	public void back_button_is_displayed() {
	   
	}

	@Then("Back button should be enabled")
	public void back_button_should_be_enabled() {
	    
	}

	@Then("Continue button should be visible")
	public void continue_button_should_be_visible() {
	    
	}

	@Then("Continue button should be enabled")
	public void continue_button_should_be_enabled() {
	   
	}

	@Then("Header should be {string}")
	public void header_should_be(String string) {
	    
	}

	@Then("{string} should be displayed")
	public void should_be_displayed(String string) {
	   
	}

	@Then("Nine radio button should be visible")
	public void nine_radio_button_should_be_visible() {
	    
	}

	@Then("<healthCondition> should be visible")
	public void health_condition_should_be_visible() {
	    
	}

	@Then("Note text should displayed")
	public void note_text_should_displayed() {
	  
	}

}
