package com.VTiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerHomePage extends SeleniumUtility {
WebDriver driver;
	
	public VTigerHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[id='appnavigator']")
	private WebElement burgerMenu;
	
	@FindBy(xpath="//span[text()=' MARKETING']")
	private WebElement marketingOption;
	
	@FindBy(xpath="//span[text()=' Leads']")
	private WebElement leadOption;
	
	public void burgurManu()
	{
		clickOnElement(burgerMenu);
	}
	
	public void marketingManu()
	{
		clickOnElement(marketingOption);
	}
	
	public void leadsOption()
	{
		clickOnElement(leadOption);
	}

}
