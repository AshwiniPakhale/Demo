package com.VTigerLeadBackgroundEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerLoginPage extends SeleniumUtility {
	
	WebDriver driver;

	public VTigerLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userNameInputField;

	@FindBy(id = "password")
	private WebElement pwdInputField;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInBtn;

	@FindBy(css = "span[class='fa fa-user']")
	private WebElement profileBtn;

	@FindBy(id = "menubar_item_right_LBL_SIGN_OUT")
	private WebElement signOutBtn;

	public void login(String userName, String pwd) {
		typeInput(userNameInputField, userName);
		typeInput(pwdInputField, pwd);
		clickOnElement(signInBtn);
	}

	public void logout() {
		clickOnElement(profileBtn);
		clickOnElement(signOutBtn);
	}
}
//In page classes we define WebElement as private and we define public methods where we use those private element
//This is encapsulation concept of JAVA