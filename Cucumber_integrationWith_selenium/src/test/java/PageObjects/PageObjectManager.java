package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager
{
	public WebDriver driver;
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPageObjects landingPage;
	public OfferPageObjects offerspage;
	public LandingPageObjects getLandingPage()
	{
		landingPage =new LandingPageObjects(driver);
		return landingPage;
				
	}
	public OfferPageObjects offersPage()
	{
		offerspage =new OfferPageObjects(driver);
		return offerspage;
				
	}
}
