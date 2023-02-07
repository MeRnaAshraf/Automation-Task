package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.BraceletsPage;
import Pages.CartPage;
import Pages.HomePage;

public class VerifyPriceTest extends BaseTest {

	ChromeDriver driver;

	HomePage objHomePage ;
	BraceletsPage objBraceletsPage;
	CartPage objCartPage;

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

	@Test(priority = 3)
	public void verifyTotalPrice()
	{
		objHomePage = new HomePage(driver);
		objHomePage.gotoCatalogList();
		objHomePage.openBraceletsPage();

		objBraceletsPage = new BraceletsPage(driver);
		objBraceletsPage.searchByText(searchText);
		
		String price = objBraceletsPage.getPrice();
		objBraceletsPage.addToCart();
		
		objHomePage.openCartPage();
		
		objCartPage = new CartPage(driver);
		String totalPrice = objCartPage.getTotalPrice();
		
		assertEquals(price, totalPrice);
		if(price.equals(totalPrice))
			test.log(LogStatus.PASS, "Total price is equal to product price");
		else
			test.log(LogStatus.FAIL, "Total price is NOT equal to product price");
		


	}

	@AfterMethod
	public void closeDriver()
	{
		driver.quit();

	}

}
