package testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner {
	
	@CucumberOptions(
		    features = "src/test/resources/Features",  // Path to feature files
		    glue = "stepdefinition",                 // Path to step definitions
		    plugin = {"pretty", "html:target/cucumber-reports.html"}
		)
		public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

		    

		    
		}

}
