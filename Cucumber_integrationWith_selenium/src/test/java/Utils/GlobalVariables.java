package Utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

//what are variables/properties which we want to share with another step definition file using picocontainer dependency
public class GlobalVariables {
	public static WebDriver driver;
	public String landingpageproduct;
	public String offerpageProduct;
	public PageObjectManager pageObjectManager;
	
	public GlobalVariables()
	{
		pageObjectManager =new PageObjectManager(driver);
	}
}
