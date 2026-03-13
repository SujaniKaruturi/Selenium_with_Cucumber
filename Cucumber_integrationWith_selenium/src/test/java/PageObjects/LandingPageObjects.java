package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPageObjects {
	public WebDriver driver;
	
	public LandingPageObjects(WebDriver driver) //constructor to use global variables
	{
		this.driver =driver;
	}
	
	By tomato=By.xpath("//*[contains(text(),'Tomato')]");
	By search = By.className("search-keyword");
	By topDeals=By.linkText("Top Deals");
	
	public void searchItem(String shortName)
	{
		 	driver.findElement(search).sendKeys(shortName);     
	}
	public String getProductName()
	{
		return driver.findElement(tomato).getText();     
	}
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();   
	}
}
