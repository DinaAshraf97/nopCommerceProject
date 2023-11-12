@Smoke
Feature: F02_Login | users could use login functionality to use their accounts

  Background:
    Given user go to login page

  Scenario: user could login with registered email and right password
    When user login with "test6@example.com" and "P@ssw0rd"
    And user press on login button
    Then user login to the system successfully

  Scenario: user couldn't login with unregistered email
    When user login with "wrong@example.com" and "P@ssw0rd"
    And user press on login button
    Then user could not login to the system
    And error massage contains "No customer account found" appeared

  Scenario: user couldn't login with empty password
    When user login with "wrong@example.com" and ""
    And user press on login button
    Then error massage contains "No customer account found" appeared

  Scenario: user couldn't login with wrong password
    When user login with "test6@example.com" and "P@ssword"
    And user press on login button
    Then user could not login to the system
    And error massage contains "The credentials provided are incorrect" appeared


  Scenario: user couldn't login with empty email
    When user login with "" and "P@ssw0rd"
    And user press on login button
    Then error massage "Please enter your email" appeared under email field

  Scenario: user couldn't login with invalid email
    When user login with "wrong.com" and "P@ssw0rd"
    And user press on login button
    Then error massage "Wrong email" appeared under email field
