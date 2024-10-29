package utilities;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import base.Basetest;
import base.Payloads;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
public class RestassuredUtlities {



	
	PrintStream log;
	public void postrequest(String title, String body, String author) throws FileNotFoundException {
		 log =new PrintStream(new File("src/test/resources/log/postlog.txt"));
		 
		
		 given().baseUri(Basetest.setup())
		 .filter(RequestLoggingFilter.logRequestTo(log))
		 .filter(ResponseLoggingFilter.logResponseTo(log))
		 .when()
		 .body(Payloads.Requestbody(title, body, author))
		 .post(Resource.postResource.getResource())
		 .then()
		 .extract()
		 .response();
				
		  
	}
	
	public void getrequest() throws FileNotFoundException {
		 log =new PrintStream(new File("src/test/resources/log/getlog.txt"));
		 
		
		 given().baseUri(Basetest.setup())
		 .filter(ResponseLoggingFilter.logResponseTo(log))
		 .when()
		 .get(Resource.getResource.getResource())
		 .then()
		 .extract()
		 .response();
				
		  
	}
	
	public void putrequest(String title, String body, String author) throws FileNotFoundException {
		 log =new PrintStream(new File("src/test/resources/log/putlog.txt"));
		
		 given().baseUri(Basetest.setup())
		 .filter(RequestLoggingFilter.logRequestTo(log))
		 .filter(ResponseLoggingFilter.logResponseTo(log))
		 .when()
		 .body(Payloads.Requestbody(title, body, author))
		 .put(Resource.putResource.getResource())
		 .then()
		 .extract()
		 .response();
		 
		  
	}
	
	public void deleteRequest(String title, String body, String author) throws FileNotFoundException {
		
		 log =new PrintStream(new File("src/test/resources/log/deletelog.txt"));
		given().baseUri(Basetest.setup())
		.filter(RequestLoggingFilter.logRequestTo(log))
		 .filter(ResponseLoggingFilter.logResponseTo(log))
		 .when()
		 .body(Payloads.Requestbody(title, body, author))
		 .delete(Resource.deleteResource.getResource())
		 .then()
		 .extract()
		 .response();
	}
	
	
	
}
