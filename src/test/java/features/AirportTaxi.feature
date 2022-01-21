Feature: Booking Airport Taxi
  @AirportTaxi
  Scenario Outline: Booking Taxi to Airport
    Given Open URL land in HomePage AirportTaxi
    Then Click on the Airport tab
    Then Enter "<City>" in city field
    Then select Trip type
    Then Enter "<address>", "<month>" and "<day>", "<time>"
    Then click on select car button
    And Verify the page by "<cityname>" and "<date>"
    
    Examples: 
      | City            	 |	address			   |	month		|	day	|	time	|	cityname	| date			|
      | Bangalore, Karnataka | Bangalore, Karnataka|	January2022	|	24	|	2:30 PM	|	Bangalore	| 24-01-2022	|
