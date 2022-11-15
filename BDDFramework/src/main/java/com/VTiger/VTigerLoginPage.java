package com.VTiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerLoginPage extends SeleniumUtility
{
	WebDriver driver;
	
	public VTigerLoginPage(WebDriver driver)    //  Parameterized Constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);   // this is refers to corrent class object  
	}
	
	@FindBy(id="username")
	private WebElement userNameInputField;
	
	@FindBy(id="password")
	private WebElement passwordInputField;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInBtn;
	
	public void login(String username, String pwd)
	{
		typeInput(userNameInputField, username);
		typeInput(passwordInputField, pwd);
	}
	
	public void clickLoginBtn()
	{
		clickOnElement(signInBtn);
	}

}
