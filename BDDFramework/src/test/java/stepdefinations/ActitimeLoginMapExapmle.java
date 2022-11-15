package stepdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Actitime.ActitimeHomePage;
import com.Actitime.ActitimeLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.SeleniumUtility;

public class ActitimeLoginMapExapmle extends SeleniumUtility{
	
	WebDriver driver;
	ActitimeLoginPage actiLogin = null;
	ActitimeHomePage actiHome = null;
	@Given("user in on actitime login page")
	public void user_in_on_actitime_login_page() {
	   driver = setUp("chrome", "https://demo.actitime.com/login.do");
	   actiLogin = new ActitimeLoginPage(driver);
	   actiHome = new ActitimeHomePage(driver);
	}

	@Given("user enters following inputs")
	public void user_enters_following_inputs(io.cucumber.datatable.DataTable dataTable) {
	   List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
	   Map<String, String> firstUser = userData.get(0);
	   actiLogin.enterUsernameAndPassword(firstUser.get("Username"), firstUser.get("Password"));
	}

	@Given("user click on login button")
	public void user_click_on_login_button() {
		actiLogin.clickOnLoginBtn();
	}

	@Then("user should be login successfully")
	public void user_should_be_login_successfully() {
	   Assert.assertTrue(actiHome.verifyUserLoggedIn());
	}

	@Then("user should logout and close the browser")
	public void user_should_logout_and_close_the_browser() {
		actiHome.logout();
		cleanUp();
	}

}
