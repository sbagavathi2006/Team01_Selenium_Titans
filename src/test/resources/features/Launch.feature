@ui
Feature: Launch Page in Her Balance

  Background: 
    Given User is on the browser
    When User enters the Her Balance application URL

  Scenario Outline: Verify launch page UI elements are visible
    Then "<element>" should be visiblee

    Examples: 
      | element                                |
      | Login button                           |
      | Sign Up button                         |
      | Get Started Now button                 |
      | Start Your Personalized Journey button |

  Scenario: Verify cycle phase information is displayed
    Then Cycle phase cards should be displayed
      | Menstrual Phase  |
      | Follicular Phase |
      | Ovulation Phase  |
      | Luteal Phase     |

  Scenario: Verify layout and colors
    Then Background color should be light purple
    And Text content should be readable

  Scenario: Cycle tracking app information is visible
    Then Details about the "Cycle Tracking App" and its features should be displayed

  Scenario: Images in Sync your weight loss journey section are displayed
    Then Images in "Sync your weight loss journey" section should be displayed

  Scenario: Informational text under Empower weight loss section is displayed
    Then Display information about hormonal shifts and metabolism during the menstrual cycle

  Scenario: Login button is clickable
    Given User is on Her Balance home page
    When User clicks on Login button
    Then User should be navigated to authentication page with Login tab selected

  Scenario: Sign up button is clickable
    Given User is on Her Balance home page
    When User clicks on Sign Up button
    Then User should be navigated to authentication page with Sign Up tab selected

  Scenario: Get Started Now button is clickable
    Given User is on Her Balance home page
    When User clicks on Get Started Now button
    Then User should be navigated to authentication page with Login tab selected

  Scenario: Start Your Personalized Journey button is clickable
    Given User is on Her Balance home page
    When User clicks on Start Your Personalized Journey button
    Then User should be navigated to authentication page with Login tab selected
