package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath="//*[contains(text(),'Congratulations!')]")
	private WebElement accountCreateSuccessMessage;
	
	//Actions
	public boolean verifyAccountCreateSuccessMessage() {
		return accountCreateSuccessMessage.isDisplayed();
	}
}
