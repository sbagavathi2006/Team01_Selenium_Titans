@OnBoarding3Fn
Feature: OnBoarding3Fn

  # Onboarding step 3 Functionality and Step 4 UI verification
  Background: 
    Given User is in step Three of onboarding
    When User clicks continue selects health condition

  Scenario: Navigation to Step Four
    Then Redirected to Step Four

  Scenario: Display onboarding progress
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible
    Then Progress bar shows the current step as Four of Ten

  Scenario: Back button is visible
    Then Back button is displayed

  Scenario: State of Back button
    Then Back button should be enabled

  Scenario: Continue is visible
    Then Continue button should be visible

  Scenario: State of Continue button
    Then Continue button should be enabled

  Scenario: Title for onboarding step four
    Then Should see the title Personal Details

  Scenario: Description text for step four
    Then Description text should be displayed

  Scenario: Input box count
    Then Input box should be two 2

  Scenario Outline: Field labels
    Then Field labels should be "<labels>" displayed

    Examples: 
      | labels              |
      | your first name     |
      | your age            |
      | your blood pressure |

  Scenario Outline: Helper text for the field
    Then Under each "<field>" field helper text "<text>" should be matched

    Examples: 
      | field               | text                              |
      | your first name     | knowing your name                 |
      | your age            | tailor recommendations            |
      | your blood pressure | Understanding your blood pressure |

  
  Scenario: Total number of radio button
    Then Radio button should be visible

  Scenario Outline: Options for radio button text
    Then Text "<text>" displayed

    Examples: 
      | text                                           |
      | high blood pressure and take medication for it |
      | I have been diagnosed but                      |
      | I have never been diagnosed                    |
      | not sure                                       |
