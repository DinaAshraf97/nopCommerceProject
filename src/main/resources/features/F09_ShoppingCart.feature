@Smoke
Feature: F09_ShoppingCart | The user can use the functionality of adding products to cart successfully

  Scenario Outline: Add to cart button is clickable
    When user click on Add to cart button for element <0>
    Then success notification appeared
    Examples:
      | 0 |
#      | 1 |
#      | 2 |
      | 3 |
      | 4 |

  Scenario: Shopping cart is Empty when no item added
    Given user go to shopping cart page
    Then massage "Your Shopping Cart is empty!" appears on page

  Scenario: product added successfully to the shopping cart
    When user click on Add to cart button for element 3
    And user close notification bar
    Then item added to the shopping cart

  Scenario: User click on Add to cart button for a product multiple times
    When User click on Add to cart button three times on the same element 3
    And user close notification bar
    Then item quantity increased in shopping cart

  Scenario: remove item from shopping cart page
    When user click on Add to cart button for element 3
    And user close notification bar
    And user go to shopping cart page
    And user click on x sign
    Then item removed from shopping cart

