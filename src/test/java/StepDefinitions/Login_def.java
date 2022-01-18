package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.HomePageLogIn;
import reusableComponent.Base;
import runner.TestRunner;
import utilities.ExtentLogUtilities;
import utilities.GetProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@RunWith(Cucumber.class)
public class Login_def extends Base{

	public Login_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	HomePageLogIn h;
	@Before("@Login")
	public void initializeDriver() throws ApplicationException {
		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
					+ System.currentTimeMillis() + "-.html");
			log = Logger.getLogger(TestRunner.class.getName());
			driver = initialize();
			test = report.startTest("Home Page");
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	@Given("^Open URL land in HomePage login$")
    public void open_url_land_in_homepage_login() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		h = new HomePageLogIn(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on signin button to login$")
    public void click_on_signin_button_to_login() throws Throwable {
        h.click();
    }

    @Then("^Enter \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void enter_something_and_something_to_login(String email, String password) throws Throwable {
        h.enter(email, password);
    }

    @Then("^Click on login button$")
    public void click_on_login_button() throws Throwable {
        h.clicklogin();
    }

    @Then("^Verify \"([^\"]*)\" login$")
    public void verify_something_login(String user) throws Throwable {
        h.verify(user);
    }
    @After("@Login")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
}