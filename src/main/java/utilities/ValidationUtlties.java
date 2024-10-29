package utilities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import base.Basetest;

public class ValidationUtlties {
	
	public void statuscodeValidation() {
		
		 given().baseUri(Basetest.setup())
		 .when()
		 .get(Resource.getResource.getResource())
		 .then()
		 .statusCode(200);
		 
				
		  
	}
	
	public void headerValidation() {
		
		 given().baseUri(Basetest.setup())
		 .when()
		 .get(Resource.getResource.getResource())
		 .then()
		 .statusCode(200)
		 .header("content-type", equalTo("application/json; charset=UTF-8"));
		 
				
		  
	}
	public void ResponseBodyValidation() {
		
		 given().baseUri(Basetest.setup())
		 .when()
		 .get(Resource.getResource.getResource())
		 .then()
		 .statusCode(200)
		 .header("Content-Type", equalTo("application/json; charset=utf-8"))
		 .body("title", equalTo("Testing"))        
	     .body("body", equalTo("Rest assured"));
		 
				
		  
	}
}
