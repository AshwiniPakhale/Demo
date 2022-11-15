package com.ActitimeTaskCreationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class ActitimeHomePage extends SeleniumUtility {

	WebDriver driver;

	public ActitimeHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "container_tasks")
	private WebElement taskTab;

	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;

	@FindBy(css = "div[class='item createNewTasks']")
	private WebElement newTasksBtn;

	@FindBy(xpath = "//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']")
	private WebElement selectDropdown;

	@FindBy(xpath = "//div[@class='searchItemList']//div[text()='Spaceship building']")
	private WebElement selectDropdownItem;

	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder'][1]")
	private WebElement taskName;

	@FindBy(xpath = "//div[text()='Create Tasks']")
	private WebElement createTasksBtn;

	@FindBy(xpath = "//div[text()='Automation']")
	private WebElement createdTask;

	@FindBy(id = "logoutLink")
	private WebElement logoutBtn;

	public void clickOnTaskTab() {
		clickOnElement(taskTab);
	}

	public void clickOnAddNewBtn() {
		clickOnElement(addNewBtn);
	}

	public void selectNewTask() {
		clickOnElement(newTasksBtn);
	}

	public void selectItemFromDropdown() {
		clickOnElement(selectDropdown);
		clickOnElement(selectDropdownItem);
	}

	public void getTaskName(String taskname) {
		typeInput(taskName, taskname);
	}

	public void clickCreateTaskBtn() {
		clickOnElement(createTasksBtn);
	}

	public boolean verifyTaskIsCreated() {
		return verifyUTElementDisplayed(createdTask);
	}

	public void logout() {
		clickOnElement(logoutBtn);
	}

}
