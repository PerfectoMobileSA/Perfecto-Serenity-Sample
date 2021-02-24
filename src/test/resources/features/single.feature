Feature: Google's Search Functionality

@googleSearch @testTag1
Scenario: Can find search results
    When I type query as "Perfecto Mobile"
    And I submit
    Then I should see title "Perfecto Mobile - Google Search"

@googleSearch @testTag2
Scenario: Can find search results 2
    When I type query as "Perfecto Mobile"
    And I submit
    Then I should see title "Perfecto Mobile - Google Search"
    