Feature: Sign Up Page

  Background:
    Given user is on the HerBalance launch page

  
  Scenario: Verify Email ID input field presence
    When user clicks the Sign Up button
    Then Email ID input field with placeholder "you@example.com" should be visible

  Scenario: Verify Password input field presence
    When user clicks the Sign Up button
    Then Password input field with masked entry should be visible

  Scenario: Verify Confirm Password input field presence
    When user clicks the Sign Up button
    Then Confirm Password input field with masked entry should be visible

  Scenario: Verify Show Password option presence
    When user clicks the Sign Up button
    Then Show Password option should be visible

  Scenario: Verify Register button presence and enabled state
    When user clicks the Sign Up button
    Then Register button should be visible and enabled

  Scenario: Verify Login link visibility
    When user clicks the Sign Up button
    Then Login link should be visible 

  Scenario: Verify input field alignment and spacing
    When user clicks the Sign Up button
    Then Email ID, Password, and Confirm Password fields should be vertically aligned with equal spacing

  Scenario: Verify number of input fields
    When user clicks the Sign Up button
    Then exactly three input fields should be present

  Scenario: Verify Show Password radio button presence
    When user clicks the Sign Up button
    Then Show Password radio button should be present

  Scenario: Verify Terms and Conditions presence
    When user clicks the Sign Up button
    Then Terms and Conditions details should be present

  Scenario: Verify Terms and Conditions radio button presence
    When user clicks the Sign Up button
    Then Terms and Conditions radio button should be present

  Scenario: Verify background and theme consistency
    When user clicks the Sign Up button
    Then background gradient and fonts should match the HerBalance theme

  Scenario: Successful registration with valid credentials
    Given user is on the HerBalance auth page
    When user enters valid Email ID, Password, and Confirm Password and clicks Register
    Then user should be redirected to the onboarding step

  Scenario: Registration attempt with invalid email address
    Given user is on the HerBalance auth page
    When user enters invalid Email ID and clicks Register
    Then error messages "Invalid email address" should be displayed

  Scenario: Registration attempt with password length of five characters
    Given user is on the HerBalance auth page
    When user enters password with length five and clicks Register
    Then error messages "Password must be at least 6 characters" should be displayed

  Scenario: Registration attempt with mismatched passwords
    Given user is on the HerBalance auth page
    When user enters mismatched Password and Confirm Password and clicks Register
    Then error messages "Please confirm your password" should be displayed

  Scenario: Registration attempt with empty fields
    Given user is on the HerBalance auth page
    When user clicks Register without entering any details
    Then validation messages for Email ID, Password, and Confirm Password should be displayed

  Scenario: Registration attempt without accepting Terms and Conditions
    Given user is on the HerBalance auth page
    When user clicks Register without accepting Terms and Conditions
    Then error messages "You must accept the Terms & Conditions and Privacy Policy" should be displayed


  Scenario: Show passwords using eye icon
    Given user is on the HerBalance auth page
    When user clicks eye icon after entering passwords
    Then passwords should be visible in both password fields

  Scenario: Hide passwords after clicking eye icon again
    Given user is on the HerBalance auth page
    When user clicks eye icon again
    Then passwords should be masked in both password fields

  Scenario: Show password value in Password field
    Given user is on the HerBalance auth page
    When user clicks eye icon in Password field
    Then Password field should display value in plain text

  Scenario: Hide password value in Password field
    Given user is on the HerBalance auth page
    When user clicks eye icon again in Password field
    Then Password field should mask the entered value

  Scenario: Show password value in Confirm Password field
    Given user is on the HerBalance auth page
    When user clicks eye icon in Confirm Password field
    Then Confirm Password field should display value in plain text
