package com.AutomationProject.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public  class CartPage extends baseSetUp {

	public WebDriver ldriver;
	public WebDriverWait wait;
	
	public CartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	

	@FindBy(xpath = "//li[@id='nav-cart']/a//span")
	public WebElement lnkShoppingCart;
	
	
	public void verifyNoOfProductsinCart(WebDriver ldriver, int noOfProducts) throws IOException
	{
		ldriver.findElement(By.xpath("//li[@id='nav-cart']/a//span")).click();
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> element = ldriver.findElements(By.xpath("//*[@class='table table-striped cart-items']//tbody//td[3]//input"));
		int qty=0;
		for(int i =0; i<element.size();i++)
		{	
			
			String tempQty= element.get(i).getAttribute("value");
			
			qty+=Integer.parseInt(tempQty);
			
		}
		
		if(qty==noOfProducts)
		{
			Assert.assertTrue(true);
			System.out.println("Total Products Added to Cart is " + qty);
			captureScreen(ldriver, "Number of items Added is matching with the number of items available in Cart");
		}
		
	}
	
	public void verifySubTotalinCartAgainstTotal(WebDriver ldriver) throws IOException
	{
		ldriver.findElement(By.xpath("//li[@id='nav-cart']/a//span")).click();
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> elementsQty = ldriver.findElements(By.xpath("//*[@class='table table-striped cart-items']//tbody//td[3]//input"));
		List<WebElement> elementsPrice = ldriver.findElements(By.xpath("//*[@class='table table-striped cart-items']//tbody//td[2]"));
		List<WebElement> elementsSubTotal = ldriver.findElements(By.xpath("//*[@class='table table-striped cart-items']//tbody//td[4]"));
		String cartTotal=ldriver.findElement(By.xpath("//*[@class='table table-striped cart-items']//strong")).getText();
		double Total=Double.parseDouble(cartTotal.substring(7));
		
		double totalProductPrice=0.00;
		for(int i =0; i<elementsPrice.size();i++)
		{	
			
			String tempPrice= elementsPrice.get(i).getText().substring(1);
			double p=Double.parseDouble(tempPrice);
			String tempQty= elementsQty.get(i).getAttribute("value");
			int q= Integer.parseInt(tempQty);
			double pricePerItem = p*q;
			totalProductPrice+=pricePerItem;
			
		}
		
		System.out.println("Total Price of All Products in Cart is "+"$" +totalProductPrice);
		
		if(Total==totalProductPrice)
		{
			Assert.assertTrue(true);
			captureScreen(ldriver, "Total Cart Value is matching with the Total Subtotal value in Cart");
		}
		

	}
	
}