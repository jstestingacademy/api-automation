package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ExtentReportManager {
	
	private static ExtentReports extent;
    private static ExtentTest test;
    public static void initReports() {
	if (extent == null) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
}

public static void createTest(String testName) {
    test = extent.createTest(testName);
}

public static void logInfo(String message) {
    if (test != null) {
        test.info(message);
    }
}

public static void logError(String message) {
    if (test != null) {
        test.fail(message);
    }
}

public static void logPass(String message) {
    if (test != null) {
        test.pass(message);
    }
}

public static void flushReports() {
    if (extent != null) {
        extent.flush(); // Ensure reports are written
    }
}
}
