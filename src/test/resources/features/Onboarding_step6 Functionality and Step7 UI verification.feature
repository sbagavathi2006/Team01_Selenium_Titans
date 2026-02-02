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
@tag
Feature: Onboarding step 6 Functionality and Step 7 UI verification
 
Background:
   User completes onboarding until step 5
 
 Scenario: Error message for without selecting last menstrual date
    When User clicks continue button without selecting last menstrual date
    Then Error message "Please select your last period start date" should be displayed
    
 Scenario: Navigate back to step 5 from step 6
    When User clicks back button in step 6
    Then User should be navigated back to step 5
    
 Scenario: Error message for without selecting last menstrual date
    When User clicks continue button without selecting last menstrual date
    Then Error message "Please select your last period start date" should be displayed
    
    
    
 