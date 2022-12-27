package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	@FindBy(xpath="//*[contains(text(),'Shopping Cart')]")
	private WebElement cartButton;
	
	//Actions
	public void clickOnAddToCart() {
		cartButton.click();
	}
}
