@OnBoarding4
Feature: OnBoarding4

  #Onboarding step 4 Functionality and Step 5 UI verification
  Background: 
    Given User is in step Four of onboarding
    

  Scenario: Error message for invalid values in First name
    When User clicks continue button after entering invalid value "@#$%^l" in first name
    Then Error message "Please enter valid name" displayed


  Scenario: Error message for invalid values in age
    When User clicks continue button after entering invalid value "jh" in age
    Then Error message "Please enter a number" should displayed
    

  Scenario: Error message for without selecting blood pressure status
    When User clicks continue button without selecting blood pressure staus
    Then Error message is displayed


  Scenario: Navigating back to step Three
    When User clicks back button in step Four
    Then Redirected to Step Three


  Scenario: Navigation to Step Five
    When User clicks continue after entering  all required details
    Then Redirected to Step Five
    

  Scenario: Step Five UI verification
    When User clicks continue after entering  all required details
    Then Onboarding progress bar is visible
    

  Scenario: Progress bar is visible in step Five
    When User clicks continue after entering  all required details
    Then Progress bar shows the current step as  Five of Ten


  Scenario: Back button is visible in step Five
    When User clicks continue after entering  all required details
    Then Back button is displayed on Mensural Cycle page


  Scenario: state of Back button in step Five
    When User clicks continue after entering  all required details
    Then Back button should be enabled on Mensural Cycle page

  Scenario: Continue is visible in step Five
    When User clicks continue after entering  all required details
    Then Continue button should be displayed on Mensural Cycle page

  Scenario: State of Continue button in step Five
    When User clicks continue after entering  all required details
    Then Continue button should be enabled on Mensural Cycle page

  Scenario: Title for Step Five
    When User clicks continue after entering  all required details
    Then Should see the title Menstrual Cycle Awareness "Menstrual Cycle Awareness"

  Scenario: Description text for step Five
    When User clicks continue after entering  all required details
    Then Description text "Understanding your cycle helps us optimize your weight loss journey."

  Scenario: Presence of question in step Five
    When User clicks continue after entering  all required details
    Then Question "Do you currently track your menstrual cycle?" should be visible


  Scenario: Total number of radio button
    When User clicks continue after entering  all required details
    Then 3 radio button should be visible
    

  Scenario Outline: Options for radio button
    When User clicks continue after entering  all required details
    Then Radio options "<string>" for  menstrual cycle awareness should be displayed

    Examples: 
      | string                |
      | Yes                   |
      | No                    |
      | My cycle is irregular |
