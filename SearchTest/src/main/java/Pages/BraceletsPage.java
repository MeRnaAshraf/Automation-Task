package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BraceletsPage {
	
	WebDriver driver;
	
	public BraceletsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchByText(String searchText) 
	{
		WebElement searchTxt = driver.findElement(By.name("search"));
		searchTxt.sendKeys(searchText);
		
		WebElement searchBtn = driver.findElement(By.className("btn-success"));
		searchBtn.click();
	}
	
	public List<String> searchList() 
	{
		List<String> searchResults = new ArrayList<String>();
		
		WebElement resultSet = driver.findElement(By.className("j2store-products-row"));
		List<WebElement> options = resultSet.findElements(By.className("product-title"));
		for (WebElement option : options) {
			searchResults.add(option.getText());
		}
		
		return searchResults;
	}
	
	public void addToCart() 
	{
		WebElement addToCartBtn = driver.findElement(By.className("j2store-cart-button"));
		addToCartBtn.click();
		
	}
	
	public String getPrice() 
	{
		WebElement priceTxt = driver.findElement(By.className("sale-price"));
		String price = priceTxt.getText();
		return price;
		
	}
}
