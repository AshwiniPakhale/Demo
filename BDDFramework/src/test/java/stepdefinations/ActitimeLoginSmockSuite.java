package stepdefinations;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.Actitime.ActitimeHomePage;
import com.Actitime.ActitimeLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.SeleniumUtility;

public class ActitimeLoginSmockSuite extends SeleniumUtility {

	WebDriver driver;
	ActitimeLoginPage actiLogin = null;
	ActitimeHomePage actiHome = null;

	@Given("user is actitme login page")
	public void user_is_actitme_login_page() {
		driver = setUp("chrome", "https://demo.actitime.com/login.do");
		actiLogin = new ActitimeLoginPage(driver);
		actiHome = new ActitimeHomePage(driver);
	}

	@Given("user enters given inputs")
	public void user_enters_given_inputs(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
		Map<String, String> firstUser = userData.get(0);
		actiLogin.enterUsernameAndPassword(firstUser.get("Username"), firstUser.get("Password"));
	}

	@Given("user click login button")
	public void user_click_login_button() {
		actiLogin.clickOnLoginBtn();

	}

	@Then("user should login successfully")
	public void user_should_login_successfully() {
		assertTrue(actiHome.verifyUserLoggedIn());
	}

	@Then("user should logout and after close the browser")
	public void user_should_logout_and_after_close_the_browser() {
		actiHome.logout();
		cleanUp();
	}

}
