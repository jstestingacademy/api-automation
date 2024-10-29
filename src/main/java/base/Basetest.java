package base;

import io.restassured.RestAssured;

public class Basetest {

	public static String setup() {
		return RestAssured.baseURI= Configmanager.getProperty("baseURI");
		
	}
}
