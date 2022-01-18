package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "StepDefinitions", monochrome = true, 
//plugin = {"pretty", "html:target/HtmlReports"}
//plugin = {"pretty", "json:target/JSONReports/report.json"}
//plugin = {"pretty", "junit:target/JunitReports/report.xml"}
plugin = {"pretty", "html:target/HtmlReports", "json:target/JSONReports/report.json", "junit:target/JunitReports/report.xml"}
)
public class TestRunner {

}
