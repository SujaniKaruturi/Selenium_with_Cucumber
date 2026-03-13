package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferPageObjects {
	public WebDriver driver;
	
	public OfferPageObjects(WebDriver driver) //constructor to use global variables
	{
		this.driver =driver;
	}
	
	private By tomatofound=By.xpath("//td[contains(text(),'Tomato')]");
	//no other classes can modify your locators,these are only applicable to only this class
	private By search = By.id("search-field");

	public void searchItem(String shortName)
	{
		 	driver.findElement(search).sendKeys(shortName+Keys.ENTER);     
	}
	public String getProductName()
	{
		return driver.findElement(tomatofound).getText();     
	}
}
