Feature: Authorization
  As a user
  I want to test authorization functionality
  So that I can be sure that I can log in to my personal account correctly

  Scenario Outline: Check not correct email address message
    Given User opens '<homePage>' page
    And User moves cursor on My account Icon
    And User clicks on My account button
    And User checks that username field is visible
    And User checks that password field is visible
    When User clicks on Username field
    And User enters email address '<email>'
    And User clicks on Password field
    Then User checks that appears message
    And User checks email warning message '<warning>'

    Examples:
      | homePage                    | email     | warning                                               |
      | https://www.asos.com/women/ | 1234email | Email fail! Please type in your correct email address |


  Scenario Outline: Check wrong input data message
    Given User opens '<homePage>' page
    And User moves cursor on My account Icon
    And User clicks on My account button
    And User checks that username field is visible
    And User checks that password field is visible
    When User clicks on Username field
    And User enters email address '<email>'
    And User clicks on Password field
    And User enters password '<password>'
    And User clicks on Sign In Button
    Then User checks that appears warning message
    Then User check that message contains warning '<warning>'

    Examples:
      | homePage                    | email             | password | warning                                       |
      | https://www.asos.com/women/ | 1234qwe@gmail.com | 12345qwe | your email address or password were incorrect |