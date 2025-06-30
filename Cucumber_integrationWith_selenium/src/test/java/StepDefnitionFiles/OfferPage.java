package StepDefnitionFiles;
	import java.util.Set;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;

import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
	

	public class OfferPage {
		public static WebDriver driver;
		public GlobalVariables gbcontext;
		
		 //making driver as global to all stepdefnition files by adding in it globalVariables class
		//so now change to gbcontext.driver from driver at all places 
		public OfferPage(GlobalVariables gbcontext) //constructor to use global variables
		{
			this.gbcontext =gbcontext;
		}
		
	
			//how to transfer states of variables from one step defnition file to another?
			//driver is assigned in LandingPage so same should be used in OfferPage as well without creating one more new instance/variable.
			@Then("User searches same 	short name {string} in offers page")
			public void User_searches_same_short_name_Tom_in_offerspage(String shortName) 
			{
				SwitchTo_OffersPage();
					WebElement tdSearch = gbcontext.driver.findElement(By.id("search-field"));
					tdSearch.sendKeys(shortName + Keys.ENTER);
					WebElement tomatofound= gbcontext.driver.findElement(By.xpath("//td[contains(text(),'Tomato')]"));
					gbcontext.offerpageProduct=tomatofound.getText();
			}
				
		
			public void SwitchTo_OffersPage()
			{
				//if u are already switched to particular page then skip the switch
				if(gbcontext.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
				{
				System.out.println("Main window is already switched to Top Deals window");
				}
				else {
				WebElement topDeals = gbcontext.driver.findElement(By.linkText("Top Deals"));
			    topDeals.click();
				String mainwindow = gbcontext.driver.getWindowHandle();
				Set<String> manywindows=gbcontext.driver.getWindowHandles();
				
				/*
				 * Iterator<String> wh=manywindows.iterator(); String parent = wh.next(); //0 th
				 * index of window which is parent window id String child =wh.next(); //1st
				 * index,child window id driver.switchTo().window(child);
				 */
				for(String eachwindow:manywindows)
				{
					if(!eachwindow.equals(mainwindow))
					{
					gbcontext.driver.switchTo().window(eachwindow);
					}
				}
				}
			}
			@Then("Validates product name in offer page matches with Home Page")
			public void validatesProductName() {
				Assert.assertEquals(gbcontext.landingpageproduct,gbcontext.offerpageProduct,"Product name Tomato in Home Page matches with Offer Page" );
				System.out.println("Product name Tomato in Home Page matches with Offer Page");
			}
	}


