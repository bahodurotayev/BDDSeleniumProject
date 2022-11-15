Feature: OrangeHRM login
  Scenario: Logo presence in OrangeHRM login page
    Given I launch chrome browser
    When I open orangeHRM homepage
    Then I verify the logo is present
    And Close browser