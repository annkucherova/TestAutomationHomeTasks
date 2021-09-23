Feature: Search and filter
  As a user
  I want to test search and filter functionality of the site
  So that I can be sure that sites main functionality works correctly

  Scenario Outline: Check search results
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<correctKeyword>'
    And User clicks search button
    Then User check that search results contain expected keyword '<expectedKeyword>'

    Examples:
      | homePage                    | correctKeyword | expectedKeyword |
      | https://www.asos.com/women/ | puma           | Puma            |


  Scenario Outline: Check search result message
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<incorrectKeyword>'
    And User clicks search button
    Then User checks that search page contains message '<expectedResultMessage>'

    Examples:
      | homePage                    | incorrectKeyword | expectedResultMessage       |
      | https://www.asos.com/women/ | spoon            | NOTHING MATCHES YOUR SEARCH |


  Scenario Outline: Check filter functionality
    Given User opens '<homePage>' page
    And User clicks on 'Trainers' button
    When User clicks on 'Brand' filter button
    And User checks search brand field visibility
    And User enters brand keyword '<keyword>'
    And User clicks on brand button
    And User clicks on 'Brand' filter button
    Then User checks that every product contains word '<expectedWord>'

    Examples:
      | homePage                    | keyword | expectedWord |
      | https://www.asos.com/women/ | nike    | Nike         |


  Scenario Outline: Check discount filter
    Given User opens '<homePage>' page
    And User clicks on 'Trainers' button
    And User clicks on 'Brand' filter button
    And User checks search brand field visibility
    And User enters brand keyword '<keyword>'
    And User clicks on brand button
    And User clicks on 'Brand' filter button
    When User clicks on Sale filter button
    And User clicks on Sale button
    When User clicks on Sale filter button
    Then User checks that every product contains discount '<discount>'

    Examples:
      | homePage                    | keyword | discount |
      | https://www.asos.com/women/ | nike    | %        |