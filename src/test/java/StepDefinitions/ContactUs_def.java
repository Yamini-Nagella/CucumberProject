package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.ContactUs;
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
public class ContactUs_def extends Base{

	public ContactUs_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	ContactUs ct;
	
	@Before("@ContactUs")
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
	@Given("^Open URL land in HomePage contactus$")
    public void open_url_land_in_homepage_contactus() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ct = new ContactUs(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on the ContactUs TextLink in footer$")
    public void click_on_the_contactus_textlink_in_footer() throws Throwable {
       ct.click();
    }

    @And("^Verify \"([^\"]*)\" of Contact Us$")
    public void verify_something_of_contact_us(String heading) throws Throwable {
        ct.verify(heading);
    }

    @After("@ContactUs")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
}