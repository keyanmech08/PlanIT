package com.AutomationProject.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class baseSetUp {
	
public static WebDriver driver;
public static Logger logger;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		String usrDir = System.getProperty("user.dir");
		logger = Logger.getLogger("AutomationProject");
		PropertyConfigurator.configure("log4j.properties");
		Properties prop = new Properties();
		FileInputStream fileInput = new FileInputStream(usrDir+"\\Resources\\GeneralProperties.properties");
		prop.load(fileInput);
		
        String BrowserName= prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", usrDir+"\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", usrDir+"\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",  usrDir+"\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void wrapUp()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	

}
