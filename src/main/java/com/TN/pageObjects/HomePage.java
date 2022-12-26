package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchField;
	
	@FindBy(xpath="//*[contains(@class,'btn-default btn-lg')]")
	private WebElement searchButton;
	
	//Actions
	public void clickOnMyAccountDropDown() {
		myAccountDropDown.click();
	}
	
	public LoginPage clickOnLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLogin() {
		myAccountDropDown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegister() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDropDown.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductNameInSearchField(String productName) {
		searchField.sendKeys(productName);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForValidProduct(String productName) {
		searchField.sendKeys(productName);
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForInvalidProduct(String productName) {
		searchField.sendKeys(productName);
		searchButton.click();
		return new SearchPage(driver);
	}
}
