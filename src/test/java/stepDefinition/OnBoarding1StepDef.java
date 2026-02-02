package stepDefinition;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnBoarding1Page;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding1StepDef {
	
	private OnBoarding1Page onBrdPage1;
	
	
	  public OnBoarding1StepDef() {
		  onBrdPage1 = new OnBoarding1Page(DriverFactory.getDriver());
	    }

	@Given("User is on sign up page")
	public void user_is_on_sign_up_page() {
		onBrdPage1.clickbtnSignUp();
	    LoggerLoad.info("Signup Page loaded");
	}

	@When("User clicks register button after entering valid details")
	public void user_clicks_register_button_after_entering_valid_details() {
		String randomString = CommonMethods.generateRandomString();
		System.out.println(randomString);
		String email = randomString + "@gmail.com";
		String password = randomString;
		onBrdPage1.clickBtnRegister(email, password);
		LoggerLoad.info("On boarding started for the emailid: " +email);
	}
	
	@Then("Title of the page should be Upload Your Recent Blood Work")
	public void title_of_the_page_should_be_Upload_your_recent_blood_work() {
		onBrdPage1.isOBPage1TitleDisplayed();
		LoggerLoad.info("Title of the page 'Upload Your Recent Blood Work Displayed ");
	}
	
	@Then("Step one should have supporting text")
	public void step_one_should_have_supporting_text() {
		onBrdPage1.isSupportingTextDisplayed();
		LoggerLoad.info("Step1 supporting text displayed ");
	}

	@Then("Onboarding progress bar is displayed")
	public void onboarding_progress_bar_is_displayed() {
		onBrdPage1.isOnBoardingProgressDisplayed();
		LoggerLoad.info("Onboarding Progress Bar displayed ");
	}

	@Then("Progress bar shows the current step as one of Ten in number")
	public void progress_bar_shows_the_current_step_as_one_of_ten_in_number() {
		onBrdPage1.isProgressBar1_10Displayed();
		LoggerLoad.info("Onboarding Progress Bar text 1/10 displayed ");
	}

	@Then("Upload PDF button is displayed")
	public void upload_pdf_button_is_displayed() {
		onBrdPage1.isUploadBtnDisplayed();
		LoggerLoad.info("Upload PDF button is displayed ");
	}

	@Then("Upload PDF button should be enabled")
	public void upload_pdf_button_should_be_enabled() {
		onBrdPage1.isUploadBtnEnabled();
		LoggerLoad.info("Upload PDF button is enabled ");
	}

	@Then("PDF files only Max Ten MB is visible")
	public void pdf_files_only_max_ten_mb_is_visible() {
		onBrdPage1.isMax10MBDisplayed();
		LoggerLoad.info("Max 10MB Text is displayed ");
	}

	@Then("Skip for Now card is visible")
	public void skip_for_now_card_is_visible() {
		onBrdPage1.isSkipNowCardDisplayed();
		LoggerLoad.info("SkipNow card displayed ");
	}

	@Then("Explanation text about continuing without lab results is displayed")
	public void explanation_text_about_continuing_without_lab_results_is_displayed() {
		onBrdPage1.isskipNowTextDisplayed();
		LoggerLoad.info("SkipNow support text displayed ");
	}

	@Then("Continue Without Report button is displayed")
	public void continue_without_report_button_is_displayed() {
		onBrdPage1.isContWithOutReportBtnDisplayed();
		LoggerLoad.info("Continue without report btn displayed ");
	}

	@Then("Continue without button is enabled")
	public void continue_without_button_is_enabled() {
		onBrdPage1.isContWithOutReportBtnEnabled();
		LoggerLoad.info("Continue without report btn enabled ");
	}

	@Then("Note about secure processing and no sharing with third parties is displayed")
	public void note_about_secure_processing_and_no_sharing_with_third_parties_is_displayed() {
		onBrdPage1.issecNoteDisplayed();
		LoggerLoad.info("Security note displayed ");
	}

}
