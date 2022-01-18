package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import pageObject.AboutUs;
import reusableComponent.Base;
import runner.TestRunner;
import utilities.ExtentLogUtilities;
import utilities.GetProperties;
@RunWith(Cucumber.class)
public class AboutUs_def extends Base{
	public AboutUs_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	AboutUs ab;
	@Before("@AboutUs")
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
    @Given("^Open URL land in HomePage$")
    public void open_url_land_in_homepage() throws Throwable {
    	driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ab = new AboutUs(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on the Aboutus TextLink in footer$")
    public void click_on_the_aboutus_textlink_in_footer() throws Throwable {
    	ab.clickonaboutus();
    }

    @And("^Verify \"([^\"]*)\" of Savaari Rental Cars$")
    public void verify_something_of_savaari_rental_cars(String ceo) throws Throwable {
    	ab.verifyceo(ceo);
    }
    @After("@AboutUs")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
    

}