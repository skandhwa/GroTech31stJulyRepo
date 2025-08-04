@sanity

Feature: Creation of New User Data

  Scenario Outline: Creation of New User
    Given user opens the application 
    When user enters the payload
    And user submits a new request with an "<endpoint>"
    Then validate that user is created and status code is "<status_code>"

    Examples: 
      | endpoint  | status_code |
      | api/users |         201 |
