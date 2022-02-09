package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page Object
public class LoginPageCum {

	public WebDriver driver;

	private By login = By.cssSelector("[value='Log In']");

	// ----Cucumber---
	private By email1 = By.xpath(".//input[@id='email']");
	private By password1 = By.xpath(".//input[@id='password']");
	private By commit = By.xpath(".//input[@name='commit']");

	// Constructor
	public LoginPageCum(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	// ---Cucumber---
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
