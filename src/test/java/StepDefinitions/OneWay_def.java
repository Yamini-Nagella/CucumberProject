package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.OutStationTaxi_OneWay;
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
public class OneWay_def extends Base{

	public OneWay_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	OutStationTaxi_OneWay oneway;
	@Before("@OneWay")
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
	 @Given("^Open URL land in HomePage oneway$")
	    public void open_url_land_in_homepage_oneway() throws Throwable {
		 driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			oneway = new OutStationTaxi_OneWay(driver, log, test);
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	    }

	    @Then("^Enter \"([^\"]*)\" in from field oneway$")
	    public void enter_something_in_from_field_oneway(String source) throws Throwable {
	        oneway.from(source);
	    }

	    @Then("^Enter \"([^\"]*)\" in to field oneway$")
	    public void enter_something_in_to_field_oneway(String destination) throws Throwable {
	        oneway.to(destination);
	    }

	    @Then("^Enter \"([^\"]*)\" and \"([^\"]*)\", \"([^\"]*)\" for oneway$")
	    public void enter_something_and_something_something_for_oneway(String month, String day, String time) throws Throwable {
	        oneway.details(month, day, time);
	    }

	    @Then("^click on select car button to select cars for oneway$")
	    public void click_on_select_car_button_to_select_cars_for_oneway() throws Throwable {
	        oneway.select();
	    }

	    @And("^Verify the oneway cars page by \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void verify_the_oneway_cars_page_by_something_and_something(String cityname, String date) throws Throwable {
	        oneway.verify(cityname, date);
	    }
	    @After("@OneWay")
	    public void endthetest() throws Exception {
	    	driver.quit();
			driver = null;
			driver = initialize();
	    }
}