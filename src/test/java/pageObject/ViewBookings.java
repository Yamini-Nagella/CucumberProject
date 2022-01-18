package pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import exceptions.PageObjectException;
import exceptions.ReusableComponentException;
import reusableComponent.WebDriverSupport;
import uiStore.ViewBookingsUi;
import utilities.ExtentLogUtilities;

public class ViewBookings extends ViewBookingsUi{
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public ViewBookings(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	
	public void view() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, profile, "Home Page", "Log In Button", log, test);
		Thread.sleep(5000);
		WebDriverSupport.click(driver, viewlist, "View Bookings", "List of Bookings", log, test);
	}
	public void verify(String verify) throws IOException, PageObjectException {
		String text = driver.findElement(vheading).getText();
		if (text.contains(verify)) {
			ExtentLogUtilities.pass(driver, test, "Successfully opened View Bookings page", log);
		} else {
			ExtentLogUtilities.fail(driver, test, "failed to login to View Bookings page", log);
			throw new PageObjectException("Logged in failed");
		} 
	}
	public void View(String verify) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, profile, "Home Page", "Log In Button", log, test);
			Thread.sleep(5000);
			WebDriverSupport.click(driver, viewlist, "View Bookings", "List of Bookings", log, test);
			
			String text = driver.findElement(vheading).getText();
			if (text.contains(verify)) {
				ExtentLogUtilities.pass(driver, test, "Successfully opened View Bookings page", log);
			} else {
				ExtentLogUtilities.fail(driver, test, "failed to login to View Bookings page", log);
				throw new PageObjectException("Logged in failed");
			} 
			
		} catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}

}
