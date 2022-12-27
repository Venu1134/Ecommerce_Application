package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	@FindBy(id="input-email")
	private WebElement emailTextField;
	
	@FindBy(xpath="//*[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//*[contains(text(),' Warning')]")
	private WebElement emailNotFoundWarningMessage;
	
	//Actions
	public void enterEmailAddress(String email) {
		emailTextField.sendKeys(email);
	}
	
	public LoginPage clickOnContinueButton() {
		continueButton.click();
		return new LoginPage(driver);
	}
	
	public boolean getEmailNotFoundWarningMessage(String expectedEmailNotFoundErrorMessage) {
		String actualEmailNotFoundErrorMessage = emailNotFoundWarningMessage.getText();
		boolean actualEmailNotFoundErrorMessageStatus = actualEmailNotFoundErrorMessage.equals(expectedEmailNotFoundErrorMessage);
		return actualEmailNotFoundErrorMessageStatus;
	}
	
	public void verifyEmailNotFoundMessage() {
		continueButton.click();
	}
}
