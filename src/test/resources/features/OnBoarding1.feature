Feature: OnBoarding1

  Background: 
    Given User is on sign up page
    When User clicks register button after entering valid details    

  Scenario: Title of the onboarding step one
    Then Title of the page should be Upload Your Recent Blood Work

  Scenario: Supporting text for the title
    Then Step one should have supporting text

  Scenario: Display onboarding progress
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible
    Then Progress bar shows the current step as one of Ten in number

  Scenario: Upload PDF button is displayed
    Then Upload PDF button is displayed

  Scenario: Upload PDF button is enabled
    Then Upload PDF button should be enabled

  Scenario: Notes for upload pdf is displayed
    Then PDF files only Max Ten MB is visible

  Scenario: Display skip option
    Then Skip for Now card is visible

  Scenario: Text explanation for skip report
    Then Explanation text about continuing without lab results is displayed

  Scenario: Continue Without Report button is displayed
    Then Continue Without Report button is displayed

  Scenario: Continue without button is enabled
    Then Continue without button is enabled

  Scenario: Display data security information
    Then Note about secure processing and no sharing with third parties is displayed
