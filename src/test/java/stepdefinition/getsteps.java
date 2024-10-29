package stepdefinition;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.RestassuredUtlities;
import utilities.ValidationUtlties;

public class getsteps {

	RestassuredUtlities restutil;
	ValidationUtlties validutil;
	@Given("Enter  baseuri and resource")
	public void enter_baseuri_and_resource() {
		restutil =new RestassuredUtlities();
		validutil =new ValidationUtlties();
	}
	

	@Given("Enter the get request")
	public void enter_the_get_request() throws FileNotFoundException {
	    restutil.getrequest();
	}

	@When("Validate  response")
	public void validate_response() {
		validutil.statuscodeValidation();
	    
	}
}
