Feature:
  Scenario:
    Given I am on the landing page of the e-commerce website
    Then User clicks on the "Login button"
    Then User enters username and password
    Then User clicks on the login button in login page
    Then User validates that the user is logged in successfully
    Then User performs validates the home page is displayed successfully
    Then User clicks the products button
    Then User enters the product name in the search bar
    Then User clicks on the "Search" button
    Then User validates that the search results are displayed successfully
    When User clicks on the first product in the search results
    Then User validates that the product details page is displayed successfully
    When User clicks on the "Add to Cart" button
    Then User validates that the product is added to the cart successfully
    When User clicks on the "Cart" button
    Then User validates that the cart page is displayed successfully
    When User clicks on the "Procedd to Checkout" button
    Then User validates that the checkout page is displayed successfully
    When User enters the shipping address and payment details
    When User clicks on the "Place Order" button
    Then User validates that the order is placed successfully
    Then User enters the payment details
    Then User clicks on the "Pay And Confirm " button
    Then User validates that the payment is processed successfully
    Then User performs validates the congratulations page is displayed successfully
    Then User clicks on the "Logout" button
    Then User validates that the user is logged out successfully