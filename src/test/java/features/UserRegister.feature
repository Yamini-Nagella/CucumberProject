Feature: Registering as a new user
  @UserRegister
  Scenario Outline: Register as a new user
    Given Open URL land in savaari HomePage
    Then Click on signin button to register
    Then Click on the Register button to register as a new user
    Then Enter "<Name>", "<Mobile>", "<Email>", "<password>", "<cpassword>" in form
    Then click on register
    And Verify the page by "<Name>"
    
    Examples: 
      | Name            	 |	Mobile		|	Email			|	password	|	cpassword	|
      |NV					 |	1234567892	|	nv224@gmail.com	|	password	|	password	|
