package stepdefinition;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.RestassuredUtlities;
import utilities.ValidationUtlties;

public class putsteps {

	RestassuredUtlities restutil;
	ValidationUtlties validutil;
	@Given("Enter the BaseURI and  the resource")
	public void enter_the_base_uri_and_the_resource() {
		restutil =new RestassuredUtlities();
		validutil =new ValidationUtlties();
	}

	@Given("Enter the put request body with {string}, {string} ,{string}")
	public void enter_the_put_request_body_with(String title, String body, String author) throws FileNotFoundException {
		restutil.putrequest(title, body, author);
	}

	@When("Validate the Response")
	public void validate_the_response() {
		validutil.statuscodeValidation();
		validutil.headerValidation();
		
	}



}
