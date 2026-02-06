@editProfile
Feature: Edit Your Profile page

  Background:
    Given User is on Dashboard page
    

  #Profile - Edit Your Profile UI verification
  

  Scenario: Verify Title is displayed
    When User clicks on profile name and click on edit profile
    Then  "Edit Your Profile" should be visible
  

  Scenario: Verify Sub text for title is dispalyed
    When User clicks on profile name and click on edit profile
  Then "Update your personal information and preferences" text should be visible 
   
  
  Scenario Outline: Verify Total number of tabs and Tabs header are displayed
   When User clicks on profile name and click on edit profile
  Then User should see below tabs "<tabs>"
  Examples:
	|tabs|
	|Basic Information|
	|Body Metrics|
	|Preferences & Health|
  
  Scenario: Verify Default tab 
  When User clicks on profile name and click on edit profile
  Then "Basic Information" should be visible by default
  
 
  Scenario: Verify Back Button Presence
    When User clicks on profile name and click on edit profile
  Then Back button should be visible
  
  #Edit Your Profile-Basic Information -UI verifications
  
  
  Scenario: Verify Header text inside the section
  When User clicks on profile name and click on edit profile
  And Basic Information should be visible inside section
  
  Scenario: Verify Sub text for header 
   When User clicks on profile name and click on edit profile
  Then "Update your name and age" sub text should be visible
  
  Scenario: Verify Name and age input field presence
   When User clicks on profile name and click on edit profile
  Then Should display the user’s Name and age as entered during the onboarding process.
  
    
 Scenario: Verify “Next: Body Metrics” button presence and navigation
 When User clicks on profile name and click on edit profile
 And User clicks "Next:Body Metrics" button
 Then User should see "Body Metrics" next Section
 And User clicks on Back button on Body Metric section
 Then User should see "Basic Information" previous section
 
 
 #Edit Your Profile-Body Metrics -UI verifications

 
Scenario: Verify Header text inside the section
  When User clicks on profile name and click on edit profile
 And User clicks Body Metrics Tab
Then User should see "Body Metrics" next Section


Scenario: Verify Sub text for header
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then "Update your weight and height information" sub text should be visible

 Scenario: Verify Weight and Height input field presence
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then Should display the user’s Weight and Height are as entered during the onboarding process

Scenario Outline: Verify Dropdown for weight measurment presence and state
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
And User clicks on Weight Dropdown
Then following "<unitValues>" should be visible
Examples:
|unitValues|
|lbs|
|kg|

Scenario Outline: Verify Dropdown for Height measurment presence and state
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then following "<unitValues>" should be visible
Examples:
|unitValues|
|ft/in|
|cm|


 Scenario: Verify "Back" button presence and state
  When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then "Back" button should be visible and enabled


Scenario: Verify “Next: Body Metrics” button presence and navigation
 When User clicks on profile name and click on edit profile
 And User clicks Body Metrics Tab
And User clicks "Next:Preferences" next button
Then User should see "Preferences & Health" last section
And User clicks on Back button on  Preferences & Health section
Then User should see "Body Metrics" section


Scenario: Verify BMI Calculation section is visible
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then BMI Calculation Number should be displayed with a gradient slider and labels


Scenario: Verify BMI Category section is visible
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then BMI Category section should present with BMI Category

Scenario: Verify BMI Categary note is visible
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then BMI Category note should be visible


Scenario: Verify gradient color representation
 When User clicks on profile name and click on edit profile
And User clicks Body Metrics Tab
Then edit slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values
 




  #Edit Your Profile-Prefrences and Health  -UI verifications


Scenario: Verify Header text 
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "Preferences & Health" should be visible in edit profile

Scenario: Verify Sub text for header 
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "Update your dietary preferences and medications" preference should be visible


Scenario Outline: Verify Dietary Preferences RadioButtons options presence and state
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "<diet>" radioButtons should be visible and enabled
Examples:
|diet|
|Pescatarian Diet|
|Non-Vegetarian|
|Vegetarian Diet|
|Vegan Diet| 


Scenario: Verify "Add Medication" Button presence and state
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "Add Medication" preference button should be visible and enabled


Scenario: Verify Medication & Supplements section pesence 
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "Medications & Supplements" medication should be visible



Scenario: Verify "Back " button presence and state
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "Back" button should be visible and enabled

Scenario: Verify "Save Profile " Button pesence and navigation
 When User clicks on profile name and click on edit profile
And User clicks Preferences & Health Tab
Then "Save Profile" save button should be visible and enabled


Scenario: Verify Message after clicking  Save Profile Button
When User navigates to Preferences & Health Tab
And User clicks on Save Profile on  Preferences & Health section after editing values in any field
Then User should see success message "Your profile information has been successfully updated."


Scenario: Verify Navigation of "Add Medication" Button
When User navigates to Preferences & Health Tab
And User clicks on Add Medication button
Then User should see a Pop Up "Enter medication name"

#Preferences & Health -Add Medication UI verification 

Scenario: Verify Header text
When User navigates to Add Medication button
Then "Enter medication name" alert should be visible


Scenario: Verify Adding Medication to the profile
When User navigates to Add Medication button
And User clicks on Ok button after adding medication
Then User should see success message " Your Medication name is saved"


Scenario: Verify Cancel the Medication pop up window
When User navigates to Add Medication button
And User clicks on cancel button without adding medication details
Then User should naviagte back to "Preferences & Health" Section page

 

