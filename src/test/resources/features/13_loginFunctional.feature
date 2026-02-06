Feature: HerBalance Login Page functional Verification

  Background:
      Given User is on the HerBalance auth page
  
Scenario: Successful login with valid credentials
    When user clicks login button after entering a "valid" credential
    Then User should be redirected to the dashboard

  Scenario: Login attempt with invalid credentials
    When user clicks login button after entering a "invalid" credential
    Then An error message "Invalid credentials" should be displayed

  Scenario: Login attempt with empty fields
    When user clicks login button after leaving credential blank
    Then Validation messages "Email is required" and "Password is required" should be displayed

  Scenario: Check show password behaviour
    When User clicks show password after entering password
    Then Password should be visible in plain text

  Scenario: Hide Password after unchecking
    When User unchecks the "Show Password" option after entering the password
    Then Password should again be masked

  Scenario: Password visible when clicking eye icon
    When User enters a password and clicks the eye icon
    Then Password field should show the entered password in plain text

  Scenario: Password hides when eye icon clicked again
    When User clicks the eye icon again
    Then Password should again be masked

  Scenario: Navigate to Forgot Password page
    When user clicks on "Forgot password?"
    Then User should be redirected to the Forgot Password page

  Scenario: Navigate to Sign Up page
    When user clicks on "Sign up" tab
    Then User should be redirected to the sign up tab
    