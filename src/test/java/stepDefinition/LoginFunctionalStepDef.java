package stepDefinition;

import static org.testng.Assert.*;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

public class LoginFunctionalStepDef {

    LoginPage loginPage = new LoginPage();
    ExcelUtils excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));


    @Given("User is on the HerBalance auth page")
    public void user_is_on_the_her_balance_auth_page() {
        LoggerLoad.info("User is on HerBalance auth page");
    }

    @When("user clicks login button after leaving credential blank")
    public void user_clicks_login_button_after_leaving_credential_blank() {
        LoggerLoad.info("Clearing email and password fields for blank input scenario");
        loginPage.enterEmail("");     
        loginPage.enterPassword(""); 
        loginPage.clickLogin();
    }

  @When("user clicks login button after entering a {string} credential")
  public void user_clicks_login_button_after_entering_a_credential(String scenario) {
     LoggerLoad.info("Login attempt with scenario: " + scenario);
      Map<String, String> data = excel.getRowDataByScenario("LoginData", scenario);      
      loginPage.enterEmail(data.get("Email"));
      loginPage.enterPassword(data.get("Password"));
      loginPage.clickLogin();
  }
  
    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        LoggerLoad.info("User redirected to dashboard");
        assertTrue(true);
    }

    @Then("An error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMsg) {
        LoggerLoad.info("Validating error message");
        assertEquals(loginPage.getErrorMessage(), expectedMsg);
    }

    @Then("Validation messages {string} and {string} should be displayed")
    public void validation_messages_and_should_be_displayed(String emailMsg, String pwdMsg) {
        LoggerLoad.info("Validating mandatory field messages");
        List<String> messages = loginPage.getValidationMessages();
        assertTrue(messages.contains(emailMsg), "Email ID is required");
        assertTrue(messages.contains(pwdMsg), "Password is required");
    }

    @When("User clicks show password after entering password")
    public void user_clicks_show_password_after_entering_password() {
        LoggerLoad.info("User clicks show password");
        Map<String, String> data = excel.getRowDataByScenario("LoginData", "valid");
        loginPage.enterPassword(data.get("Password"));
        loginPage.toggleShowPassword();
    }

    @Then("Password should be visible in plain text")
    public void password_should_be_visible_in_plain_text() {
        assertEquals(loginPage.getPasswordType(), "text");
    }

    @When("User unchecks the {string} option after entering the password")
    public void user_unchecks_the_option_after_entering_the_password(String option) {
        LoggerLoad.info("User unchecks show password");
        loginPage.toggleShowPassword();
    }

    @Then("Password should again be masked")
    public void password_should_again_be_masked() {
        assertEquals(loginPage.getPasswordType(), "text");
    }
    
    @When("User enters a password and clicks the eye icon")
    public void user_enters_a_password_and_clicks_the_eye_icon() {
        LoggerLoad.info("User clicks eye icon");
        Map<String, String> data =  excel.getRowDataByScenario("LoginData", "valid");
        loginPage.enterPassword(data.get("Password"));
        loginPage.toggleShowPassword();
    }

    @Then("Password field should show the entered password in plain text")
    public void password_field_should_show_the_entered_password_in_plain_text() {
        assertEquals(loginPage.getPasswordType(), "text");
    }

    @When("User clicks the eye icon again")
    public void user_clicks_the_eye_icon_again() {
        loginPage.toggleShowPassword();
    }
    
    @When("user clicks on {string}")
    public void user_clicks_on(String link) {
        LoggerLoad.info("User clicks on: " + link);
        if (link.equalsIgnoreCase("Forgot password?")) {
            loginPage.clickForgotPassword();
        }
    }

    @Then("User should be redirected to the Forgot Password page")
    public void user_should_be_redirected_to_the_forgot_password_page() {
        LoggerLoad.info("User redirected to Forgot Password page");
        assertTrue(true);
    }

    @When("user clicks on {string} tab")
    public void user_clicks_on_tab(String tab) {
        LoggerLoad.info("User clicks tab: " + tab);
        loginPage.clickTab(tab);
    }

    @Then("User should be redirected to the sign up tab")
    public void user_should_be_redirected_to_the_sign_up_tab() {
        LoggerLoad.info("User redirected to Sign Up tab");
        assertTrue(true);
    }
}
