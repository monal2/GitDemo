package Academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	// Creating local driver so when running test in parallel it will not fail
	public WebDriver driver;
    
	// For logging mechanism (log4j)
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	
	// Declare globally so it can be access anywhere in class and scope is extended
	LandingPage l;
	
	@BeforeTest
	public void initialize() throws IOException {
		// initializeDriver() method return driver
		// So initializeDriver() takes care of all initialization like setting up
		// WebDriver
		driver = initializeDriver();
		Log.info("Driver is initialized");
		// We use the properties file to get our URL instead of hardcoding
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home page");
	}
	
	@Test
	public void validateAppTitle() throws IOException {
		// 2 way to access methods of another class
		// 1 is inheritance and 2 creating object of that class and invoke methods of it
		l = new LandingPage(driver);
		// requirement is to compare the test from the browser with actual value text 
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED C12562OURSES");
		Log.info("Successfully validated Text message");
	}
	
	// Test belongs to same page
	@Test
	public void validateHeader() throws IOException {
		
		// l = new LandingPage(driver); we can skip this because it is already assigned in the above test
		// requirement is to compare the test from the browser with actual value text 
		AssertJUnit.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		Log.info("Successfully validated Text message");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}	
}
