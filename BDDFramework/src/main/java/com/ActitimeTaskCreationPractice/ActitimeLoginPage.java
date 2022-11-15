package com.ActitimeTaskCreationPractice;

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
	WebElement userNameField;
	
	@FindBy(css="input[name='pwd']")
	WebElement passwordField;
	
	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginBtn;
	
	public void enterUsername(String userName)
	{
		typeInput(userNameField, userName);
	}
	
	public void enterPassword(String passWord)
	{
		typeInput(passwordField, passWord);
	}
	
	public void clickOnLoginBtn()
	{
		clickOnElement(loginBtn);
	}

}
