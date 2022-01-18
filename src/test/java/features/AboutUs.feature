Feature: Navigate to AboutUs Page

  @AboutUs
  Scenario Outline: Validate about us page
    Given Open URL land in HomePage
    Then Click on the Aboutus TextLink in footer
    And Verify "<CEO>" of Savaari Rental Cars
    
    Examples: 
      | CEO             |
      | Gaurav Aggarwal | 
