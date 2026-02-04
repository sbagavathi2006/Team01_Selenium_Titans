@OnBoarding3
Feature: OnBoarding3

  #Onboarding Scenarios  Step 3  UI verifcation
  
  Background: 
    Given User is in upload blood report page
    When User clicks continue without report

  Scenario: Display onboarding progress
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible
    Then Progress bar shows the current step as Three of Ten

  Scenario: Back button is visible
    Then Back button is displayed

  Scenario: State of Back button
    Then Back button should be enabled

  Scenario: Continue is visible
    Then Continue button should be visible

  Scenario: State of Continue button
    Then Continue button should be enabled

  Scenario: Step Three Header is displayed
    Then Header should be Health condition

  Scenario: Sub title for the header
    Then Sub title should be displayed

  Scenario: Total number of radio button
    Then Nine radio button should be visible

  Scenario Outline: Options "<healthCondition>" for health condition
    Then Health Condition "<healthCondition>" should be visible

    Examples: 
    	| healthCondition															|
      | PCOS                                         |
      | Pre-diabetes / Diabetes                      |
      | Sleep apnea                                  |
      | Cardiovascular Disease                       |
      | Kidney Disease                               |
      | Hypothyroidism                               |
      | High cholesterol                             |
      | Digestive issues (IBS, leaky gut, etc.)      |
      | Liver Disease                                |
      | I am perimenopausal or menopausal (age ~45+) |

  Scenario: Informational note section
    Then Note text should displayed
