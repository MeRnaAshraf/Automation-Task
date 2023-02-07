package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeSuite
	public void initialization()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}
	
	@AfterSuite
	public void teardown()
	{
		report.flush();

	}

}
