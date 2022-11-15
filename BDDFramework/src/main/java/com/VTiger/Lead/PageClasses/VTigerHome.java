package com.VTiger.Lead.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerHome extends SeleniumUtility
{
	WebDriver driver;
	
	public VTigerHome(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	//	PageFactory.initElements(driver, VTigerHome.class);
	}
	
	@FindBy(css="div[id='appnavigator']")
	private WebElement burgerMenu;
	
	@FindBy(xpath="//span[text()=' MARKETING']")
	private WebElement marketingOption;
	
	@FindBy(xpath="//span[text()=' Leads']")
	private WebElement leadOption;
	
	public void navigateToLeadsPage()
	{
		clickOnElement(burgerMenu);
		clickOnElement(marketingOption);
		clickOnElement(leadOption);
	}

}

