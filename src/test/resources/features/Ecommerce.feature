Feature: Ecommerce End to End Happy Path

  # ── Login ──────────────────────────────────────────────
  @Smoke @Regression @Login
  Scenario: User logs in successfully
    Given I am on the landing page of the e-commerce website
    When User clicks on the "Login button"
    And User enters username and password
    And User clicks on the login button in login page
    Then User validates that the user is logged in successfully
    And User performs validates the home page is displayed successfully

  # ── Product Search ──────────────────────────────────────
  @Smoke @Regression @Search
  Scenario: User searches for a product successfully
    Given I am on the landing page of the e-commerce website
    When User clicks the products button
    And User enters the product name in the search bar
    And User clicks on the search icon
    Then User validates that the search results are displayed successfully

  # ── Product Details ─────────────────────────────────────
  @Regression @ProductDetails
  Scenario: User views product details successfully
    Given I am on the landing page of the e-commerce website
    When User clicks the products button
    And User enters the product name in the search bar
    And User clicks on the search icon
    And User clicks on the first product in the search results
    Then User validates that the product details page is displayed successfully

  # ── Add to Cart ─────────────────────────────────────────
  @Smoke @Regression @Cart
  Scenario: User adds product to cart successfully
    Given I am on the landing page of the e-commerce website
    When User clicks the products button
    And User enters the product name in the search bar
    And User clicks on the search icon
    And User clicks on the first product in the search results
    And User clicks on the add to cart button
    Then User validates that the product is added to the cart successfully
    When User clicks on the cart button
    Then User validates that the cart page is displayed successfully

  # ── Checkout ────────────────────────────────────────────
  @Regression @Checkout
  Scenario: User completes checkout successfully
    Given I am on the landing page of the e-commerce website
    When User clicks on the cart button
    And User clicks on the proceed to checkout button
    Then User validates that the checkout page is displayed successfully
    When User enters the shipping address and payment details
    And User clicks on the place order button
    Then User validates that the order is placed successfully

  # ── Payment ─────────────────────────────────────────────
  @Smoke @Regression @Payment
  Scenario: User completes payment successfully
    Given I am on the landing page of the e-commerce website
    When User clicks on the place order button
    And User enters the payment details
    And User clicks on the pay and confirm button
    Then User validates that the payment is processed successfully
    And User performs validates the congratulations page is displayed successfully

  # ── Full E2E ────────────────────────────────────────────
  @E2E @FullFlow @Smoke
  Scenario: User completes full end to end purchase flow
    Given I am on the landing page of the e-commerce website
    When User clicks on the "Login button"
    And User enters username and password
    And User clicks on the login button in login page
    Then User validates that the user is logged in successfully
    And User performs validates the home page is displayed successfully
    When User clicks the products button
    And User enters the product name in the search bar
    And User clicks on the search icon
    Then User validates that the search results are displayed successfully
    When User clicks on the first product in the search results
    Then User validates that the product details page is displayed successfully
    When User clicks on the add to cart button
    Then User validates that the product is added to the cart successfully
    When User clicks on the cart button
    Then User validates that the cart page is displayed successfully
    When User clicks on the proceed to checkout button
    Then User validates that the checkout page is displayed successfully
    When User enters the shipping address and payment details
    And User clicks on the place order button
    Then User validates that the order is placed successfully
    When User enters the payment details
    And User clicks on the pay and confirm button
    Then User validates that the payment is processed successfully
    And User performs validates the congratulations page is displayed successfully
    When User clicks on the logout button
    Then User validates that the user is logged out successfully

  # ── Logout ──────────────────────────────────────────────
  @Smoke @Regression @Logout
  Scenario: User logs out successfully
    Given I am on the landing page of the e-commerce website
    When User clicks on the "Login button"
    And User enters username and password
    And User clicks on the login button in login page
    And User clicks on the logout button
    Then User validates that the user is logged out successfully
