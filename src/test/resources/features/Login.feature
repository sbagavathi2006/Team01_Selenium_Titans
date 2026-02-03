
Feature: HerBalance Login Page

  Background:
    Given User is on the HerBalance launch page
    When User clicks log in button

  Scenario: HerBalance logo visibility
    Then HerBalance logo should be visible on the top-left corner

  Scenario: Login and Sign Up tabs are displayed
    Then Both "Login" and "Sign Up" tabs should be visible

  Scenario: Default selected tab is “Login”
    Then “Login” tab should be active by default

  Scenario: Email ID input field presence
    Then Email ID input field with placeholder "you@example.com" should be visible

  Scenario: Password input field presence
    Then Password input field with masked entry should be visible

  Scenario: “Show Password” presence
    Then “Show password” should be visible

  Scenario: “Login” button presence and state
    Then “Login” button should be visible, enabled

  Scenario: “Forgot password?” link presence
    Then “Forgot password?” link should be visible

  Scenario: “Sign Up” link visibility
    Then “Sign Up” link should be visible and navigates to the Sign-Up page

  Scenario: Right panel content (Transform Your Weight Loss Journey)
    Then The right section should display “Cycle-Synced Plans”, “Blood Work Analysis”, and “Personalized Dashboard” content

  Scenario: Testimonial section presence
    Then A testimonial with text and name (e.g., “Sarah, 34”) should be displayed

  Scenario: Total number of tabs
    Then There should be exactly 2 tabs — “Login” and “Sign Up”

  Scenario: Input field alignment and spacing
    Then Email ID and Password fields should be properly aligned vertically with equal spacing

  Scenario: Two input field
    Then There should be exactly 2 input field

  Scenario: Radio button for show password
    Then Radio button for show password

  Scenario: Background and theme consistency
    Then The background gradient (light purple) and fonts should match HerBalance theme


  
  Scenario: Successful login with valid credentials
    Given User is on the HerBalance auth page
    When user clicks login button after entering a valid credential
    Then User should be redirected to the dashboard

  Scenario: Login attempt with invalid credentials
    Given User is on the HerBalance auth page
    When user clicks login button after entering a invalid credential
    Then An error message "Invalid email or password" should be displayed

  Scenario: Login attempt with empty fields
    Given User is on the HerBalance auth page
    When user clicks login button after leaving credential blank
    Then Validation messages "Email ID is required" and "Password is required" should be displayed

  Scenario: Check show password behaviour
    Given User is on the HerBalance auth page
    When User clicks show password after entering password
    Then Password should be visible in plain text

  Scenario: Hide Password after unchecking
    Given User is on the HerBalance auth page
    When User unchecks the "Show Password" option after entering the password
    Then Password should again be masked

  Scenario: Password visible when clicking eye icon
    Given User is on the HerBalance auth page
    When User enters a password and clicks the eye icon
    Then Password field should show the entered password in plain text

  Scenario: Password hides when eye icon clicked again
    Given User is on the HerBalance auth page
    When User clicks the eye icon again
    Then Password should again be masked

  Scenario: Navigate to Forgot Password page
    Given User is on the HerBalance auth page
    When user clicks on "Forgot password?"
    Then User should be redirected to the Forgot Password page

  Scenario: Navigate to Sign Up page
    Given User is on the HerBalance auth page
    When user clicks on "Sign up" tab
    Then User should be redirected to the sign up tab
    