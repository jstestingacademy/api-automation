package stepdefinition;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.ExtentReportManager;
import utilities.RestassuredUtlities;
import utilities.ValidationUtlties;

public class poststeps {

	RestassuredUtlities restutil;
	ValidationUtlties validutil;
	
	@Given("Enter the Baseuri and resource")
	public void enter_the_baseuri_and_resource() {
		restutil =new RestassuredUtlities();
		validutil =new ValidationUtlties();
	}

	@Given("Enter the post request body with {string}, {string} ,{string}")
	public void enter_the_post_request_body_with(String title, String body, String author) throws FileNotFoundException {
	    restutil.postrequest(title, body, author);
	}

	@When("Validate the response")
	public void validate_the_response() {
		validutil.statuscodeValidation();
		
	}
}
