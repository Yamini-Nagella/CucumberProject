package StepDefinitions;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.PageObjectException;
import exceptions.ReusableComponentException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.AirportTaxi;
import reusableComponent.Base;
import runner.TestRunner;
import utilities.ExtentLogUtilities;
import utilities.GetProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@RunWith(Cucumber.class)
public class AirportTaxi_def extends Base{

	public AirportTaxi_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	AirportTaxi at;
	@Before("@AirportTaxi")
	public void initializeDriver() throws ApplicationException {
		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
					+ System.currentTimeMillis() + "-.html");
			log = Logger.getLogger(TestRunner.class.getName());
			driver = initialize();
			test = report.startTest("Home Page");
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	@Given("^Open URL land in HomePage AirportTaxi$")
    public void open_url_land_in_homepage() throws Throwable {
    	driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		at = new AirportTaxi(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }
	@Then("Click on the Airport tab")
	public void click_on_the_airport_tab() throws ReusableComponentException, Exception {
		at.airporttab();
	}

	@Then("Enter {string} in city field")
	public void enter_in_city_field(String city) throws ReusableComponentException, Exception {
		at.city(city);
	}

	@Then("select Trip type")
	public void select_trip_type() throws ReusableComponentException, Exception {
		at.trip();
	}

	@Then("Enter {string}, {string} and {string}, {string}")
	public void enter_and(String add, String month, String day, String time) throws ReusableComponentException, Exception {
		at.enterdetails(add, month, day, time);
	}

	@Then("click on select car button")
	public void click_on_select_car_button() throws ReusableComponentException, Exception {
		at.selectcar();
	}

	@Then("Verify the page by {string} and {string}")
	public void verify_the_page_by_and(String vcity, String vdate) throws IOException, PageObjectException {
		at.verify(vcity, vdate);
	}
	
	@After("@AirportTaxi")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
}
