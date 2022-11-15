package com.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class OrangeHrmHomePage extends SeleniumUtility {
	
	WebDriver driver;

	public OrangeHrmHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement profileBtn;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//li[4]")
	private WebElement logoutBtn;

	public void logout() {
		clickOnElement(profileBtn);
		clickOnElement(logoutBtn);
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}
}
