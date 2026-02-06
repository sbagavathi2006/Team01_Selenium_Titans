
Feature: Onboarding step 6 Functionality and Step 7 UI verification

Background:
   Given User completes onboarding until step 5
 
 Scenario: Error message for without selecting last menstrual date
    When User clicks continue button without selecting last menstrual date
    Then Error message "Please select your last period start date" should be displayed

 Scenario: Navigate back to step 5 from step 6
 When User clicks back button in step 6
 Then User should be navigated back to step "5 of 10"
 

 Scenario: Error message for invalid value in date
 When User clicks continue button after entering invalid value in date
 Then Error message "Please select your last period start date" should be displayed
 

 Scenario Outline: Verify UI elements after last menstrual date
  When User selects last menstrual date
  Then "<UI Element>" should be displayed

  Examples:
  | UI Element                           |
  | Message related to last period date  |
  | Description for current phase        |
  | YourCycleTimeline                    |
  | YourUpcomingCycleCalendar            |         
  | YourNextExpectedPeriods              |
  | Phase details with day count         |
  | Current phase guidance               |
  | Calendar                             |
  | Left arrow in calender               |
  | Right arrow in calender              |
  

  Scenario: Phase guidance text is visible for current cycle phase
  When User selects last menstrual date
  Then Detailed phase guidance text should be visible based on phase

  
  Scenario: Display two months in upcoming cycle calendar
  When User selects last menstrual date
  Then Current month and next month should be visible


  Scenario: Update phase when last menstrual date is changed
  When User selects last menstrual date
  And User changes the date using the upcoming cycle calendar
  Then Phase displayed in the timeline should update accordingly
 
 
  Scenario: Display of next expected periods
  When User selects last menstrual date
  Then At least three future expected period dates should be listed

  
  Scenario Outline: Verify Step 7 UI elements after completing Step 6
  When User clicks continue after selecting last menstrual date
  Then "<Element>" should be displayed for step7

Examples:
  | Element         |
  | Progress bar    |
  | Heading         |
  | Description     |
  | Weight input field |
  | Height input field |
  | Weight question |
  | Height question |                                       
    
    
 