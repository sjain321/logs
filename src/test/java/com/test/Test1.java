package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.message.LoggerNameAwareMessage;


public class Test1 {

	WebDriver driver;
	//Logger log = Logger.getLogger(Test1.class);
	private static Logger Logger= LogManager.getLogger(Test1.class); 
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\workspace\\logs\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		String url= "https://freecrm.com/";
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	
	@Test
	public void verifyMainPageTitle() {
		Logger.info("Verificatrion of Page Title");
		String actualTitle = driver.getTitle();
		String expectedResult= "Free CRM #1 cloud software for any business large or small";
		Assert.assertEquals(actualTitle, expectedResult, "Title NOT MATCHED");
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
