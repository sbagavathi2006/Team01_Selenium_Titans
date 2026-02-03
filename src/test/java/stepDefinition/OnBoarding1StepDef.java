package stepDefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import context.TestContextSetup;
import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnBoarding1Page;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding1StepDef {
	
	private TestContextSetup testContext;
	
    public OnBoarding1StepDef(TestContextSetup context) {
   	 this.testContext = context;
   }
	@Given("User is on sign up page")
	public void user_is_on_sign_up_page() {
		testContext.signUpPage().clickSignUpButton();
		Assert.assertTrue(testContext.signUpPage().isRegisterButtonDisplayed(),
				"User is not in the auth page.");
	    LoggerLoad.info("Signup Page loaded");
	}

	@When("User clicks register button after entering valid details")
	public void user_clicks_register_button_after_entering_valid_details() {
//		String email = (String) testContext.getScenarioData("EMAIL");
//		String pwd = (String) testContext.getScenarioData("PASSWORD");

		testContext.signUpPage().registerWithValidDynamicData(testContext);
		Assert.assertTrue(testContext.onBrdPage1().isOBPage1TitleDisplayed(),
				"User is not in the onboarding page.");
	    LoggerLoad.info("Onboarding Page loaded");
	}
	
	
	@Then("Title of the page should be Upload Your Recent Blood Work")
	public void title_of_the_page_should_be_Upload_your_recent_blood_work() {
		Assert.assertTrue(testContext.onBrdPage1().isOBPage1TitleDisplayed(),
				"Title 'Upload Your Recent Blood Work' is not displayed");
		LoggerLoad.info("Title of the page 'Upload Your Recent Blood Work Displayed ");
	}
	
	@Then("Step one should have supporting text")
	public void step_one_should_have_supporting_text() {
		Assert.assertTrue(testContext.onBrdPage1().isSupportingTextDisplayed(),
							"Support Text on under title is not displayed");
		LoggerLoad.info("Step1 supporting text displayed ");
	}

	@Then("Onboarding progress bar is displayed")
	public void onboarding_progress_bar_is_displayed() {
		Assert.assertTrue(testContext.onBrdPage1().isOnBoardingProgressDisplayed(),
						"Onboarding progress bar not displayed");
		LoggerLoad.info("Onboarding Progress Bar displayed ");
	}

	@Then("Progress bar shows the current step as one of Ten in number")
	public void progress_bar_shows_the_current_step_as_one_of_ten_in_number() {
		Assert.assertTrue(testContext.onBrdPage1().isProgressBar1_10Displayed(),
						"Step 1/10 not displayed");
		LoggerLoad.info("Onboarding Progress Bar text 1/10 displayed ");
	}

	@Then("Upload PDF button is displayed")
	public void upload_pdf_button_is_displayed() {
		Assert.assertTrue(testContext.onBrdPage1().isUploadBtnDisplayed(),
						"Upload PDF Button not displayed");
		LoggerLoad.info("Upload PDF button is displayed ");
	}

	@Then("Upload PDF button should be enabled")
	public void upload_pdf_button_should_be_enabled() {
		Assert.assertTrue(testContext.onBrdPage1().isUploadBtnEnabled(),
						"Upload PDF button is not enabled");
		LoggerLoad.info("Upload PDF button is enabled ");
	}

	@Then("PDF files only Max Ten MB is visible")
	public void pdf_files_only_max_ten_mb_is_visible() {
		Assert.assertTrue(testContext.onBrdPage1().isMax10MBDisplayed(),
					"PDF file only Max 10MB is not visible");
		LoggerLoad.info("Max 10MB Text is displayed ");
	}

	@Then("Skip for Now card is visible")
	public void skip_for_now_card_is_visible() {
		Assert.assertTrue(testContext.onBrdPage1().getSkipNowCard().isDisplayed(),
						"Skip for Now card is not visible");
		LoggerLoad.info("SkipNow card displayed ");
	}

	@Then("Explanation text about continuing without lab results is displayed")
	public void explanation_text_about_continuing_without_lab_results_is_displayed() {
		Assert.assertTrue(testContext.onBrdPage1().isskipNowTextDisplayed(),
				"Explanation text for skip for now is not displayed");
		LoggerLoad.info("Explanation text for skip for now is displayed ");
	}

	@Then("Continue Without Report button is displayed")
	public void continue_without_report_button_is_displayed() {
		Assert.assertTrue(testContext.onBrdPage1().isContWithOutReportBtnDisplayed(),
				"Continue without report btn is not displayed");
		LoggerLoad.info("Continue without report btn displayed ");
	}

	@Then("Continue without button is enabled")
	public void continue_without_button_is_enabled() {
		Assert.assertTrue(testContext.onBrdPage1().getContWithOutReportBtn().isDisplayed(),
				"Continue without button is not enabled");
		LoggerLoad.info("Continue without report btn enabled ");
	}

	@Then("Note about secure processing and no sharing with third parties is displayed")
	public void note_about_secure_processing_and_no_sharing_with_third_parties_is_displayed() {
		Assert.assertTrue(testContext.onBrdPage1().issecNoteDisplayed(),
				"Security note is not displayed ");
		LoggerLoad.info("Security note displayed ");
	}

}
