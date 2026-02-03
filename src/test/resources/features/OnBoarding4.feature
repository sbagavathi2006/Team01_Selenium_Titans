@OnBoarding4
Feature: OnBoarding4

  #Onboarding Scenarios  Step 3  UI verifcation
  
  Background: 
    Given User is in upload blood report page
    When User clicks continue without report

  Scenario: Display onboarding progress
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible
    Then Progress bar shows the current step as Three of Eleven

  Scenario: Back button is visible
    Then Back button is displayed

  Scenario: State of Back button
    Then Back button should be enabled

  Scenario: Continue is visible
    Then Continue button should be visible

  Scenario: State of Continue button
    Then Continue button should be enabled

  Scenario: Step Three Header is displayed
    Then Header should be "Health condition"

  Scenario: Sub title for the header
    Then "Want to manually enter any key conditions or comorbidities?" should be displayed

  Scenario: Total number of radio button
    Then Nine radio button should be visible

  Scenario Outline: Options text for health condition
    Then <healthCondition> should be visible

    Examples: 
      | PCOS                                         |
      | Pre-diabetes / Diabetes                      |
      | Sleep apnea                                  |
      | Cardiovascular Disease                       |
      | Kidney Disease                               |
      | Hypothyroidism                               |
      | High cholesterol                             |
      | Digestive issues                             |
      | Liver Disease                                |
      | I am perimenopausal or menopausal (age ~45+) |

  Scenario: Informational note section
    Then Note text should displayed
