package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(id="input-email")
	private WebElement emailTextField;
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//*[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[contains(@class,'alert-dismissible')]")
	private WebElement invalidCredentialsErrorMessage;
	
	//Actions
	public void enterEmail(String email) {
		emailTextField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String email, String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public boolean verifyInvalidCredentialsErrorMessage() {
		return invalidCredentialsErrorMessage.isDisplayed();
	}
}
