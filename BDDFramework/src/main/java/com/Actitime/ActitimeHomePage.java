package com.Actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class ActitimeHomePage extends SeleniumUtility
{
	WebDriver driver;
	public ActitimeHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[@class='logoCell navCell']")
	private WebElement logo;
	
	
	//@FindBy(xpath="//a[text()='Logout']")
	@FindBy(css="#logoutLink")
	private WebElement logOutBtn;
	
	public void logout()
	{
		clickOnElement(logOutBtn); 
	}
	
	public WebElement getLogo()
	{
		return logo;
	}
	
	public boolean verifyUserLoggedIn()
	{
		return verifyUTElementDisplayed(logOutBtn);
	}

}
