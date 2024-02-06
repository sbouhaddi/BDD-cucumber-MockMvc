Feature: find all persons feature
  Scenario: user makes a GET request to /persons
    Given application is up
    When user makes a GET request to persons
    Then status code is 200
    And response body is a list of 2 persons