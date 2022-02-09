package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page Object
public class LoginPage {
	
	public WebDriver driver;
	
	private By email = By.cssSelector("[id='user_email']");
	private By password = By.cssSelector("[type='password']");
	private By login = By.cssSelector("[value='Log In']");
	private By forgotPassword = By.cssSelector("[href*='password/new']");
	
	
	//----Cucumber---
	private By email1 = By.cssSelector("//input[@id='email']");
	private By password1 = By.xpath("//input[@id='password']");
	private By commit = By.xpath("//input[@name='commit']");
	
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
	
	
	//---Cucumber---
	public WebElement getEmailCucum() {
		return driver.findElement(email1);
	}
	
	public WebElement getPasswordCucum() {
		return driver.findElement(password1);
	}
	
	public WebElement getLoginCucum() {
		return driver.findElement(commit);
	}
	
}
