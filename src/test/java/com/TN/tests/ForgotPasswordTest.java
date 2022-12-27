package com.TN.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.BaseClass;
import com.TN.pageObjects.ForgotPasswordPage;
import com.TN.pageObjects.HomePage;
import com.TN.pageObjects.LoginPage;
import com.TN.utilities.UtilityClass;

public class ForgotPasswordTest extends BaseClass{

	public ForgotPasswordTest() {
		super();
	}

	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		loginPage = homePage.navigateToLogin();	
		forgotPasswordPage = loginPage.clickOnForgotPassword();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyForgotPasswordWithRegisteredEmail() {
		forgotPasswordPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage = forgotPasswordPage.clickOnContinueButton();
		Assert.assertTrue(loginPage.verifyForgotPasswordConfirmationMessage(testDataProp.getProperty("expectedForgotPasswordConfirmationMessage")));
	}
	
	@Test(priority=2)
	public void verifyForgotPasswordWithNonRegisteredEmail() {
		forgotPasswordPage.enterEmailAddress(UtilityClass.getInvalidEmail());
		loginPage = forgotPasswordPage.clickOnContinueButton();
		Assert.assertTrue(forgotPasswordPage.getEmailNotFoundWarningMessage(testDataProp.getProperty("expectedEmailNotFoundErrorMessage")));
	}
	
	@Test(priority=3)
	public void verifyForgotPasswordWithNoEmail() {
		forgotPasswordPage.verifyEmailNotFoundMessage();
		Assert.assertTrue(forgotPasswordPage.getEmailNotFoundWarningMessage(testDataProp.getProperty("expectedEmailNotFoundErrorMessage")));
	}
}
