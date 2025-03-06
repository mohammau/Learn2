package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.accountPage;
import pageObject.landingPage;
import pageObject.loginPage;
import resources.Base;

public class LoginTest extends Base {
	
	
	public Logger log ;
	

	
	@BeforeMethod
	public void setUp() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());

		
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("URL"));
		log.debug("Navigated to application URL");

	}
	
	
	@Test(dataProvider = "dataP")
	public void login(String UserName, String Password, String Status) throws IOException, InterruptedException {
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		landingPage lp = new landingPage(driver);

        lp.MyAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");

        lp.LoginOption().click();
        log.debug("Clicked on login option");
        
        
        
        loginPage loginP = new loginPage(driver);
        
        loginP.emailAddressTextField().sendKeys(UserName);
        log.debug("Email addressed got entered");
        
        loginP.passwordField().sendKeys(Password);
        log.debug("Password got entered");
        
        loginP.loginButton().click();
        log.debug("Clicked on Login Button");
        
        accountPage accountP = new accountPage(driver); 
        
        String actualResult = null ;
        
       try { 
    	   
       if (accountP.editYourAccountInformation().isDisplayed());
		   log.debug("User got logged in");
       
       actualResult = "Success" ;
       
       
       } catch(Exception e) {
			log.debug("User didn't log in");

    actualResult = "Failure" ;
    	   
    	   
       }
       
       if(actualResult.equals(Status)) {
			
			log.info("Login Test got passed");
			
		}else {
			
			log.error("Login Test got failed");
		}

		 
	        
        }
	
	
		@AfterMethod
	    public void tearDown() {
	    driver.close();
	    log.debug("Browser got closed");
     
	}
		
		
		@DataProvider
		public Object[][] dataP() {
			
			Object[][] data = {{"mohammau67@gmail.com", "Demo1234", "Success"}, {"moum91@gmail.com", "Demo1234", "Failure"}};
			
			return data;
		}
		
		
		
		
		
		
		
	}
	
	


