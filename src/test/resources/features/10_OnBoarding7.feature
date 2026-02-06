
Feature: Onboarding step 7 Functionality and Step 8 UI verification

Background:
   Given User completes onboarding until step 6
   

  Scenario: Weight unit dropdowns visibility
  When User clicks weight(kg) dropdown
  Then Options "kg" and "lbs" should be displayed for weight
  
  
  Scenario: Height unit dropdowns visibility
  When User clicks height(cm) dropdown
  Then Options "cm" and "ft/in" should be displayed for height
  
 
  Scenario: Error message for without entering current weight
  When User clicks continue button without entering current weight
  Then Error message "Weight is required" should be displayed for weightfield
  

  Scenario: Error message for without entering height
  When User clicks continue button without entering height
  Then Error message "Height is required" should be displayed for heightfield
  
  
  Scenario: Error message for invalid weight
  When User clicks continue button after entering invalid weight
  Then Error message "Please enter a valid weight" should be displayed for invalid weightfield
  
 
  Scenario: Error message for invalid height
  When User clicks continue button after entering invalid height
  Then Error message "Please enter a valid height" should be displayed for invalid heightfield
  
  
  Scenario: Navigate back to Step 6 from Step 7
  When User clicks back button in step 7
  Then User should be redirected to Step 6
  

  Scenario: Presence of BMI bar labels
  When User enters valid height and weight
  Then BMI bar labels should display "Underweight", "Normal", "Overweight", "Obese" in the correct order
 
  
  Scenario: BMI UI elements visibility after entering height and weight
  When User enters valid height and weight
  Then the following BMI UI elements should be displayed:
  | uiElement          |
  | BMI bar            |
  | BMI calculations   |
  | PhaseNote section  |
  | Feedback section   |
  
 
  Scenario: BMI is displayed based on height and weight
  When User enters valid height and weight for BMIcalculations
  Then BMI should be calculated correctly and displayed
  

  Scenario: Phase note changes based on current phase
  When User enters valid height and weight
  Then Current Phase Note text should match the displayed phase
  
  
  Scenario: BMI Feedback messages appear correctly based on BMI range
  When User enters valid height and weight
  Then BMI feedback message should appear according to the calculated ranges
  
 
  Scenario: BMI feedback message appears correctly for Overweight
  When User enters valid height and weight for an Overweight scenario
  Then BMI feedback message should appear according to the calculated ranges
  
 
  Scenario Outline: Verify Step 8 UI elements are displayed
  When User clicks continue after entering valid weight and height
  Then Step8 "<UI Element>" should be displayed

Examples:
  | UI Element                     |
  | Progress bar                   |
  | Heading                        |
  | Description                    |
  | Pescatarian Diet section       |
  | Non-Vegetarian section         |
  | Vegetarian Diet section        |
  | Vegan Diet section             |
  | Info note message              |
  | Continue button                |
  
  
