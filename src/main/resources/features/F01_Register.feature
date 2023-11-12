@Smoke
Feature: F01_Register | users could register with new accounts

  Background:
    Given user go to register page

  Scenario: guest user could register with valid data successfully
    When user select gender type
    And user enter first name "automation" and last name "tester"
    And user enter date of birth
    And user enter valid email "test6@example.com"
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then user redirected to register result page and success message is displayed

  Scenario: guest user could register without select gender type or date of birth
    When user enter first name "automation" and last name "tester"
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then user redirected to register result page and success message is displayed

  Scenario: guest user couldn't register without enter first name
    When user select gender type
    And user leave first name empty and enter last name "tester"
    And user enter date of birth
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "First name is required." is displayed under first name field

  Scenario: guest user couldn't register with only numbers in first name
    When user select gender type
    And user enter first name 1234 and last name "tester"
    And user enter date of birth
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Wrong first name" is displayed under first name field

  Scenario: guest user couldn't register with special character in first name
    When user select gender type
    And user enter first name "@D" and last name "tester"
    And user enter date of birth
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Wrong first name" is displayed under first name field

  Scenario: guest user couldn't register without enter last name
    When user select gender type
    And user enter first name "tester" and leave last name empty
    And user enter date of birth
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Last name is required." is displayed under last name field

  Scenario: guest user couldn't register with only numbers in last name
    When user select gender type
    And user enter first name "tester" and last name 1234
    And user enter date of birth
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Wrong last name" is displayed under last name field

  Scenario: guest user couldn't register with special character in first name
    When user select gender type
    And user enter first name "@D" and last name "tester"
    And user enter date of birth
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Wrong last name" is displayed under last name field

  Scenario: guest user couldn't register without enter email
    When user enter first name "automation" and last name "tester"
    And user leave email field empty
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Email is required." is displayed under email field

  Scenario: guest user couldn't register with invalid email doesn't end with .com
    When user enter first name "automation" and last name "tester"
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Wrong email" is displayed under email field

  Scenario: guest user couldn't register with invalid email doesn't contain @ and domain
    When user enter first name "automation" and last name "tester"
    And user enter valid email
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then error message "Wrong email" is displayed under email field

  Scenario: guest user couldn't register without enter password
    When user enter first name "automation" and last name "tester"
    And user enter valid email
    And user leave Password fields Empty
    And user clicks on register button
    Then error message "Password is required." is displayed under password fields

  Scenario Outline: guest user couldn't register with invalid password
    When user enter first name "automation" and last name "tester"
    And user enter valid email
    And user fills Password fields "<invalid_pass>" "<invalid_pass>"
    And user clicks on register button
    Then error message contains "Password must meet the following rules" is displayed under password field

#    Password must not be less than 6 characters,must have at least 1 special character, 1 number, 1 capital case letter
    Examples:
      | invalid_pass |
      | P@ss0        |
      | Password1    |
      | P@ssword     |
      | p@ss111      |

  Scenario: guest user couldn't register with different in password and confirm password fields
    When user enter first name "automation" and last name "tester"
    And user enter valid email
    And user fills Password fields "P@ssw0rd22" "P@ssw0rd"
    And user clicks on register button
    Then error message "The password and confirmation password do not match." is displayed under confirm password field