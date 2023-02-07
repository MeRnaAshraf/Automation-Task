package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	WebDriver driver;


	public CartPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTotalPrice ()
	{
		WebElement totalPriceTxt = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td"));
		String totalPrice = totalPriceTxt.getText();
		return totalPrice;
		
	}
	


}
