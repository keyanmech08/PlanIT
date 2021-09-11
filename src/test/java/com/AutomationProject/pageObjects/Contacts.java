package com.AutomationProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {

	public WebDriver ldriver;
	
	
	public Contacts(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn-contact btn btn-primary']")
	public WebElement btnSubmit;
	
	@FindBy(id = "forename-err")
	public WebElement txtForeNameError;
	
	@FindBy(id = "email-err")
	public WebElement txtEmailError;
	
	@FindBy(id = "message-err")
	public WebElement txtMessageError;
	
	@FindBy(id = "header-message")
	public WebElement txtHeaderError;
	
	@FindBy(id = "forename")
	public WebElement inputForeName;
	
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "message")
	public WebElement inputMessage;
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	public WebElement txtSuccessMsg;
	
	
	
	
}
