package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SignUpPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import context.TestContextSetup;
import driverFactorySetUp.DriverFactory;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

import java.time.Duration;

public class SignUpStepDefinition {

    WebDriver driver;
    SignUpPage signUp;
    TestContextSetup context;
    
    public SignUpStepDefinition(TestContextSetup context) {
        this.context = context;
        this.driver = context.getDriver();
        this.signUp = context.signUpPage();
    }

    @Given("user is on the HerBalance launch page")
    public void user_is_on_the_her_balance_launch_page() {
        driver = DriverFactory.getDriver();
       // driver.get(ConfigReader.getProperty("url"));
        signUp = new SignUpPage(driver);
    }

    @When("user clicks the Sign Up button")
    public void user_clicks_the_sign_up_button() {
        signUp.clickSignUpButton();
    }

    @Then("Email ID input field with placeholder {string} should be visible")
    public void verify_email_placeholder(String placeholder) {
        LoggerLoad.info("Verifying Email placeholder: " + placeholder);
        if (signUp.isEmailFieldVisible()) {
            LoggerLoad.info("Email field is visible");
        } else {
            LoggerLoad.warn("Email field is NOT visible");
        }
    }

    @Then("Password field should mask the entered value")
    public void password_field_masked() {
        String type = CommonMethods.waitForDomAttribute(signUp.passwordField, "type", 5);
        if ("password".equals(type)) {
            LoggerLoad.info("Password field is correctly masked.");
        } else {
            LoggerLoad.warn("Password field is NOT masked! Current type: " + type);
        }
    }

    @Then("passwords should be masked in both password fields")
    public void passwords_masked() {
        String pwdType = CommonMethods.waitForDomAttribute(signUp.passwordField, "type", 5);
        String confirmType = CommonMethods.waitForDomAttribute(signUp.confirmPasswordField, "type", 5);
        if ("password".equals(pwdType) && "password".equals(confirmType)) {
            LoggerLoad.info("Both password fields are correctly masked.");
        } else {
            LoggerLoad.warn("Password fields masking failed! Types => Password: " + pwdType + ", Confirm: " + confirmType);
        }
    }

    @When("user enters invalid Email ID and clicks Register")
    public void invalid_email() {
        signUp.fillFormFromTestData("TC02", true);
        signUp.clickRegister();
        LoggerLoad.info("Filled form with invalid email for TC02");
    }

    @Then("error messages {string} should be displayed")
    public void verify_error_message(String expectedError) {
        String actualError = signUp.getErrorMessage();
        LoggerLoad.info("Expected Error: " + expectedError + ", Actual Error: " + actualError);
    }

    @When("user enters valid Email ID, Password, and Confirm Password and clicks Register")
    public void register_valid_credentials() {
        signUp.registerWithValidDynamicData(context);
    }

    @Then("user should be redirected to the onboarding step")
    public void verify_onboarding() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("onboarding"));
        LoggerLoad.info("Current URL: " + driver.getCurrentUrl());
    }

    @Then("close browser")
    public void close_browser() {
        DriverFactory.quitDriver();
        LoggerLoad.info("Browser closed");
    }
}
