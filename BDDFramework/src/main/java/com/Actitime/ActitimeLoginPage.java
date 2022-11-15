package com.Actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class ActitimeLoginPage extends SeleniumUtility{
	WebDriver driver;
	public ActitimeLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(name="pwd")
	private WebElement passwordField;
	
	@FindBy(id="loginButtonContainer")
	private WebElement loginBtn;
	
	public void enterUsernameAndPassword(String username, String Password)
	{
		typeInput(usernameField, username);
		typeInput(passwordField, Password);
	}
	
	public void enterUsernme(String username)
	{
		typeInput(usernameField, username);
	}
	
	public void enterPassword(String pwd)
	{
		typeInput(passwordField, pwd);
	}
	
	public void clickOnLoginBtn()
	{
		clickOnElement(loginBtn);
	}

}
