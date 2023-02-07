package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;


	public HomePage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void gotoCatalogList ()
	{
		WebElement catalogList = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/div/div[2]/div/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(catalogList).perform();
		
	}
	
	public void openBraceletsPage ()
	{
		WebElement braceletsBtn = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/div/ul/li/div/div/div/div/div/ul/li[3]/a"));
		braceletsBtn.click();
	}
	
	public void openCartPage() 
	{
		WebElement cartBtn = driver.findElement(By.className("fa-shopping-cart"));
		cartBtn.click();
		
	}

}
