package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
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
		Log.info("Driver is initialized");
		// driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		// We use the properties file to get our URL instead of hardcoding
		// Because we are parameterizing so lets put url invocation here inside the
		// method
		driver.get(prop.getProperty("url"));
		// 2 way to access methods of another class
		// 1 is inheritance and 2 creating object of that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		LoginPage lp= l.getLogin(); // so you don't have to do this driver.findElement(By.css())
		//LoginPage lp = new LoginPage(driver); // Now no need taken care by getLogin method
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		//System.out.println(text);
		System.out.println("GitDemo 1");
		System.out.println("GitDemo 2");
		Log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run (2)
		// Cols stands fore how many values per test (3)
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non restricted User";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		
	}
}
