package stepDefinition;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.WeightTrackFieldPage;

public class WeightTrackFieldStepDefinition {

    private static Logger logger = LogManager.getLogger();
    private WeightTrackFieldPage weightTrackFieldPage;

    public WeightTrackFieldStepDefinition() {
        weightTrackFieldPage = new WeightTrackFieldPage(DriverFactory.getDriver());
    }
    //Background


    @Given("User is on Her balance Home page after successful login")
    public void user_is_on_her_balance_home_page_after_successful_login() {
        weightTrackFieldPage.loginToPortal();
         logger.info("Login successful, user is on Her Balance Home page");
    }

    @When("User navigates to the Activity Insights tab - Weight Tracking page")
    public void user_navigates_to_the_activity_insights_tab_weight_tracking_page() throws InterruptedException {
        weightTrackFieldPage.navigateToActivityInsight();
        logger.info("Navigated to Activity Insights tab - Weight Tracking page");
    }

    @Then("Header text {string} should be displayed")
    public void header_text_should_be_displayed(String headerText) {
        String expectedHeader = headerText;
        String actualHeader = weightTrackFieldPage.getHeaderText();
        Assert.assertEquals(actualHeader, expectedHeader, "actualHeader text is not matching with expectedHeader");
        logger.info("Headertext Verified Successfully: " + actualHeader);

    }


    @Then("Subtitle text {string} should be displayed")
    public void subtitle_text_should_be_displayed(String string) {
        String expectedSubtitle = string;
        String actualSubtitle = weightTrackFieldPage.getSubText();
        Assert.assertEquals(actualSubtitle, expectedSubtitle, "actualSubtitle text is not matching with expectedSubtitle");
        logger.info("Subtitle text Verified Successfully: " + actualSubtitle);

    }

    @Then("Back to Dashboard button is be displayed")
    public void back_to_dashboard_button_is_be_displayed() {
        weightTrackFieldPage.checkBackToDdBtn();
        logger.info("Subtitle text Verified Successfully: ");
    }

    @Then("The mentioned {string} for Weight info should be displayed")
    public void the_mentioned_for_weight_info_should_be_displayed(String string) {


    }

    @Then("Labels and weight values should be aligned correctly")
    public void labels_and_weight_values_should_be_aligned_correctly() {


    }

    @Then("Starting Weight value should be mapped from the onboarding process")
    public void starting_weight_value_should_be_mapped_from_the_onboarding_process() {


    }

    @Then("Current Weight and starting weight value should be same value for new user")
    public void current_weight_and_starting_weight_value_should_be_same_value_for_new_user() {

    }

    @Then("according to the recent weight log, Weight value should be mapped")
    public void according_to_the_recent_weight_log_weight_value_should_be_mapped() {

    }

    @Then("Goal weight option should be displayed")
    public void goal_weight_option_should_be_displayed() {

    }

    @Then("Header should be displayed as {string} text")
    public void header_should_be_displayed_as_text(String string) {

    }

    @Then("Subtext {string} text should be displayed")
    public void subtext_text_should_be_displayed(String string) {

    }

    @Then("Completion percentage should be displayed in percentage format")
    public void completion_percentage_should_be_displayed_in_percentage_format() {

    }

    @Then("Weight lost value should be displayed")
    public void weight_lost_value_should_be_displayed() {

    }

    @Then("Remaining weight value should be displayed")
    public void remaining_weight_value_should_be_displayed() {

    }

    @Then("Graph section header {string} should be displayed")
    public void graph_section_header_should_be_displayed(String string) {

    }

    @Then("Graph should be visible with x axis {string} showing days")
    public void graph_should_be_visible_with_x_axis_showing_days(String string) {

    }

    @Then("Y-axis should display weight values in {string}")
    public void y_axis_should_display_weight_values_in(String string) {

    }

    @Then("{string} section sshould be displayed")
    public void section_sshould_be_displayed(String string) {

    }

    @Then("mentioned {string} should be displayed")
    public void mentioned_should_be_displayed(String string) {

    }

    @Then("Section should indicate the current tracking day at the left log todays weight section")
    public void section_should_indicate_the_current_tracking_day_at_the_left_log_todays_weight_section() {

    }

    @Then("{string} button should be disabled")
    public void button_should_be_disabled(String string) {

    }

    @When("User enters valid value in weight as {string} in Log Today's weight section")
    public void user_enters_valid_value_in_weight_as_in_log_today_s_weight_section(String string) {

    }

    @Then("{string} field should auto-calculated based on the entered weight value")
    public void field_should_auto_calculated_based_on_the_entered_weight_value(String string) {

    }
}
