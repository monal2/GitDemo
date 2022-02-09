package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
	// https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1
	// https://courses.rahulshettyacademy.com/
	public WebDriver driver;

	private By searchBox = By.name("query");

	// Constructor
	public portalHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}
}
