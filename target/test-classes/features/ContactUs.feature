Feature: Navigate to ContactUs Page

  @ContactUs
  Scenario Outline: Validate Contact Us page
    Given Open URL land in HomePage contactus
    Then Click on the ContactUs TextLink in footer
    And Verify "<Title>" of Contact Us
    
    Examples: 
      | Title            |
      | Contact Us		 | 
