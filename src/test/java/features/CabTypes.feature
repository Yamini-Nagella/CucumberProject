Feature: Navigate to CabTypes Page

  @CabTypes
  Scenario Outline: Check the CabTypes available
    Given Open URL land in HomePage cabtypes
    Then Click on the Sitemap TextLink in footer
    Then Click on Cab types text link
    And Verify "<Title>" of Cab Type Page
    
    Examples: 
      | Title				|
      | Savaari - Cab Types | 
