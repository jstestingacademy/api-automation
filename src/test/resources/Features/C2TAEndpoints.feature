

Feature: To Validate the C2TA API Endpoints

  @tag1
  Scenario Outline: To Validate the post request
    Given Enter the Baseuri and resource
    And Enter the post request body with "<title>", "<body>" ,"<author>"
    When Validate the response
    
   Examples:
   |title|body|author|
   |API|restassured|JStestingacademy|
   
   
   @tag2
  Scenario: To Validate the get request
    Given Enter  baseuri and resource
    And Enter the get request
    When Validate  response
    
    
    @tag3
  Scenario Outline: To Validate the put request
    Given Enter the BaseURI and  the resource
    And Enter the put request body with "<title>", "<body>" ,"<author>"
    When Validate the Response
    
   Examples:
   |title|body|author|
   |API|rest|academy|
    
    
    
   
    
    

