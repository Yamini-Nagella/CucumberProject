package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.LocalCars;
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
public class LocalCars_def extends Base{

	public LocalCars_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	LocalCars l;
	@Before("@LocalCars")
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
	
	@Given("^Open URL land in HomePage localcars$")
    public void open_url_land_in_homepage_localcars() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		l = new LocalCars(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on the LocalTab$")
    public void click_on_the_localtab() throws Throwable {
        l.click();
    }

    @Then("^Enter \"([^\"]*)\" in city field for local cars$")
    public void enter_something_in_city_field_for_local_cars(String city) throws Throwable {
        l.City(city);
    }

    @Then("^Enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" local car$")
    public void enter_something_and_something_something_local_car(String month, String day, String time) throws Throwable {
        l.details(month, day, time);
    }

    @Then("^click on select car button to select local car$")
    public void click_on_select_car_button_to_select_local_car() throws Throwable {
        l.select();
    }

    @And("^Verify the local car page by \"([^\"]*)\" and \"([^\"]*)\"$")
    public void verify_the_local_car_page_by_something_and_something(String cityname, String date) throws Throwable {
        l.verify(cityname, date);
    }

    @After("@LocalCars")
    public void endthetest() throws Exception {
    	//driver.quit();
		//driver = null;
		//driver = initialize();
    }
}