@OnBoarding5

Feature: OnBoarding5

  #Onboarding step 5 Functionality and Step 6 UI verification
  Background: 
    Given User is in step Five of onboarding

  Scenario: Error message for without selecting menstrual cycle
    When User clicks continue button without selecting menstrual cycle
    Then Error message "Please select your menstrual cycle track " should be displayed

  Scenario: Navigating back to step Four
    When User clicks back button in step Five
    Then Redirected to Step Four

  Scenario: Navigation to Step Six
    When User clicks continue after selecting menstrual cycle info
    Then Redirected to Step Six

  Scenario Outline: Verify UI elements are displayed on Last Period Date "<scenario>"
    When User clicks continue after selecting menstrual cycle info
    Then UI Element "<string>" should be displayed on menstrual cycle info page

    Examples: 
      | scenario                             | string                                        |
      | Display onboarding progress in step6 | Onboarding progress bar                       |
      | Progress bar is visible in step6     | Progress bar shows the current step as  6of11 |
      | Back button is visible in step6      | Back button                                   |
      | Continue is visible in step6         | Continue button                               |
      | Slider for cycle length              | Slider control for cycle length               |
      | Presence of calendar icon in step6   | Calendar icon                                 |

  Scenario Outline: Verify UI elements are enable on Last Period Date Step6 "<scenario>"
    When User clicks continue after selecting menstrual cycle info
    Then UI Element "<string>" should be enabled on menstrual cycle info page

    Examples: 
      | scenario                          | string          |
      | state of Back button in step6     | Back button     |
      | State of Continue button in step6 | Continue button |

  Scenario Outline: Verify UI elements are matched on Last Period Date Step6 "<scenario>"
    When User clicks continue after selecting menstrual cycle info
    Then UI Element "<matchingstring>" should be matched on menstrual cycle info page

    Examples: 
      | scenario                               | matchingstring                                                                |
      | Title for step6                        | Last Period Date                                                              |
      | Description text for step6             | This helps us understand your current cycle phase and tailor recommendations. |
      | Presence of question in step6          | did your last menstrual period start?                                         |
      | Placeholder tex for date field in sep6 | mm/dd/yyyy                                                                    |
      | Label below the date field             | Cycle Length (days)                                                           |
      | Information text for cycle length      | but can vary from 21 to 45 days                                               |
      | Default cycle length in slider         |                                                                            28 |
