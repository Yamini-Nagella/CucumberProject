package StepDefinitions;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.TravelAgent;
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
public class TravelAgent_def extends Base{

    
	public TravelAgent_def() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	TravelAgent t;
	@Before("@TravelAgent")
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
	@Given("^Open URL land in HomePage Travelagent$")
    public void open_url_land_in_homepage_travelagent() throws Throwable {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		t = new TravelAgent(driver, log, test);
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
    }

    @Then("^Click on the Travel Agent button$")
    public void click_on_the_travel_agent_button() throws Throwable {
        t.click();
    }

    @Then("^Click on the Register button in travelagent page$")
    public void click_on_the_register_button_in_travelagent_page() throws Throwable {
        t.register();
    }

    @And("^Verify \"([^\"]*)\" of Travel agent$")
    public void verify_something_of_travel_agent(String page) throws Throwable {
       t.verify(page);
    }

    @After("@TravelAgent")
    public void endthetest() throws Exception {
    	driver.quit();
		driver = null;
		driver = initialize();
    }
}