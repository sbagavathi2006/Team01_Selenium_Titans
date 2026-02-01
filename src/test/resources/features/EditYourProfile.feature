@editProfile
Feature: Edit Your Profile page

  Background:
    Given: User is on login page
    And User clicks login in button after entering  a valid credential
    

  #Profile - Edit Your Profile UI verification
  
  @wip
  Scenario: Verify Title is displayed
    When User clicks on profile name and click on edit profile
    Then  Edit your Profile should be visible
    
  Scenario: Verify Sub text for title is dispalyed
    When User clicks on profile name and click on edit profile
  Then Update your personal information and preferences should be visible 
   
  Scenario: Verify Total number of tabs and Tabs header are displayed
   When User clicks on profile name and click on edit profile
  Then There should be exactly 3 tabs 
  And “Basic Information” ,“Body Metrics”,“Preferences & Health” tabs should be visible
  
  Scenario: Verify Default tab 
  When User clicks on profile name and click on edit profile
  Then Basic Information should be visible by default
  
  Scenario: Verify Back Button Presence
    When User clicks on profile name and click on edit profile
  Then Back Button should be visible
  
  #Edit Your Profile-Basic Information -UI verifications
  

  