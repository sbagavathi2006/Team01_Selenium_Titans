
Feature: Blood Report Upload Model Navigation

Background:
	Given User is on sign up page
	
  Scenario: Title of the onboarding step 1
 		When User clicks register button after entering valid details
    Then Title of the page should be Upload Your Recent Blood Work
    
          
  Scenario: Supporting text for the title
   	When User clicks register button after entering valid details
    Then Step 1 should have supporting text