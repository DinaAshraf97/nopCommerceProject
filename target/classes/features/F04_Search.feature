@Smoke
  Feature: F04_Search | The user able to search
    Scenario Outline: user could search using product name
      When user write product name in the search box "<product>"
      And user press on search button
      Then search relevant results appears "<product>"

      Examples:
        |product|
        |book|
        |laptop|
        |nike|

    Scenario Outline: user could search for product using sku
      When user write sku in the search box "<sku>"
      And user press on search button
      And click on the product in search result
      Then exact result appears "<sku>"

      Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|

    Scenario Outline: user could search using category name
      When user write product name in the search box "<category>"
      And user press on search button
      Then search relevant results appears "<category>"

      Examples:
        |category|
        |Electronics|
        |Computers|
        |Cell phone|

    Scenario Outline: user couldn't find results when search for unavailable product
      When user write product name in the search box "<unavailable_product>"
      And user press on search button
      Then A massage "No products were found that matched your criteria." is displayed

      Examples:
        |unavailable_product|
        |bag|
        |headphone|
        |SCI_FAI|

    Scenario: user couldn't find product using invalid product name
      When user write product name in the search box "su"
      And user press on search button
      Then error massage "Search term minimum length is 3 characters" is displayed
