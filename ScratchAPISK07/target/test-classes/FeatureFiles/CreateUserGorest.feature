@smoke

Feature: Create a new user in GoRest

  Scenario Outline: Validate creation of new User in GoRest
    Given user hit the gorest site with URI
    And user enters the authentication token
    And user passes the payload for request
    When user will submit the gorest site with "<endpoint>"
    Then validate that user is created and status code is "<status_code>"
    Then validate the payload in response body

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
