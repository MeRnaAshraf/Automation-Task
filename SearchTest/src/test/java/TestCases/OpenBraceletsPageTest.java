package TestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;

public class OpenBraceletsPageTest extends BaseTest {
	
	ChromeDriver driver;
	
	HomePage objHomePage ;
	
	


	@BeforeMethod
	public void setup()
	{
		
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("http://demo.themeparrot.com/shopy/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void braceletsPagIsOpened()
	{
		objHomePage = new HomePage(driver);
		objHomePage.gotoCatalogList();
		objHomePage.openBraceletsPage();
		
		assertTrue(driver.getCurrentUrl().contains("bracelets"));
		if(driver.getCurrentUrl().contains("bracelets"))
			test.log(LogStatus.PASS, "Bracelets page is opened successfully");
		else
			test.log(LogStatus.FAIL, "Fail to open Bracelets page");


	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
		
	}


}
