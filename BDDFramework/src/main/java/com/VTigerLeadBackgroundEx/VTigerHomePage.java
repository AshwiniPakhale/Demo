package com.VTigerLeadBackgroundEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerHomePage extends SeleniumUtility {
	WebDriver driver;

	public VTigerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='appnavigator']")
	private WebElement burgerMenu;

	@FindBy(xpath = "//span[contains(text(),'MARKETING')]")
	private WebElement marketingOption;

	@FindBy(xpath = "//a[@title='Leads']")
	private WebElement leadOption;

	@FindBy(className = "company-logo")
	private WebElement companyLogo;

	@FindBy(css = "span[class='fa fa-user']")
	private WebElement profileBtn;

	@FindBy(id = "menubar_item_right_LBL_SIGN_OUT")
	private WebElement singOutBtn;

	public void openTheNavigation() {
		clickOnElement(burgerMenu);
	}

	public void openMarketingAndSelectLead() {
		clickOnElement(marketingOption);
		clickOnElement(leadOption);
	}

	public void logout() {
		clickOnElement(companyLogo);
		clickOnElement(profileBtn);
		clickOnElement(singOutBtn);
	}
}