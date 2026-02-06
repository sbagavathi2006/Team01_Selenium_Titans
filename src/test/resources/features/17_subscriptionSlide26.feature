Feature:  Subscription  - Subscription Management

  Background:  User clicks profile button labelled as [user's name] after logged in

  Scenario:  Subscription Management - Verify Title
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription to verify the subscription information
    Then "Subscription Management" text should be visible on the page

  Scenario:  Subscription Management two Sections visibility
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription to verify the subscription information
    Then  Exactly 2 sections should be visible

  Scenario Outline: Subscription Management - Verify Section heading text
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription to verify the subscription information
    Then  The mentioned "<sectionHeaders>" should br displayed
    Examples:
      |sectionHeaders|
      |Current Subscription|
      |Subscription History|
  Scenario: Verify the Header text inside the Current Subscription section
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription to verify the subscription information
    Then  The mentioned header text "Current Subscription" should be displayed



