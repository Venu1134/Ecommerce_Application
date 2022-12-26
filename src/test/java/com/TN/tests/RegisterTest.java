package com.TN.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.BaseClass;
import com.TN.pageObjects.AccountSuccessPage;
import com.TN.pageObjects.HomePage;
import com.TN.pageObjects.RegisterPage;
import com.TN.utilities.UtilityClass;

public class RegisterTest extends BaseClass {

	public RegisterTest() {
		super();
	}

	public WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowser(prop.getProperty("browserName"));

		homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields() {

		accountSuccessPage = registerPage.registerWithMandatoryFields(testDataProp.getProperty("firstName"),
				testDataProp.getProperty("lastName"), UtilityClass.getInvalidEmail(),
				testDataProp.getProperty("telephone"), prop.getProperty("validPassword"));

		Assert.assertTrue(accountSuccessPage.verifyAccountCreateSuccessMessage());

		driver.quit();
	}

	@Test(priority = 2)
	public void verifyRegisterWithAllFields() {

		accountSuccessPage = registerPage.registerWithAllFields(testDataProp.getProperty("firstName"),
				testDataProp.getProperty("lastName"), UtilityClass.getInvalidEmail(),
				testDataProp.getProperty("telephone"), prop.getProperty("validPassword"));

		Assert.assertTrue(accountSuccessPage.verifyAccountCreateSuccessMessage());

		driver.quit();
	}

	@Test(priority = 3)
	public void verifyRegisterWithExistingEmail() {

		registerPage.registerWithAllFields(testDataProp.getProperty("firstName"), testDataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), testDataProp.getProperty("telephone"),
				prop.getProperty("validPassword"));

		Assert.assertTrue(registerPage.verifyEmailExistsWarningMessage());

		driver.quit();
	}

	@Test(priority = 4)
	public void verifyRegisterWithoutEnteringAnyData() {

		registerPage.clickOnContinueButton();

		Assert.assertTrue(
				registerPage.verifyWarningMessages(testDataProp.getProperty("expectedPrivacyPolicyWarningMessage"),
						testDataProp.getProperty("expectedFirstNameWarningMessage"),
						testDataProp.getProperty("expectedLastNameWarningMessage"),
						testDataProp.getProperty("expectedEmailWarningMessage"),
						testDataProp.getProperty("expectedTelephoneWarningMessage"),
						testDataProp.getProperty("expectedPasswordWarningMessage")),"Warning Message is not displayed");

		driver.quit();
	}
}
