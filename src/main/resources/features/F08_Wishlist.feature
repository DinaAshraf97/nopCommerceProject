@Smoke
Feature: F08_Wishlist | The user can use the functionality of adding products to wishlist successfully

  Scenario Outline: wish button is clickable
    When user clicks on wish button for element <0>
    Then success notification displayed
    Examples:
      | 0 |
#      | 1 |
#      | 2 |
      | 3 |
      | 4 |

  Scenario: Wishlist is Empty when no item added
    Given user go to wishlist page
    Then "The wishlist is empty!" massage appears on page

  Scenario: product added successfully to the wishlist
    When user clicks on wish button for element 3
    And user close success notification bar
    And user go to wishlist page
    Then item added to the wishlist

  Scenario: User re-click on wish button to remove item from wishlist
    When user clicks on wish button for element 3
    And User re-click on wish button for the same element 3
    And user close success notification bar
    Then item removed from wishlist

  Scenario: remove item from wishlist page
    When user clicks on wish button for element 3
    And user close success notification bar
    And user go to wishlist page
    And user clicks on x sign
    Then item removed from wishlist

