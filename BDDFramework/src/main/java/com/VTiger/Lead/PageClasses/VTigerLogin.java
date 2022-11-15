package com.VTiger.Lead.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerLogin extends SeleniumUtility
{
	WebDriver driver;
	
	public VTigerLogin(WebDriver driver)    //  Parameterized Constructor
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
	
	@FindBy(css	="img[class='img-responsive user-logo']")
	private WebElement logo;
	
	@FindBy(css="a[class='forgotPasswordLink']")
	private WebElement forgotPwdLink;
	
	@FindBy(css="span[class='fa fa-user']")
	private WebElement profileBtn;
	
	@FindBy(id="menubar_item_right_LBL_SIGN_OUT")
	private WebElement signOutBtn;
	
	public void login(String username, String pwd)
	{
		typeInput(userNameInputField, username);
		typeInput(passwordInputField, pwd);
		clickOnElement(signInBtn);
	}
	
	public void logOut()
	{
		clickOnElement(profileBtn);
		clickOnElement(signOutBtn);
	}
	
}

//In page classes we define WebElement as private and we define public methods where we use those private element
//This is encapsulation concept of JAVA
