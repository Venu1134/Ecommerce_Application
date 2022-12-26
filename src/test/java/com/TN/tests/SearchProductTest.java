package com.TN.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.BaseClass;
import com.TN.pageObjects.HomePage;
import com.TN.pageObjects.SearchPage;

public class SearchProductTest extends BaseClass {

	public SearchProductTest() {
		super();
	}
	
	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithExsistingProduct() {
		
		searchPage = homePage.searchForValidProduct(testDataProp.getProperty("validProduct"));
		
		Assert.assertTrue(searchPage.verifyProductName(),"Product searched for is not displayed");
	}
	
	@Test(priority=2)
	public void verifySearchWithNonExsistingProduct() {
		
		searchPage = homePage.searchForInvalidProduct(testDataProp.getProperty("invalidProduct"));
		
		Assert.assertEquals(searchPage.verifyActualTextMessageForNoProduct(), testDataProp.getProperty("expectedTextMessageForNoProduct"));
	}
	
	@Test(priority=3, dependsOnMethods= {"verifySearchWithNonExsistingProduct"})
	public void verifySearchWithoutAnyProduct() {
		
		searchPage = homePage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.verifyActualTextMessageForNoProduct(), testDataProp.getProperty("expectedTextMessageForNoProduct"));
	}
}
