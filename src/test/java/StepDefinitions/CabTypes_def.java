package StepDefinitions;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import exceptions.ApplicationException;
import exceptions.UtilityException;
import io.cucumber.junit.Cucumber;
import pageObject.CabTypes;
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
	public class CabTypes_def extends Base{

		
		public CabTypes_def() throws UtilityException, Exception {
			super();
			// TODO Auto-generated constructor stub
		}
		
		static Logger log;
		static ExtentTest test;
		static ExtentReports report;
		CabTypes cb;
		@Before("@CabTypes")
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
		@Given("^Open URL land in HomePage cabtypes$")
	    public void open_url_land_in_homepage_cabtypes() throws Throwable {
			driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			cb = new CabTypes(driver, log, test);
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	    }


	    @Then("^Click on the Sitemap TextLink in footer$")
	    public void click_on_the_sitemap_textlink_in_footer() throws Throwable {
	    	cb.clickonsitemap();
	    }

	    @Then("^Click on Cab types text link$")
	    public void click_on_cab_types_text_link() throws Throwable {
	    	cb.clickoncabtypes();
	    }

	    @And("^Verify \"([^\"]*)\" of Cab Type Page$")
	    public void verify_something_of_cab_type_page(String title) throws Throwable {
	    	cb.verify(title);
	    }

	    @After("@CabTypes")
	    public void endthetest() throws Exception {
	    	driver.quit();
			driver = null;
			driver = initialize();
	    }

	}

