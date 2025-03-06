package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import junit.framework.Assert;
import resources.Base;

public class TestFour extends Base {
	
	
	public WebDriver driver;
	@Test
	public void Fourt() throws IOException, InterruptedException{
		
	  System.out.println("Test Four printed");
	  System.out.println("Changes made from github repo in order to pull to local");
	
	  System.out.println("Changes made from local nbranch1 repo in order to push to GitHub");

	  
	 driver =  initializeDriver();
	 
	 driver.get(prop.getProperty("URL"));
	 
	 Thread.sleep(2000);
	  
	  
	  
	  Assert.assertTrue(false);
	
	}
	
	@AfterMethod
	public void close() {
		
		driver.quit();
	}
}
