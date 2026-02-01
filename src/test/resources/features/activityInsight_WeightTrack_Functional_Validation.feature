Feature: Weight Tracking functional verification

  Background:
    Given User is on Activity Insights tab - Weight Tracking page after successful login

  Scenario: Verify if Log Weight button enables after valid input
    When User enters weight(kg) as "45" in Log Todays weight section
    Then Log Weight button should be Enabled

  Scenario: New tracking record appears after logging weight
    When User clicks Log Weight button after entering "Weight" value
    Then Entered weight should be added to the tracking record

  Scenario:  Verify if error is displayed for Invalid weight entry
    When User enter invalid value in weight "-1" in log today's weight section
    Then error message "Please enter a valid weight message" should be displayed

  Scenario: Verify if Graph updates after weight entry
    When User clicks "Log Weight" button after entering valid value as "50" in weight field
    Then "Weight Progression Over Time" graph should plot the new value for that day

  Scenario: Verify if Progress bar updates after logging new weight
    When User clicks "Log Weight" button after entering valid value as "50" in weight field
    Then Line chart should reflect weight trend changes

  Scenario: Verify if Progress updates in the progress bar
    When User clicks "Log Weight" button after entering valid value as "50" in weight field
    Then "Weight Lost" and "Remaining" values should update accordingly

  Scenario: Verify if Optional note is added to entry
    When User clicks "Log Weight" button after entering valid value as "50" in weight field
    Then progress bar percentage should adjust to reflect new progress

  Scenario:
    When User clicks "Log Weight" button after entering valid value as "50" in weight field
    Then Note should be saved along with the weight entry

