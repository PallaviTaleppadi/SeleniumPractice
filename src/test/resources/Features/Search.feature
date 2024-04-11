Feature: feature to launch google search and perform search operaation

  Scenario: Launch Google and search for input

    Given Launch google website
    When User search for "selenium"
    Then User select the right result
#    Then Correct page is opened