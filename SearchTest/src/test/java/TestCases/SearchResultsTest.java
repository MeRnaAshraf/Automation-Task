package TestCases;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.BraceletsPage;
import Pages.HomePage;

public class SearchResultsTest extends BaseTest {

	ChromeDriver driver;

	HomePage objHomePage ;
	BraceletsPage objBraceletsPage;
	
	
	String searchText = "fa";


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

	@Test(priority = 2)
	public void searchFor_fa()
	{
		objHomePage = new HomePage(driver);
		objHomePage.gotoCatalogList();
		objHomePage.openBraceletsPage();
		
		objBraceletsPage = new BraceletsPage(driver);
		objBraceletsPage.searchByText(searchText);
		
		int i = 1;
		List<String> productName = new ArrayList<String>();
		productName.addAll(objBraceletsPage.searchList());
		for (String option : productName) {
			option = option.toLowerCase();
			assertTrue(option.contains(searchText));
			if(option.contains(searchText))
				test.log(LogStatus.PASS, "Product #" + i + " contains text 'fa'");
			else
				test.log(LogStatus.FAIL, "Product #" + i + " NOT contains text 'fa'");
			
			i++;

			
		}
		
		
	}

	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
		

	}

}
