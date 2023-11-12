@Smoke
  Feature: F05_hoverCategories | The user able to hover on main categories

    Scenario:
      When user hover on main categories and select random category
      Then user directed to the selected category

    Scenario: Hovering causes unintended effects on the page
      When  user accidentally hovers over the categories
      Then unintended effects should occur on the page