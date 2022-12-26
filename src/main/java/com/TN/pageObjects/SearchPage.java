package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	@FindBy(linkText="HP LP3065")
	private WebElement validProductName;
	
	@FindBy(xpath="//*[@id='button-search']/following-sibling::p")
	private WebElement TextMessageForNoProduct;
	
	public boolean verifyProductName() {
		return validProductName.isDisplayed();
	}
	
	public String verifyActualTextMessageForNoProduct() {
		String actualTextMessageForNoProduct = TextMessageForNoProduct.getText();
		return actualTextMessageForNoProduct;
	}
}
