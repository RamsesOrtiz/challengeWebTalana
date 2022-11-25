Feature: Automation Web Challenge demoblaze.com

  @AddMultipleCategories
  Scenario: Add multiple categories
    Given a user visits the demoblaze webpage
    When visit and adds a product from each category
    Then the system response is successful for each product added

  @ShoppingCart
  Scenario: Shopping Cart
    Given a user visits the webpage
    When add some products to the cart
    And goes to cart option
    Then the cart displays each product added correctly

  @CheckoutFlow
  Scenario: Checkout Flow
    Given a user visit the homepage
    When add a product to the cart
    And select Place Order option
    And fill all data fields
    And select Purchase
    Then the system response is successful
    And the credit card number in the confirmation popup is equal as the entered previously