package com.AutomationProject.tests;
import java.io.IOException;

import org.testng.annotations.Test;
import com.AutomationProject.pageObjects.CartPage;
import com.AutomationProject.pageObjects.Contacts;
import com.AutomationProject.pageObjects.HomePage;
import com.AutomationProject.pageObjects.ShopPage;
import com.AutomationProject.utilities.reusableFunctions;

public class TestCases extends baseSetUp {
	
	@Test 
	public void TC001_ValidateErrorsOnContactScreen() throws IOException
	{
		reusableFunctions rf = new reusableFunctions();
		HomePage hm = new HomePage(driver);
		Contacts cn = new Contacts(driver);
		rf.click(driver,hm.lnkContact);
		logger.info("Landing to Contact Screen");
		rf.click(driver,cn.btnSubmit);
		rf.validateElementText(driver, cn.txtHeaderError, "Forename is required");
		rf.validateElementText(driver, cn.txtHeaderError, "Email is required");
		rf.validateElementText(driver, cn.txtHeaderError, "Message is required");
		rf.validateElementText(driver, cn.txtHeaderError, "We welcome your feedback - but we won't get it unless you complete the form correctly.");
		logger.info("Verified All the error messages for Mandatory Fields");
		rf.enterText(driver, cn.inputForeName, "Karthik");
		rf.enterText(driver, cn.inputEmail, "Karthik@test.com");
		rf.enterText(driver, cn.inputMessage, "Test Message");
		rf.click(driver, cn.btnSubmit);
		rf.validateElementNotDisplayed(driver, cn.txtHeaderError);
		logger.info("Verified that the error messages are not displayed After entering the required details");
	}
	
	@Test (invocationCount = 5)
	public void TC002_ValidateSubmissionMessage() throws IOException
	{
		reusableFunctions rf = new reusableFunctions();
		HomePage hm = new HomePage(driver);
		Contacts cn = new Contacts(driver);
		rf.click(driver,hm.lnkContact);
		rf.enterText(driver, cn.inputForeName, "Karthik");
		rf.enterText(driver, cn.inputEmail, "Karthik@test.com");
		rf.enterText(driver, cn.inputMessage, "Test Message");
		rf.click(driver, cn.btnSubmit);
		rf.validateElementText(driver, cn.txtSuccessMsg, "Thanks test , we appreciate your feedback.");
		logger.info("Verified that the Submission message is displayed");
	}
	
	@Test
	public void TC003_ValidatebuyProductsAndCountAtCart() throws IOException
	{
		reusableFunctions rf = new reusableFunctions();
		HomePage hm = new HomePage(driver);
		ShopPage sp = new ShopPage(driver);
		CartPage cp = new CartPage(driver);
		rf.click(driver,hm.btnStartShopping);
		sp.buyProducts(driver, "Funny Cow", 2);
		sp.buyProducts(driver, "Fluffy Bunny", 1);
		cp.verifyNoOfProductsinCart(driver, 3);
		logger.info("Verified the Total Number of Products Added into cart");
		
	}
	
	@Test
	public void TC004_ValidateSubTotalAndTotal() throws IOException
	{
		reusableFunctions rf = new reusableFunctions();
		HomePage hm = new HomePage(driver);
		ShopPage sp = new ShopPage(driver);
		CartPage cp = new CartPage(driver);
		rf.click(driver,hm.btnStartShopping);
		sp.buyProducts(driver, "Stuffed Frog", 2);
		sp.buyProducts(driver, "Fluffy Bunny", 5);
		sp.buyProducts(driver, "Valentine Bear", 3);
		cp.verifySubTotalinCartAgainstTotal(driver);
		logger.info("Verified the OverAll Total Amount is matching with the OverAll SubTotal Amount of Products in cart");
		
	}
	
	
	
	
}
