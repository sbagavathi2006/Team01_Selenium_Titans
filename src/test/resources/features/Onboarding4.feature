@OnBoarding4
Feature: OnBoarding4

  #Onboarding step 4 Functionality and Step 5 UI verification
  Background: 
    Given User is in step Four of onboarding
    
@fail
  Scenario: Error message for invalid values in First name
    When User clicks continue button after entering invalid value "@#$%^l" in first name
    Then Error message "Please enter valid name" displayed

@fail
  Scenario: Error message for invalid values in age
    When User clicks continue button after entering invalid value "jh" in age
    Then Error message "Please enter a number" should displayed
    
@ptag
  Scenario: Error message for without selecting blood pressure status
    When User clicks continue button without selecting blood pressure staus
    Then Error message is displayed

@pass
  Scenario: Navigating back to step Three
    When User clicks back button in step Four
    Then Redirected to Step Three

@pass
  Scenario: Navigation to Step Five
    When User clicks continue after entering  all required details
    Then Redirected to Step Five
    
@pass
  Scenario: Step Five UI verification
    When User clicks continue after entering  all required details
    Then Onboarding progress bar is visible
    
@pass
  Scenario: Progress bar is visible in step Five
    When User clicks continue after entering  all required details
    Then Progress bar shows the current step as  Five of Ten

@pass
  Scenario: Back button is visible in step Five
    When User clicks continue after entering  all required details
    Then Back button is displayed on Mensural Cycle page

@pass
  Scenario: state of Back button in step Five
    When User clicks continue after entering  all required details
    Then Back button should be enabled on Mensural Cycle page
@fp
  Scenario: Continue is visible in step Five
    When User clicks continue after entering  all required details
    Then Continue button should be displayed on Mensural Cycle page
@fail
  Scenario: State of Continue button in step Five
    When User clicks continue after entering  all required details
    Then Continue button should be enabled on Mensural Cycle page
@fp
  Scenario: Title for Step Five
    When User clicks continue after entering  all required details
    Then Should see the title Menstrual Cycle Awareness "Menstrual Cycle Awareness"
@fp
  Scenario: Description text for step Five
    When User clicks continue after entering  all required details
    Then Description text "Understanding your cycle helps us optimize your weight loss journey."
@fp
  Scenario: Presence of question in step Five
    When User clicks continue after entering  all required details
    Then Question "Do you currently track your menstrual cycle?" should be visible

@pass
  Scenario: Total number of radio button
    When User clicks continue after entering  all required details
    Then 3 radio button should be visible
    
@tag
  Scenario Outline: Options for radio button
    When User clicks continue after entering  all required details
    Then Radio options "<string>" for  menstrual cycle awareness should be displayed

    Examples: 
      | string                |
      | Yes                   |
      | No                    |
      | My cycle is irregular |
