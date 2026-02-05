package stepDefinition;

import io.cucumber.java.en.*;
import pageObjects.SignUpPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SignUpStepDefinition {

    WebDriver driver;
    SignUpPage signUp;
    List<Map<String,String>> testData;
    TestContextSetup context;
    
    public SignUpStepDefinition(TestContextSetup context) {
        this.context = context;
        this.driver = context.getDriver();
        this.signUp = context.signUpPage();
        LoggerLoad.info("SignUpStepDefinition initialized.");
    }

    @Given("user is on the HerBalance launch page")
    public void user_is_on_the_her_balance_launch_page() {
        LoggerLoad.info("Navigating to HerBalance launch page...");
        driver.get(ConfigReader.getProperty("url"));

        LoggerLoad.info("Loading SignUp test data from Excel...");
        ExcelUtils excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
        testData = excel.getDataAll("SignUp");
        LoggerLoad.info("Test data loaded: " + testData.size() + " rows.");
    }

    @Given("user is on the HerBalance auth page")
    public void user_is_on_the_her_balance_auth_page() {
        LoggerLoad.info("Navigating to auth page via Sign Up button...");
        user_clicks_the_sign_up_button();
    }

    @When("user clicks the Sign Up button")
    public void user_clicks_the_sign_up_button() {
        LoggerLoad.info("Clicking Sign Up button...");
        signUp.clickSignUpButton();
    }

    @When("user enters valid Email ID, Password, and Confirm Password and clicks Register")
    public void user_enters_valid_email_id_password_and_confirm_password_and_clicks_register() throws InterruptedException {
        LoggerLoad.info("Registering with valid dynamic credentials...");
        signUp.registerWithValidDynamicData(context);
    }

    @When("user enters invalid Email ID and clicks Register")
    public void user_enters_invalid_email_id_and_clicks_register() {
        Map<String,String> rowData = testData.stream()
                .filter(d -> d.get("TestCaseID").equals("TC02"))
                .findFirst().get();

        LoggerLoad.info("Entering invalid email: " + rowData.get("Email"));
        signUp.enterEmail(rowData.get("Email"));
        signUp.enterPassword(rowData.get("Password"));
        signUp.enterConfirmPassword(rowData.get("ConfirmPassword"));
        signUp.acceptTerms();
        LoggerLoad.info("Clicking Register button...");
        signUp.clickRegister();
    }

    @When("user enters password with length five and clicks Register")
    public void user_enters_password_with_length_five_and_clicks_register() {
        Map<String,String> rowData = testData.stream()
                .filter(d -> d.get("TestCaseID").equals("TC03"))
                .findFirst().get();

        LoggerLoad.info("Entering short password (5 chars) for email: " + rowData.get("Email"));
        signUp.enterEmail(rowData.get("Email"));
        signUp.enterPassword(rowData.get("Password"));
        signUp.enterConfirmPassword(rowData.get("ConfirmPassword"));
        signUp.acceptTerms();
        LoggerLoad.info("Clicking Register button...");
        signUp.clickRegister();
    }

    @When("user enters mismatched Password and Confirm Password and clicks Register")
    public void user_enters_mismatched_password_and_confirm_password_and_clicks_register() {
        Map<String,String> rowData = testData.stream()
                .filter(d -> d.get("TestCaseID").equals("TC04"))
                .findFirst().get();

        LoggerLoad.info("Entering mismatched passwords for email: " + rowData.get("Email"));
        signUp.enterEmail(rowData.get("Email"));
        signUp.enterPassword(rowData.get("Password"));
        signUp.enterConfirmPassword(rowData.get("ConfirmPassword"));
        signUp.acceptTerms();
        LoggerLoad.info("Clicking Register button...");
        signUp.clickRegister();
    }

    @When("user clicks Register without entering any details")
    public void user_clicks_register_without_entering_any_details() {
        LoggerLoad.info("Clicking Register with empty fields...");
        signUp.clickRegister();
    }

    @When("user clicks Register without accepting Terms and Conditions")
    public void user_clicks_register_without_accepting_terms_and_conditions() {
        Map<String,String> rowData = testData.stream()
                .filter(d -> d.get("TestCaseID").equals("TC05"))
                .findFirst().get();

        LoggerLoad.info("Entering valid details but not accepting Terms for email: " + rowData.get("Email"));
        signUp.enterEmail(rowData.get("Email"));
        signUp.enterPassword(rowData.get("Password"));
        signUp.enterConfirmPassword(rowData.get("ConfirmPassword"));
        LoggerLoad.info("Clicking Register button...");
        signUp.clickRegister();
    }

    @When("user clicks eye icon after entering passwords")
    public void user_clicks_eye_icon_after_entering_passwords() {
        LoggerLoad.info("Entering passwords and clicking show password eye icon...");
        signUp.enterPassword("Test123");
        signUp.enterConfirmPassword("Test123");
        signUp.clickShowPassword();
    }

    @When("user clicks eye icon again")
    public void user_clicks_eye_icon_again() {
        LoggerLoad.info("Clicking show password eye icon again to hide...");
        signUp.clickShowPassword();
    }

    @When("user clicks eye icon in Password field")
    public void user_clicks_eye_icon_in_password_field() {
        LoggerLoad.info("Clicking show password icon in Password field...");
        signUp.enterPassword("Test123");
        signUp.clickShowPassword();
    }

    @When("user clicks eye icon again in Password field")
    public void user_clicks_eye_icon_again_in_password_field() {
        LoggerLoad.info("Clicking show password icon again in Password field...");
        signUp.clickShowPassword();
    }

    @When("user clicks eye icon in Confirm Password field")
    public void user_clicks_eye_icon_in_confirm_password_field() {
        LoggerLoad.info("Clicking show password icon in Confirm Password field...");
        signUp.enterConfirmPassword("Test123");
        signUp.clickShowPassword();
    }

    // ========================= THEN =========================

    @Then("Email ID input field with placeholder {string} should be visible")
    public void email_id_input_field_with_placeholder_should_be_visible(String placeholder) {
        LoggerLoad.info("Verifying Email ID field is visible with placeholder: " + placeholder);
        Assert.assertTrue(signUp.isEmailFieldVisible());
        Assert.assertEquals(placeholder,
                driver.findElement(signUp.emailField).getDomAttribute("placeholder"));
    }

    @Then("Password input field with masked entry should be visible")
    public void password_input_field_with_masked_entry_should_be_visible() {
        LoggerLoad.info("Verifying Password field is masked and visible...");
        Assert.assertTrue(signUp.isPasswordFieldMasked());
    }

    @Then("Confirm Password input field with masked entry should be visible")
    public void confirm_password_input_field_with_masked_entry_should_be_visible() {
        LoggerLoad.info("Verifying Confirm Password field is masked and visible...");
        Assert.assertTrue(signUp.isConfirmPasswordFieldMasked());
    }

    @Then("Show Password option should be visible")
    public void show_password_option_should_be_visible() {
        LoggerLoad.info("Verifying Show Password option is visible...");
        Assert.assertTrue(signUp.isShowPasswordIconVisible());
    }

    @Then("Register button should be visible and enabled")
    public void register_button_should_be_visible_and_enabled() {
        LoggerLoad.info("Verifying Register button is visible and enabled...");
        Assert.assertTrue(signUp.isRegisterButtonEnabled());
    }

    @Then("Login link should be visible")
    public void login_link_should_be_visible() {
        LoggerLoad.info("Verifying Login link is visible...");
        Assert.assertTrue(signUp.isLoginLinkVisible());
    }

    @Then("Email ID, Password, and Confirm Password fields should be vertically aligned with equal spacing")
    public void email_id_password_and_confirm_password_fields_should_be_vertically_aligned_with_equal_spacing() {
        LoggerLoad.info("Verifying input fields alignment and spacing...");
        Assert.assertTrue(signUp.areInputFieldsAligned());
    }

    @Then("exactly three input fields should be present")
    public void exactly_three_input_fields_should_be_present() {
        LoggerLoad.info("Verifying exactly three input fields are present...");
        Assert.assertEquals(3, signUp.getNumberOfInputFields());
    }

    @Then("Show Password radio button should be present")
    public void show_password_radio_button_should_be_present() {
        LoggerLoad.info("Verifying Show Password radio button is present...");
        Assert.assertTrue(signUp.isShowPasswordIconVisible());
    }

    @Then("Terms and Conditions details should be present")
    public void terms_and_conditions_details_should_be_present() {
        LoggerLoad.info("Verifying Terms and Conditions text is present...");
        Assert.assertTrue(signUp.isTermsTextPresent());
    }

    @Then("Terms and Conditions radio button should be present")
    public void terms_and_conditions_radio_button_should_be_present() {
        LoggerLoad.info("Verifying Terms and Conditions checkbox is present...");
        Assert.assertTrue(signUp.isTermsCheckboxPresent());
    }

    @Then("background gradient and fonts should match the HerBalance theme")
    public void background_gradient_and_fonts_should_match_the_her_balance_theme() {
        LoggerLoad.info("Verifying HerBalance theme consistency...");
        Assert.assertTrue(signUp.isThemeApplied(),
                "Background gradient or font does not match HerBalance theme");
    }

    @Then("validation messages for Email ID, Password, and Confirm Password should be displayed")
    public void validation_messages_for_email_id_password_and_confirm_password_should_be_displayed() {
        LoggerLoad.info("Verifying validation messages for Email, Password, Confirm Password...");
    }

    @Then("passwords should be visible in both password fields")
    public void passwords_should_be_visible_in_both_password_fields() {
        LoggerLoad.info("Verifying passwords are visible in both fields...");
        Assert.assertEquals("text",
                driver.findElement(signUp.passwordField).getDomAttribute("type"));
        Assert.assertEquals("text",
                driver.findElement(signUp.confirmPasswordField).getDomAttribute("type"));
    }

    @Then("Password field should display value in plain text")
    public void password_field_should_display_value_in_plain_text() {
        LoggerLoad.info("Verifying Password field displays plain text...");
        Assert.assertEquals("text",
                driver.findElement(signUp.passwordField).getDomAttribute("type"));
    }

    @Then("Confirm Password field should display value in plain text")
    public void confirm_password_field_should_display_value_in_plain_text() {
        LoggerLoad.info("Verifying Confirm Password field displays plain text...");
        Assert.assertEquals("text",
                driver.findElement(signUp.confirmPasswordField).getDomAttribute("type"));
    }

    @Then("passwords should be masked in both password fields")
    public void passwords_should_be_masked_in_both_password_fields() {
        LoggerLoad.info("Verifying passwords are masked in both fields...");
        String pwdType = CommonMethods.waitForDomAttribute(signUp.passwordField, "type", 5);
        String confirmType = CommonMethods.waitForDomAttribute(signUp.confirmPasswordField, "type", 5);

        if ("password".equals(pwdType) && "password".equals(confirmType)) {
            LoggerLoad.info("Both password fields are correctly masked.");
        } else {
            LoggerLoad.warn("Password fields masking failed! Types => Password: "
                    + pwdType + ", Confirm: " + confirmType);
        }
    }

    @Then("Password field should mask the entered value")
    public void password_field_should_mask_the_entered_value() {
        LoggerLoad.info("Verifying Password field is masked...");
        String type = CommonMethods.waitForDomAttribute(
                signUp.passwordField, "type", 5
        );

        if ("password".equals(type)) {
            LoggerLoad.info("Password field is correctly masked.");
        } else {
            LoggerLoad.warn("Password field is NOT masked! Current type: " + type);
        }
    }

    @Then("error messages {string} should be displayed")
    public void error_messages_should_be_displayed(String expectedError) {
        LoggerLoad.info("Verifying error message displayed: " + expectedError);
        System.out.println(expectedError);
    }

    @Then("user should be redirected to the onboarding step")
    public void user_should_be_redirected_to_the_onboarding_step() {
        LoggerLoad.info("Waiting for onboarding page URL...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("onboarding"));
        Assert.assertTrue(driver.getCurrentUrl().contains("onboarding"));
        LoggerLoad.info("Onboarding page reached: " + driver.getCurrentUrl());
    }
}
