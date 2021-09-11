package com.AutomationProject.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.AutomationProject.tests.baseSetUp;

public class reusableFunctions extends baseSetUp {

	public WebDriver ldriver;
	public WebDriverWait wait;
	
	public void click(WebDriver ldriver,WebElement element)
	{
		wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void validateElementText(WebDriver ldriver,WebElement element, String expectedErrorText) throws IOException
	{
		wait = new WebDriverWait(ldriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actText=element.getText();
		if(actText.equalsIgnoreCase(expectedErrorText))
		{
			
			Assert.assertTrue(true);
			captureScreen(ldriver, "Actual Text is Matching with Expected Text");
		}

	}
	
	public void validateElementNotDisplayed(WebDriver ldriver,WebElement element) throws IOException
	{
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(!element.isDisplayed())
		{
			Assert.assertTrue(true);
			captureScreen(ldriver, "Element is Not Displayed");
		}
		
	} 
	
	public void enterText(WebDriver ldriver,WebElement element, String textToBeEntered)
	{
		wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(textToBeEntered);
	} 
	
}
