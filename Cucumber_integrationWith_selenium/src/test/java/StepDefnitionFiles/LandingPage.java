package StepDefnitionFiles;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPageObjects;
import Utils.GlobalVariables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage {
	public static WebDriver driver;
	public GlobalVariables gbcontext;
	
	public LandingPage(GlobalVariables gbcontext) //constructor to use global variables
	{
		this.gbcontext =gbcontext;
	}
	@Given("User is on Greencart Landing Page")
	public void user_is_on_greencart_landing_page() {
		//System.setProperty("webdriver.chrome.driver", "path of installed driver");
		WebDriverManager.chromedriver().setup();
	    //driver =new ChromeDriver(); local to method 
		gbcontext.driver =new ChromeDriver();   //making driver as global to all stepdefnition files by adding in it globalVariables class
		//so now change to gbcontext.driver from driver at all places 
		gbcontext.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		gbcontext.driver.manage().window().maximize();
		gbcontext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    System.out.println("User is on GreenCart Landing Page");
	    
	}
	@When("User searches with short name {string} and extract actual name of product")
	public void user_searches_with_short_name_and_extract_actual_name_of_product(String shortName) {
		/*
		 * WebElement search =
		 * gbcontext.driver.findElement(By.className("search-keyword"));
		 * search.sendKeys(shortName); WebElement
		 * tomato=gbcontext.driver.findElement(By.xpath("//*[contains(text(),'Tomato')]"
		 * )); gbcontext.landingpageproduct=tomato.getText().split("-")[0].trim();
		 */
		LandingPageObjects landingPage= gbcontext.pageObjectManager.getLandingPage();
		//LandingPageObjects lp=new LandingPageObjects(gbcontext.driver);
		landingPage.searchItem(shortName);
		gbcontext.landingpageproduct=landingPage.getProductName().split("-")[0].trim();
	    System.out.println("Product name in HomeSearch Page is "+ gbcontext.landingpageproduct);
	    Assert.assertEquals("Tomato",gbcontext.landingpageproduct,"Tomato vegetable is found in Home Page" );
	}
	
}
	
		
