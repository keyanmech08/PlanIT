package com.AutomationProject.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationProject.tests.baseSetUp;

public class ShopPage extends baseSetUp  {

	public WebDriver ldriver;
	public WebDriverWait wait;
	
	public ShopPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//li[@id='nav-cart']/a//span")
	public WebElement lnkShoppingCart;
	
	
	public void buyProducts(WebDriver ldriver, String ProductName, int noOfProducts) throws IOException
	{
		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = ldriver.findElement(By.xpath("//*[contains(text(),'"+ProductName+"')]/..//p//a"));
		wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		for(int i =1; i<= noOfProducts ; i++)
		{
			ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			element.click();
			String noOfProductsinCart=ldriver.findElement(By.xpath("//li[@id='nav-cart']/a//span")).getText();
			int noOfItems=Integer.parseInt(noOfProductsinCart);
			if(noOfItems==i)
			{
				Assert.assertTrue(true);
				captureScreen(ldriver, "Items Added are available in Cart");
			}
			
		}	
		
	}
	
	
}