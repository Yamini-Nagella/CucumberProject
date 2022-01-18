Feature: Booking Local Cars
  @LocalCars
  Scenario Outline: Booking Local cars
    Given Open URL land in HomePage localcars
    Then Click on the LocalTab
    Then Enter "<City>" in city field for local cars
    Then Enter "<month>" and "<day>" and "<time>" local car
    Then click on select car button to select local car
    And Verify the local car page by "<cityname>" and "<date>"
    
    Examples: 
      | City            	 |	month		|	day	|	time	|	cityname	|	date		|
      | Bangalore, Karnataka |	January2022	|	23	|	2:30 PM	|	Bangalore	|	23-01-2022	|
