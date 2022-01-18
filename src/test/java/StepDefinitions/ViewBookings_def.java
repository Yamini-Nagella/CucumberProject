package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.HomePageLogIn;
import pageObject.ViewBookings;
import reusableComponent.Base;
import runner.TestRunner;
import utilities.ExtentLogUtilities;
import utilities.GetProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@RunWith(Cucumber.class)
public class ViewBookings_def extends Base{

	
	public ViewBookings_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	HomePageLogIn h;
	ViewBookings v;
	@Before("@ViewBookings")
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
	@Given("^Open URL land in HomePage to view$")
    public void open_url_land_in_homepage_to_view() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		h = new HomePageLogIn(driver, log, test);
		v = new ViewBookings(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on signin button to view$")
    public void click_on_signin_button_to_view() throws Throwable {
        h.click();
    }

    @Then("^Enter \"([^\"]*)\" and \"([^\"]*)\" as a user to view bookings$")
    public void enter_something_and_something_as_a_user_to_view_bookings(String email, String password) throws Throwable {
        h.enter(email, password);
    }

    @Then("^Click on login button to view$")
    public void click_on_login_button_to_view() throws Throwable {
        h.clicklogin();
    }

    @Then("^Click on the bookings textlink$")
    public void click_on_the_bookings_textlink() throws Throwable {
        v.view();
    }

    @And("^Verify \"([^\"]*)\" ViewBookings$")
    public void verify_something_viewbookings(String page) throws Throwable {
        v.verify(page);
    }

    @After("@ViewBookings")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
    }
}