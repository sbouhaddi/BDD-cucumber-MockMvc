Feature: find a person by id
  Scenario: user makes a GET request to /api/v1/persons/{id}
    Given application is up
    When user makes a GET request to find person with id 1
    Then status code is 200
    And validate response body content

