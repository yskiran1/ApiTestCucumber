Feature: Quotes backend functionality tests

#  Scenario: Verify testing of quotes end point
#    Given user sets "https://api.quotable.io" url
#    When user hits GET "/random" endpoint
#    Then user should see "200" response

  Scenario Outline: Verify testing of quotes end point
    Given user sets "https://api.quotable.io" url
    When user hits GET "<endPoint>" endpoint
    Then user should see "<responseCode>" response

    Examples:
      | endPoint                              | responseCode |
      | /random                               | 200          |
      | /quotes?page=1                        | 200          |
      | /quotes?page=2                        | 200          |
      | /quotes?tags=love\|happiness          | 200          |
      | /quotes?tags=technology,famous-quotes | 200          |
      | /quotes?author=albert-einstein        | 200          |

