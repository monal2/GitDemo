package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	// Always define driver object in a global level variable
	// public  static WebDriver driver; // was having issues
	public  WebDriver driver;
	// Declare properties global so other test cases can use it
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		// This function be used by all our test cases
		// If chrome invoke or firefox then invoke etc

		//System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");

		// we will use properties file to import data
		prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser"); // for data.properties
		// mvn test -Dbrowser=chrome
		//String browserName = System.getProperty("browser"); // Code will check from
		// Maven command

		System.out.println("BN: " + browserName);
//		System.out.println("---------");
//		System.out.println(prop.getProperty("browser"));
//		System.out.println(prop.getProperty("url"));

		// Since we are extracting value from properties file we use .equals(" ") method
		// == is a reference comparision i.e both objects point to the same memory
		// location
		// .equals() evaluates to the comparision of values in the object
		if (browserName.contains("chrome")) {
			System.out.println("Browser is: " + browserName);
			// execute in chrome driver
			// System.setProperty("webdriver.chrome.driver", "/Users/monalmodha/Documents/Udemy_Selenium_Java/chromedriver/chromedriver");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
			
			// For Headless mode create ChromeOptions class
			ChromeOptions options = new ChromeOptions();
						
			if(browserName.contains("headless")) {
				System.out.println("Running in Chrome Headless");
				options.addArguments("headless"); // This to say run in headless 
			}
			driver = new ChromeDriver(options);
			
		} else if (browserName.equals("firefox")) {
			// execute in firefox
			System.out.println("Browser is: " + browserName);
			//System.setProperty("webdriver.gecko.driver", "//Users//monalmodha//Documents//Udemy_Selenium_Java//geckodriver//geckodriver");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.out.println("Browser is: " + browserName);
			// execute in IE
		} 

		// Set timeouts using Selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	// Screen shots
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
