Feature: Booking One way Cars
  @OneWay
  Scenario Outline: Select one way cars and verify the page
    Given Open URL land in HomePage oneway
    Then Enter "<Source>" in from field oneway
    Then Enter "<Destination>" in to field oneway
    Then Enter "<month>" and "<day>", "<time>" for oneway
    Then click on select car button to select cars for oneway
    And Verify the oneway cars page by "<cityname>" and "<date>"
    
    Examples: 
      | Source            	 |	Destination			|	month		|	day	|	time	|	cityname	|	date		|
      | Bangalore, Karnataka |	Chennai, Tamil Nadu	|	January2022	|	24	|	2:30 PM	|	Bangalore	|	24-01-2022	|
