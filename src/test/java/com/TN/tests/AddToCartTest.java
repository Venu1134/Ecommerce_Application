package com.TN.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.BaseClass;
import com.TN.pageObjects.HomePage;
import com.TN.pageObjects.ProductDetailsPage;
import com.TN.pageObjects.SearchPage;

public class AddToCartTest extends BaseClass{

	public AddToCartTest() {
		super();
	}
	
	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyAddToCartForValidProduct() {
		searchPage = homePage.searchForValidProduct(testDataProp.getProperty("validProduct"));
		productDetailsPage = searchPage.clickOnProductName();
		productDetailsPage.enterDeliveryDate(testDataProp.getProperty("deliverydate"));
		productDetailsPage.enterQuantity(testDataProp.getProperty("quantity"));
		productDetailsPage.clickOnAddToCart();
		
		Assert.assertTrue(productDetailsPage.verifyAddToCartConfirmationMessage(testDataProp.getProperty("expectedProductAddedConfirmationMessage")));
	}
}
