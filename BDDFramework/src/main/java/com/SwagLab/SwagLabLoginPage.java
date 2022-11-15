package com.SwagLab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class SwagLabLoginPage extends SeleniumUtility
{
	WebDriver driver;
	public SwagLabLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	public void swagLabEnterUserNameAndPwd(String username, String pwd)
	{
		typeInput(usernameField, username);
		typeInput(passwordField, pwd);
	}
	
	public void swagLabClickOnLoginBtn()
	{
		clickOnElement(loginBtn);
	}
	
	

}
