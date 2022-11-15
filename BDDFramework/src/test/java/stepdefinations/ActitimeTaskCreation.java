package stepdefinations;

import org.openqa.selenium.WebDriver;

import com.ActitimeTaskCreationPractice.ActitimeHomePage;
import com.ActitimeTaskCreationPractice.ActitimeLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class ActitimeTaskCreation extends SeleniumUtility{
	
	WebDriver driver;
	ActitimeLoginPage actiLogin = null;
	ActitimeHomePage actiHome = null;
	
	@Given("user is on actitime login page for task creation")
	public void user_is_on_actitime_login_page_for_task_creation() {
	  driver = setUp("chrome", "https://demo.actitime.com/login.do");
	   actiLogin = new ActitimeLoginPage(driver);
	   actiHome = new ActitimeHomePage(driver);
	}
	
	@Given("user enters username as {string} in the username field")
	public void user_enters_username_as_in_the_username_field(String username) {
		actiLogin.enterUsername(username);
	}

	@Given("user enters password as {string} in the password field")
	public void user_enters_password_as_in_the_password_field(String password) {
		actiLogin.enterPassword(password);
	}

	@Given("user should click on login button")
	public void user_should_click_on_login_button() {
		actiLogin.clickOnLoginBtn();
	}

	@When("click on task tab")
	public void click_on_task_tab() {
		actiHome.clickOnTaskTab();
	}

	@When("click on add new button")
	public void click_on_add_new_button() {
		actiHome.clickOnAddNewBtn(); 
	}

	@When("select new tasks")
	public void select_new_tasks() {
		actiHome.selectNewTask();
	}

	@When("select project from project dropdown")
	public void select_project_from_project_dropdown() {
		actiHome.selectItemFromDropdown();
	}

	@When("enter task name as {string}")
	public void enter_task_name_as(String taskname) {
		actiHome.getTaskName(taskname);
	}


	@When("click on create Tasks button")
	public void click_on_create_tasks_button() {
		actiHome.clickCreateTaskBtn();
	}

	@Then("user should be able to see the created task on page")
	public void user_should_be_able_to_see_the_created_task_on_page() {
		actiHome.verifyTaskIsCreated();
	}

	@Then("close the actitime application browser")
	public void close_the_actitime_application_browser() {
		actiHome.logout();
		cleanUp();
	}



}
