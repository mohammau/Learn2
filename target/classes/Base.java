package resources;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.TakesScreenshot;

public class Base {
	
	public WebDriver driver = null ;
	
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		
		prop = new Properties();
		
		String propPath = System.getProperty("user.dir") + "//src//main//java//resources//data.properties" ;
		
		FileInputStream fis = new FileInputStream(propPath);
		
		prop.load(fis);
		
		String browser = prop.getProperty("browser") ;
		
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		if(browser.equalsIgnoreCase("edge")){
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/");
		
		//driver.quit();
		
		return driver;

		
	}
	
	public String screenshots(String testName, WebDriver driver) throws IOException {
		
	File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\"+ testName +".png";
	FileUtils.copyFile(sourceFile, new File(destinationFilePath));
	
	return destinationFilePath ;
	
	
	}
	

}
