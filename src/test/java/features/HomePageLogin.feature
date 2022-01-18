Feature: Login to Website

  @Login
  Scenario Outline: Login as a excisting user
    Given Open URL land in HomePage login
    Then Click on signin button to login
    Then Enter "<email>" and "<password>" to login
    Then Click on login button
    And Verify "<user>" login 
    
    Examples: 
      | email             |	password	|	user	|
      | ynn@gmail.com	  | password	|	Ynn		|
