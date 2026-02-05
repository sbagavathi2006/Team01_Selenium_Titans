@ui
Feature: HerBalance Login Page UI Verification

  Background:
    Given User is on the HerBalance launch page
    When User clicks log in button

  Scenario: HerBalance logo visibility
    Then HerBalance logo should be visible on the top-left corner

  Scenario: Login and Sign Up tabs are displayed
    Then Both "Login" and "Sign Up" tabs should be visible

  Scenario: Default selected tab is “Login”
   When User clicks loginTab button
    Then Login tab should be active by default

  Scenario: Email ID input field presence on loginPage
    Then Email ID input field with placeholder "you@example.com" should be visible on loginPage

  Scenario: Password input field presence
    Then Password input field with masked entry should be visible on LoginPage

  Scenario: “Show Password” presence
    Then “Show password” should be visible

  Scenario: “Login” button presence and state
    Then “Login” button should be visible, enabled

  Scenario: “Forgot password?” link presence
   When User clicks logIn button
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

