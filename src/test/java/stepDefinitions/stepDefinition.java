package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPageCum;
import pageObjects.portalHomePage;
import resources.Base;

public class stepDefinition extends Base {
	
	// Creating local driver so when running test in parallel it will not fail
	public WebDriver driver;
	
	@Given("^Initialize the browse with chrome$")
    public void initialize_the_browse_with_chrome() throws Throwable {
		driver = initializeDriver();
    }

    @Given("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        driver.get(strArg1); // we don't need properties file
    }

    @Given("^Click on Login link in home page to land on secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		l.getLogin();
    }

    @Given("^Click on popup link in home page$")
    public void click_on_popup_link_in_home_page() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	if(l.getPopupSize() > 0) {
    		l.getPopup().click();
    	}
        l.getLogin();
    }
    
    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
    	///driver.get("https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1");
    	Thread.sleep(2000);
    	LoginPageCum lp = new LoginPageCum(driver);
    	lp.getEmailCucum().sendKeys(strArg1);
		lp.getPasswordCucum().sendKeys(strArg2);
//    	driver.findElement(By.cssSelector("//input[@id='email']")).sendKeys(strArg1);
//    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(strArg2);
//    	driver.findElement(By.xpath("//input[@name='commit']")).click();
		lp.getLoginCucum().click();
    }
    
    // New for Parameterization
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPageCum lp = new LoginPageCum(driver);
    	lp.getEmailCucum().sendKeys(username);
		lp.getPasswordCucum().sendKeys(password);
		lp.getLoginCucum().click();
    }

    @Then("^Verify that user is successful logged in$")
    public void verify_that_user_is_successful_logged_in() throws Throwable {
    	portalHomePage p = new portalHomePage(driver);
    	Assert.assertTrue(p.getSearchBox().isDisplayed());
    	System.out.println("Search Box Validated");
    }
    
    @And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

}
