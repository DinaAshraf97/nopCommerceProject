@Smoke
Feature: F07_followUs | The user able to open follow us links

  Scenario: user opens facebook link
  When user clicks on facebook icon
  Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
  When user clicks on twitter icon
  Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
  When user clicks on rss icon
  Then "https://demo.nopcommerce.com/new-online-store" is opened in new tab

  Scenario: user opens youtube link
  When user clicks on youtube icon
  Then "https://www.youtube.com/user/nopCommerce" is opened in new tab



