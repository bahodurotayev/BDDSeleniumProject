Feature: Login to Nop-Commerce

  Scenario: Successfully login with valid credentials

    Given User Launch Chrome browser
    When User open nopCommerce URL "https://admin-demo.nopcommerce.com/login"
    And User enters valid credentials as email "admin@yourstore.com" password "admin"
    And User click Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page title should be "Your store. Login"
    And close browser