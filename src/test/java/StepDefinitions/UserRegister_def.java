package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.UserRegister;
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
public class UserRegister_def extends Base{

	public UserRegister_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	UserRegister u;
	@Before("@UserRegister")
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
	@Given("^Open URL land in savaari HomePage$")
    public void open_url_land_in_savaari_homepage() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		u = new UserRegister(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on signin button to register$")
    public void click_on_signin_button_to_register() throws Throwable {
        u.signin();
    }

    @Then("^Click on the Register button to register as a new user$")
    public void click_on_the_register_button_to_register_as_a_new_user() throws Throwable {
        u.click();
    }

    @Then("^Enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" in form$")
    public void enter_something_something_something_something_something_in_form(String name, String mobile, String email, String password, String cpassword)throws Throwable{
        u.details(name, mobile, email, password, cpassword);
    }

    @Then("^click on register$")
    public void click_on_register() throws Throwable {
        u.register();
    }

    @And("^Verify the page by \"([^\"]*)\"$")
    public void verify_the_page_by_something(String name) throws Throwable {
        u.verify(name);
    }
    @After("@UserRegister")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
}