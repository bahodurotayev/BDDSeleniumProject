Feature:  Customer

  Scenario: Add new Customer
    Given User Launch Chrome browser
    When User open nopCommerce URL "https://admin-demo.nopcommerce.com/login"
    And User enters valid credentials as email "admin@yourstore.com" password "admin"
    And User click Login
    Then User can view Dashboard
    When User click on customers Menu
    And User click on customers Menu Item
    And User click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And User click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser