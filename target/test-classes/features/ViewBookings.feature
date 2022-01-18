Feature: View Bookings 

  @ViewBookings
  Scenario Outline: Login as a excisting user and view Bookings
    Given Open URL land in HomePage to view
    Then Click on signin button to view
    Then Enter "<email>" and "<password>" as a user to view bookings
    Then Click on login button to view
    Then Click on the bookings textlink
    And Verify "<page>" ViewBookings
    
    Examples: 
      | email             |	password	|	page		|
      | ynn@gmail.com	  | password	|	Bookings	|