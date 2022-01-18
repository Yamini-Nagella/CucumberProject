Feature: Booking RoundTrip Cars
  @RoundTrip
  Scenario Outline: Select RoundTrip cars and verify the page
    Given Open URL land in HomePage RoundTrip
    Then Click on the RoundTrip radio button
    Then Enter "<Source>" in from field Rountrip
    Then Enter "<Destination>" in to field RoundTrip
    Then Enter starting "<month1>" and "<day1>"
    Then Enter Return "<month2>" and "<day2>"
    Then Enter "<time>"
    Then click on select car button For RoundTrip
    And Verify the RoundTripCars page by "<cityname>" and "<date>"
    
    Examples: 
      | Source            	 |	Destination			|	month1		|	day1	|	time	|	cityname	|	date		|	month2		|	day2	|
      | Bangalore, Karnataka |	Chennai, Tamil Nadu	|	January2022	|	20		|	2:30 PM	|	Bangalore	|	20-01-2022	|	January2022	|	25		|
