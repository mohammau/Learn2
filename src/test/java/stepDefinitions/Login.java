package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.accountPage;
import pageObject.landingPage;
import pageObject.loginPage;
import resources.Base;
import tests.LoginTest;

public class Login extends Base {
	
	loginPage loginP;
	
	@Given("^Open any Browser$")
	public void Open_any_Browser() throws IOException {
		

		
		driver = initializeDriver();

		
	}

	@And("^Navigate to Login page$")
	public void Navigate_to_Login_page() {
		
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		landingPage lp = new landingPage(driver);

        lp.MyAccountDropdown().click();
        
        lp.LoginOption().click();

		
	}
	
	@When("^User enters username as \\\"([^\\\"]*)\\\" and password as \\\"([^\\\"]*)\\\" into the fields$")
	public void User_enters_username_as_something_and_password_as_something_into_the_ields(String UserName, String Password) {
		
		loginP = new loginPage(driver);
        
        loginP.emailAddressTextField().sendKeys(UserName);
        
        loginP.passwordField().sendKeys(Password);
      
		
	}
	
	@And("^User clicks on Login button$")
	public void User_clicks_login_button() {
		
		 loginP.loginButton().click();
		 
		
	}
	

	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login() {
		
        accountPage accountP = new accountPage(driver); 

		
		Assert.assertTrue(accountP.editYourAccountInformation().isDisplayed());
	}
	
	@After
	public void close() {
		
		driver.close();
	}
}
