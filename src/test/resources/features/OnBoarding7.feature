#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

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
  
  
