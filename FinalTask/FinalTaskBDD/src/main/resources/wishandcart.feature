Feature: Wish list and shopping cart
  As a user
  I want to test saving items to wish list and adding products to cart functionality
  So that I can be sure that main functions of the site works correctly

  Scenario Outline: Check add item to wish list
    Given User opens '<homePage>' page
    And User clicks on 'Trainers' button
    When User adds item to wish list by click on heart icon
    And User clicks on 'Saved Items' icon
    Then User checks that wish list has correct amount of items '<amountOfProducts>'

    Examples:
      | homePage                    | amountOfProducts |
      | https://www.asos.com/women/ | 1 item           |


  Scenario Outline: Check delete item from wish list
    Given User opens '<homePage>' page
    And User clicks on 'Trainers' button
    When User adds item to wish list by click on heart icon
    And User clicks on 'Saved Items' icon
    And User deletes item from wish list
    Then User checks that wish list has message '<expectedMessage>'

    Examples:
      | homePage                    | expectedMessage         |
      | https://www.asos.com/women/ | You have no Saved Items |


  Scenario Outline: Check warning message while adding item to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<correctKeyword>'
    And User clicks search button
    And User clicks on product
    When User clicks on Add to bag button
    Then User checks warning message '<expectedMessage>'

    Examples:
      | homePage                    | correctKeyword | expectedMessage                                          |
      | https://www.asos.com/women/ | puma           | Please select from the available colour and size options |


  Scenario Outline: Check add item to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<correctKeyword>'
    And User clicks search button
    And User clicks on product
    When User selects size of product
    And User clicks on Add to bag button
    Then User check that Cart Icon has correct amount of Products '<amountOfProductsInCart>'

    Examples:
      | homePage                    | correctKeyword | amountOfProductsInCart |
      | https://www.asos.com/women/ | puma           | 1                      |