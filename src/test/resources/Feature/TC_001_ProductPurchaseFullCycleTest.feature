Feature: Product purchase journey
@orderPurchaseJourney
  Scenario Outline: Product purchase journey full cycle test
    Given User lands on the home page and verify that home page is visible
    When Add products to cart
    And Click on the Cart button
    Then Verify that cart page is displayed
    When Click on the Proceed To Checkout button
    And Click on the Register or Login button
    And Insert '<name>' and '<email>'
    And Click on the signup button
    And Insert '<password>','<firstName>','<lastName>','<address>','<state>','<city>','<zipcode>','<mobileNumber>'
    And Click on the create account button
    Then Verify that ACCOUNT CREATED and click on Continue button
    And Verify Logged in as username at top
    When Click on the Cart button from the top menu bar
    And Click on the Checkout button
    Then Verify Address Details and Review Your Order
    And Enter description in '<comment>' text area and click on the Place Order button
    When Enter payment details: '<CardName>', '<CardNumber>', '<CVC>', '<ExpirationMonth>','<ExpirationYear>'
    And Click on the Pay and Confirm Order button
    Then Verify the success message Your order has been placed successfully!
    And Logout from the site
    Examples:
      | name | email        | password | firstName | lastName | address       | state   | city      | zipcode | mobileNumber |comment        | CardName | CardNumber         | CVC | ExpirationMonth |ExpirationYear|
      |Tony  |sajib_testqa010@ymail.com|Test@123  |Tony       |Hold      |936 Kiehn Route|Tennessee|West Ned	|11230    |2126583916    |My test comment|Tony Hold | 1234 5678 9012 3456|123  |12               |2025          |

