package stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnBoarding6Page;

import utilities.CommonMethods;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

public class OnBoarding6StepDef {
	private OnBoarding6Page onBrdPage6;
	String beforePhase;
	
	  public OnBoarding6StepDef() {
		  onBrdPage6 = new OnBoarding6Page(DriverFactory.getDriver());
		  
	    }
	
	@Given("User completes onboarding until step {int}")
	public void user_completes_onboarding_until_step(Integer int1) {
		
		onBrdPage6 .onBoarding_step(int1);
		LoggerLoad.info("sucessfull on step 6");
	}

	@When("User clicks continue button without selecting last menstrual date")
	public void user_clicks_continue_button_without_selecting_last_menstrual_date() {
		onBrdPage6 .clickContinueButton();
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
	@When("User clicks continue button after entering invalid value in date")
	public void user_clicks_continue_button_after_entering_invalid_value_in_date() {
		ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/step7_onboarding.xlsx");
	    List<Map<String, String>> step7Data = excel.getDataAll("OnBoardingStep7");
	    for (Map<String, String> row : step7Data) {
	        String date = row.get("InvalidDate");
	        onBrdPage6.passingDate(date);
	    }
		
	}
	@When("User selects last menstrual date")
	public void user_selects_last_menstrual_date() {
		ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/step7_onboarding.xlsx");
	    List<Map<String, String>> step7Data = excel.getDataAll("OnBoardingStep7");
	    for (Map<String, String> row : step7Data) {
	        String date = row.get("validDate");
	        onBrdPage6.passingDate(date);
	    }
		
	}
	@Then("{string} should be displayed")
	public void should_be_displayed(String elementName) {
		Assert.assertTrue(onBrdPage6.verifyUIElements_forStep6(elementName), elementName + " is not displayed");
	}
	@When("User clicks continue after selecting last menstrual date")
	public void user_clicks_continue_after_selecting_last_menstrual_date() {
		ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/step7_onboarding.xlsx");
	    List<Map<String, String>> step7Data = excel.getDataAll("OnBoardingStep7");
	    for (Map<String, String> row : step7Data) {
	        String date = row.get("InvalidDate");
	        onBrdPage6.passingDate(date);
	    }
		onBrdPage6.clickContinueButton();
	}
	@Then("{string} should be displayed for step7")
	public void should_be_displayed_for_step7(String string) {
		Assert.assertTrue(onBrdPage6.verifyStep7Element(string), string + " is not displayed");
	}
	@Then("Current month and next month should be visible")
	public void current_month_and_next_month_should_be_visible() {
		Assert.assertTrue(onBrdPage6.verifyCalenderMonths_step6(),
			    "Current and next month should be visible in Step 6 calendar");
	}
	@When("User changes the date using the upcoming cycle calendar")
	public void user_changes_the_date_using_the_upcoming_cycle_calendar() {
		 beforePhase = onBrdPage6.getPhaseBeforeDateChange();
		    onBrdPage6.changeDateOnCalendar();
	}
	@Then("Phase displayed in the timeline should update accordingly")
	public void phase_displayed_in_the_timeline_should_update_accordingly() {
		 String afterPhase = onBrdPage6.getPhaseAfterDateChange();
		    Assert.assertNotEquals(afterPhase,beforePhase,"Phase did not update after date change" );
	}
	@Then("At least three future expected period dates should be listed")
	public void at_least_three_future_expected_period_dates_should_be_listed() {
		int count = onBrdPage6.getExpectedPeriodDatesCount();
        Assert.assertTrue(
	        count >= 3,
	        "Expected at least 3 future period dates, but found " + count
	    );
	}
	
	}
