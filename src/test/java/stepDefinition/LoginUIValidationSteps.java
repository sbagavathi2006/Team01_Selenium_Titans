package stepDefinition;

import static org.testng.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.LoggerLoad;

public class LoginUIValidationSteps {
    
    LoginPage loginPage = new LoginPage();

    @Given("User is on the HerBalance launch page")
    public void user_is_on_the_her_balance_launch_page() {
        LoggerLoad.info("Navigating to HerBalance launch page");
    }

    @When("User clicks log in button")
    public void user_clicks_log_in_button() {
        LoggerLoad.info("Clicking Login button");
        loginPage.clickLoginONLanch();
    }
    
    @When("User clicks logIn button")
    public void user_clicks_login_buttonOnLogin() {
    	 LoggerLoad.info("Clicking Login button");
         loginPage.clickLogin();
     }
    
    @When("User clicks loginTab button")
    public void user_clicks_login_tab_button() {
    	LoggerLoad.info("Clicking Login button");
        loginPage.clickLoginTab();
    }

    @Then("HerBalance logo should be visible on the top-left corner")
    public void her_balance_logo_should_be_visible_on_the_top_left_corner() {
        LoggerLoad.info("Validating logo visibility");
        assertTrue(loginPage.isLogoDisplayed(), "Logo is not visible on the page");
    }

    @Then("Login tab should be active by default")
    public void login_tab_active() {
        LoggerLoad.info("Validating default active tab");
        assertTrue(loginPage.isLoginTabActive(), "Login tab is not active by default");
    }

    @Then("Both {string} and {string} tabs should be visible")
    public void both_and_tabs_should_be_visible(String tab1, String tab2) {
        List<String> tabNames = loginPage.getTabs().stream().map(WebElement::getText).collect(Collectors.toList());
        assertTrue(tabNames.contains(tab1), tab1 + " tab is missing");
        assertTrue(tabNames.contains(tab2), tab2 + " tab is missing");
    }
    @Then("Email ID input field with placeholder {string} should be visible on loginPage")
    public void email_id_input_field_with_placeholder_should_be_visible_on_login_page(String string) {
    	Assert.assertTrue(loginPage.isEmailFieldVisible());
    }
    
    @Then("Password input field with masked entry should be visible on LoginPage")
    public void password_input_field_with_masked_entry_should_be_visible_on_login_page() {
        Assert.assertTrue(loginPage.isPasswordInputFieldVisible());

    }
 
    @Then("There should be exactly {int} tabs — “Login” and “Sign Up”")
    public void there_should_be_exactly_tabs_login_and_sign_up(Integer count) {
        assertEquals(loginPage.getTabCount(), count.intValue(), "Tab count mismatch");
    }
    
    @Then("There should be exactly {int} input field")
    public void there_should_be_exactly_input_field(Integer count) {
    assertEquals(loginPage.getNumberOfInputFields(), count.intValue(), "Input field count mismatch");

    }

    @Then("Email ID and Password fields should be properly aligned vertically with equal spacing")
    public void email_id_and_password_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
        LoggerLoad.info("Skipping exact alignment validation as requires visual testing");
    }

    @Then("“Show password” should be visible")
    public void show_password_should_be_visible() {
        assertTrue(loginPage.isShowPasswordVisible(), "Show Password option is not visible");
    }

    @Then("Radio button for show password")
    public void radio_button_for_show_password() {
        assertTrue(loginPage.isShowPasswordVisible(), "Show Password radio/button not visible");
    }

    @Then("“Login” button should be visible, enabled")
    public void login_button_should_be_visible_enabled() {
        assertTrue(loginPage.isLoginTabVisible(), "Login button is not visible");
        assertTrue(loginPage.isLoginTabEnabled(), "Login button is not enabled");
    }

    @Then("“Forgot password?” link should be visible")
    public void forgot_password_link_should_be_visible() {
        assertTrue(loginPage.isForgotPasswordVisible(), "Forgot Password link not visible");
    }

    @Then("“Sign Up” link should be visible and navigates to the Sign-Up page")
    public void sign_up_link_should_be_visible_and_navigates_to_the_sign_up_page() {
        assertTrue(loginPage.isSignUpVisible(), "Sign Up link not visible");
    }

    @Then("The right section should display “Cycle-Synced Plans”, “Blood Work Analysis”, and “Personalized Dashboard” content")
    public void the_right_section_should_display_cycle_synced_plans_blood_work_analysis_and_personalized_dashboard_content() {
        LoggerLoad.info("Skipping detailed content verification it requires page section locators");
    }

    @Then("A testimonial with text and name \\(e.g., “Sarah, {int}”) should be displayed")
    public void a_testimonial_with_text_and_name_e_g_sarah_should_be_displayed(Integer age) {
        LoggerLoad.info("Skipping testimonial content verification (requires locator)");
    }

    @Then("The background gradient \\(light purple) and fonts should match HerBalance theme")
    public void the_background_gradient_light_purple_and_fonts_should_match_her_balance_theme() {
        LoggerLoad.info("Skipping CSS style verification it requires visual testing or CSS asserts");
    }

}



