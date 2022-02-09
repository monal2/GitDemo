package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	// This method is responsible to complete all configuration what we did initially
	public static ExtentReports getReportObject() {
		
		// Get project path 
					String path = System.getProperty("user.dir")+"//reports/index.html";
					
					// config for extent reports, reporter object created and holds some details
					// 2 classes ExtentReports and ExtentSparksReporter helpful to generate reports
					// First we create objects of the above classes and then we see how to connect these 2 classes together in building the reports
					ExtentSparkReporter reporter = new ExtentSparkReporter(path);
					reporter.config().setReportName("Web Automation Results");
					reporter.config().setDocumentTitle("Test Results");
					
					// Create another class object ExentReports which is a main class
					// its is responsible to drive all your reporting execution
					extent = new ExtentReports();
					extent.attachReporter(reporter);
					extent.setSystemInfo("Tester", "Monal");
					return extent;
	}
}
