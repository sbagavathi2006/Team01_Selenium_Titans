package stepDefinition;

import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.WeightTrackPage;

import java.util.List;

public class WeightTrackStepDefinition {

    private static Logger logger = LogManager.getLogger();
    private WeightTrackPage weightTrackPage;

    public WeightTrackStepDefinition(){
        weightTrackPage = new WeightTrackPage(DriverFactory.getDriver());
    }

    private List<String> afterList;
    String newWeightValueToAdd;

    @Given("User is on Her balance Home page after successful login")
    public void user_is_on_her_balance_home_page_after_successful_login() {
        weightTrackPage.loginToPortal();
        logger.info("Login successful, user is on Her Balance Home page");
    }

    @Given("User is on Her balance Home page")
    public void user_is_on_her_balance_home_page() {
        weightTrackPage.loginToPortal();
        logger.info("Login successful, user is on Her Balance Home page");
    }


    @When("User is on Activity Insights tab - Weight Tracking page after successful login")
    public void user_is_on_activity_insights_tab_weight_tracking_page_after_successful_login() throws InterruptedException {
        weightTrackPage.activityInsightToBeClickable();
        weightTrackPage.navigateToActivityInsight();
        weightTrackPage.clickWeightTrackingBtn();
        logger.info("Login successful, user is on Weight track page");
    }

    @Then("Header text {string} should be displayed")
    public void header_text_should_be_displayed(String headerText) {
        String expectedHeader = headerText;
        String actualHeader = weightTrackPage.getHeaderText();
        Assert.assertEquals(actualHeader, expectedHeader, "actualHeader text is not matching with expectedHeader");
        logger.info("Headertext Verified Successfully: " + actualHeader);

    }

    @Then("Subtitle text {string} should be displayed")
    public void subtitle_text_should_be_displayed(String string) {
        String expectedSubtitle = string;
        String actualSubtitle = weightTrackPage.getSubText();
        Assert.assertEquals(actualSubtitle, expectedSubtitle, "actualSubtitle text is not matching with expectedSubtitle");
        logger.info("Subtitle text Verified Successfully: " + actualSubtitle);

    }

    @Then("Back to Dashboard button is be displayed")
    public void back_to_dashboard_button_is_be_displayed() {
        weightTrackPage.checkBackToDdBtn();
        logger.info("Subtitle text Verified Successfully: ");
    }

    @Then("The mentioned {string} for Weight info should be displayed")
    public void the_mentioned_for_weight_info_should_be_displayed(String cardName) {
        List<String> actualcards = weightTrackPage.getCardText(cardName);
        Assert.assertEquals(actualcards.size(), 3, "Expected 3 cards are displayed");
        Assert.assertTrue(actualcards.get(0).contains("Starting Weight"),  "Starting Weight card name is not matching");
        Assert.assertTrue(actualcards.get(1).contains("Current Weight") , "Current Weight card name is not matching");
        Assert.assertTrue(actualcards.get(2).contains("Goal Weight") , "Goal Weight card name is not matching");
        logger.info("Card names are verified and matched successfully " );
    }

    @Then("Starting Weight value should be mapped from the onboarding process")
    public void starting_weight_value_should_be_mapped_from_the_onboarding_process() {


    }

    @Then("Current Weight and starting weight value should be same value for new user")
    public void current_weight_and_starting_weight_value_should_be_same_value_for_new_user() {
        weightTrackPage.verifyCurrentWeight();
        if(weightTrackPage.getLatestLogWeight()== null){
            //new user
            Assert.assertEquals(weightTrackPage.verifyCurrentWeight(), weightTrackPage.verifyStartWeight(), "New user current and starting weight are not same");
            logger.info("As user is new, Current weight and Starting weight values are same");
        }
        //existing user
        else{
            Assert.assertEquals(weightTrackPage.verifyCurrentWeight(), weightTrackPage.getLatestLogWeight(), "Existing user current weight and latest log weight are not same");
            logger.info("Existing user current weight and latest log weight are same");

        }
    }

    @Then("according to the recent weight log, Weight value should be mapped")
    public void according_to_the_recent_weight_log_weight_value_should_be_mapped() {


    }


    @Then("Goal weight option should be displayed")
    public void goal_weight_option_should_be_displayed() {
        Assert.assertTrue(weightTrackPage.getGoalWeight().contains("Goal Weight"), "Goal weight text is not displayed");
        logger.info("Goal weight text is verified successfully");

    }

    @Then("Header should be displayed as {string} text")
    public void header_should_be_displayed_as_text(String string) {
        Assert.assertTrue(weightTrackPage.getProgressOverview().contains("Progress Overview"), "Progress Overview section is not displayed");
        logger.info("Progress OverView Section is verified");

    }

    @Then("Subtext {string} text should be displayed")
    public void subtext_text_should_be_displayed(String string) {
        Assert.assertTrue(weightTrackPage.getWeightLossProgrees(), "Weight Loss Progress bar is not displayed");
        logger.info("Verified Weight Loss progress bar");

    }

    @Then("Completion percentage should be displayed in percentage format")
    public void completion_percentage_should_be_displayed_in_percentage_format() {
        boolean isDisplayedInFormat = weightTrackPage.getCompletionPercentage();
        Assert.assertTrue( isDisplayedInFormat, "Completion percentage is not displayed");
        logger.info("Verified Completion percentage display");
    }

    @Then("Weight lost value should be displayed")
    public void weight_lost_value_should_be_displayed() {
        Assert.assertTrue(weightTrackPage.getWeightLostField(), "Weight lost field is not displayed");
        logger.info("Verified Weight lost field display");

    }

    @Then("Remaining weight value should be displayed")
    public void remaining_weight_value_should_be_displayed() {
        Assert.assertTrue(weightTrackPage.getRemainingWeightField(), "Remaining weight field is not displayed");
        logger.info("Verified Remaining weight field display");
    }

    @Then("Graph section header {string} should be displayed")
    public void graph_section_header_should_be_displayed(String string) {
        Assert.assertTrue(weightTrackPage.getGraphSectionHeader(), "Graph section header 'Weight Progress' is not displayed");
        logger.info("Graph section header 'Weight Progress' is verified successfully");

    }

    @Then("Graph should be visible with x axis {string} showing days")
    public void graph_should_be_visible_with_x_axis_showing_days(String values) {
        String expectedDay = values;
        String actualDayValue = weightTrackPage.getxAxisValues(values);
        Assert.assertEquals(actualDayValue, expectedDay, "The X-axis element for "+ expectedDay +" was not found.");
        logger.info("X-axis label 'Days' is verified successfully");
    }

    @Then("Y-axis should display weight values in Weight kg")
    public void y_axis_should_display_weight_values_in_weight_kg() {
        boolean isLabelVisible = weightTrackPage.getyaxislabel();
        Assert.assertTrue(isLabelVisible, "The Y-axis label 'Weight (kg)' was not displayed on the graph.");
        logger.info("Successfully verified Y-axis label display.");

    }

    @Then("mentioned {string} and {string} should be displayed")
    public void mentioned_and_should_be_displayed(String input, String inputField) {
        boolean isVisible = weightTrackPage.getLogSectionFields(input, inputField);
        Assert.assertTrue(isVisible, "The label for '" + inputField + "' was not displayed.");
        logger.info("Verified that " + inputField + " is displayed correctly.");
    }

    @Then("Section should indicate the current tracking day at the left log todays weight section")
    public void section_should_indicate_the_current_tracking_day_at_the_left_log_todays_weight_section() {
        Assert.assertTrue(weightTrackPage.getCurrentTrackingDate(), "Current tracking day is not displayed");
        logger.info("Current tracking day is displayed successfully");
    }

    @Then("{string} button should be disabled")
    public void button_should_be_disabled(String string) {
        Assert.assertFalse(weightTrackPage.getLogWeightBtn(), "Log Weight button is not disabled");
        logger.info("Log Weight button is disabled as expected");

    }

    @When("User enters valid value in weight as {string} in Log Today's weight section")
    public void user_enters_valid_value_in_weight_as_in_log_today_s_weight_section(String value) throws InterruptedException {
        weightTrackPage.navigateToActivityInsight();
        weightTrackPage.enterWeightValue(value);
        logger.info("Entered valid weight value in Log Today's weight section: " + value);
    }

    @Then("{string} field should auto-calculated based on the entered weight value")
    public void field_should_auto_calculated_based_on_the_entered_weight_value(String string) {
        String bmi = weightTrackPage.getBMIValue();
        Assert.assertNotNull(bmi, "BMI value is not calculated");
        logger.info("BMI value is auto-calculated successfully: " + bmi);
    }

    @When("User enters weight\\(kg) as {string} in Log Todays weight section")
    public void user_enters_weight_kg_as_in_log_todays_weight_section(String weightValue) {
        weightTrackPage.enterWeightValue(weightValue);
        logger.info("Entered valid weight value in Log Today's weight section: " + weightValue);
    }

    @Then("Log Weight button should be Enabled")
    public void log_weight_button_should_be_enabled() {
        Assert.assertTrue(weightTrackPage.getLogWeightBtnStatus(), "Log Weight button is disabled");
        logger.info("Log Weight button is enabled as expected");
    }

    @When("User clicks Log Weight button after entering Weight value")
    public void user_clicks_log_weight_button_after_entering_weight_value() {
        weightTrackPage.enterWeightValue("70");
        weightTrackPage.clickLogWeightButton();
         logger.info("Clicked Log Weight button after entering weight value: ");
    }

    @Then("{string} graph should plot the new value for that day")
    public void graph_should_plot_the_new_value_for_that_day(String weightValue) {
        String beforeD = weightTrackPage.getGraphDValue();
        weightTrackPage.enterWeightValue(weightValue);
        weightTrackPage.clickLogWeightButton();
        String afterD = weightTrackPage.getGraphDValue();
        Assert.assertNotEquals(afterD, beforeD, "Graph did not update after logging new weight");
        logger.info("Graph updated successfully after logging new weight");
    }

    @When("User navigates to the Activity Insights tab - Weight Tracking page")
    public void user_navigates_to_the_activity_insights_tab_weight_tracking_page() throws InterruptedException{
        weightTrackPage.activityInsightToBeClickable();
        weightTrackPage.navigateToActivityInsight();
        weightTrackPage.clickWeightTrackingBtn();
        logger.info("Login successful, user is on Weight track page");
    }

    @Given("User is on Activity Insights tab - Weight Tracking page")
    public void user_is_on_activity_insights_tab_weight_tracking_page() throws InterruptedException {
        weightTrackPage.loginToPortal();
        logger.info("Login successful, user is on Her Balance Home page");
        weightTrackPage.activityInsightToBeClickable();
        weightTrackPage.navigateToActivityInsight();
        weightTrackPage.clickWeightTrackingBtn();
        logger.info("Login successful, user is on Weight track page");
    }

   @When("User enter invalid value in weight {string} in log today's weight section")
    public void user_enter_invalid_value_in_weight_in_log_today_s_weight_section(String negativeValue) {
        weightTrackPage.enterWeightValue(negativeValue);
        weightTrackPage.clickLogWeightButton();
        logger.info("User entered invalid weight value and clicked log Weight button");

    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        Assert.assertTrue(weightTrackPage.verifyErrorMessage(), "Error message not displayed for invalid weight input");
        logger.info("Error message displayed successfully for invalid weight input");
    }

}
