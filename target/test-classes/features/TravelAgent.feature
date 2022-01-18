Feature: Navigate to Travel Agent Page

  @TravelAgent
  Scenario Outline: To register as a Travel Agent
    Given Open URL land in HomePage Travelagent
    Then Click on the Travel Agent button
    Then Click on the Register button in travelagent page
    And Verify "<page>" of Travel agent
    
    Examples: 
      | page             |
      | Register		 | 
