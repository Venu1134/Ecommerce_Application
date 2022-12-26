package com.TN.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TN.base.BaseClass;
import com.TN.pageObjects.AccountPage;
import com.TN.pageObjects.HomePage;
import com.TN.pageObjects.LoginPage;
import com.TN.utilities.UtilityClass;

public class LoginTest extends BaseClass{

	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowser(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		loginPage = homePage.navigateToLogin();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {

		accountPage = loginPage.login(email, password);
		
		Assert.assertTrue(accountPage.verifyEditYourAccountInformation());

	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] getLoginData() {
		Object[][] data = UtilityClass.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority=2)
	public void verifyLoginWithInValidCredentials() {

		accountPage = loginPage.login(UtilityClass.getInvalidEmail(), testDataProp.getProperty("invalidPassword")); 
	
		Assert.assertTrue(loginPage.verifyInvalidCredentialsErrorMessage());

	}
	
	@Test(priority=3)
	public void verifyLoginWithInValidEmailValidPassword() {

		accountPage = loginPage.login(UtilityClass.getInvalidEmail(), prop.getProperty("validPassword"));

		Assert.assertTrue(loginPage.verifyInvalidCredentialsErrorMessage());

	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailInvalidPassword() {
		
		accountPage = loginPage.login(prop.getProperty("validEmail"), testDataProp.getProperty("invalidPassword"));

		Assert.assertTrue(loginPage.verifyInvalidCredentialsErrorMessage());

	}
	
	@Test(priority=5)
	public void verifyLoginWithoutCredentials() {

		loginPage.clickOnLoginButton();

		Assert.assertTrue(loginPage.verifyInvalidCredentialsErrorMessage());

	}
	
}
