package Academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	
	// Creating local driver so when running test in parallel it will not fail
	public WebDriver driver;
	
	// For logging mechanism (log4j)
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		// initializeDriver() method return driver
		// So initializeDriver() takes care of all initialization like setting up
		// WebDriver
		driver = initializeDriver();
		// We use the properties file to get our URL instead of hardcoding
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateNavigationBar() throws IOException {
		// 2 way to access methods of another class
		// 1 is inheritance and 2 creating object of that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		// Putting validation to get the boolean true or false based on some value is
		// displayed in the browser or not
		AssertJUnit.assertTrue(l.getNavigationBar().isDisplayed());
		// Assert.assertFalse(false); // vice versa
		Log.info("Navigation Bar is displayed");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
