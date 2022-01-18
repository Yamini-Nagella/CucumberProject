package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.RoundTrip;
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
public class RoundTrip_def extends Base{


	public RoundTrip_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	RoundTrip r;
	@Before("@RoundTrip")
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
	
	@Given("^Open URL land in HomePage RoundTrip$")
    public void open_url_land_in_homepage_roundtrip() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		r = new RoundTrip(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on the RoundTrip radio button$")
    public void click_on_the_roundtrip_radio_button() throws Throwable {
        r.click();
    }

    @Then("^Enter \"([^\"]*)\" in from field Rountrip$")
    public void enter_something_in_from_field_rountrip(String source) throws Throwable {
        r.from(source);
    }

    @Then("^Enter \"([^\"]*)\" in to field RoundTrip$")
    public void enter_something_in_to_field_roundtrip(String destination) throws Throwable {
        r.to(destination);
    }

    @Then("^Enter starting \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_starting_something_and_something(String month1, String day1) throws Throwable {
        r.starting(month1, day1);
    }

    @Then("^Enter Return \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_return_something_and_something(String month2, String day2) throws Throwable {
        r.Returns(month2, day2);
    }
    
    @Then("^Enter \"([^\"]*)\"$")
    public void enter_time(String time) throws Throwable {
        r.Time(time);
    }

    @Then("^click on select car button For RoundTrip$")
    public void click_on_select_car_button_for_roundtrip() throws Throwable {
        r.select();
    }

    @And("^Verify the RoundTripCars page by \"([^\"]*)\" and \"([^\"]*)\"$")
    public void verify_the_roundtripcars_page_by_something_and_something(String cityname, String date) throws Throwable {
        r.verify(cityname, date);
    }
    
    @After("@RoundTrip")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
}