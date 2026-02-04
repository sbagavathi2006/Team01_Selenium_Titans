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
  | Section headers1                     |
  | Section headers2                     |
  | Section headers3                     |
  | Phase details with day count         |
  | Current phase guidance               |
  | Calendar                             |
   
   @test
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
    
    
 