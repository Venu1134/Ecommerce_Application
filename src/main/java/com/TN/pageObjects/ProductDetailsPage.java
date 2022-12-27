package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	@FindBy(id="input-quantity")
	private WebElement quantityTextField;
	
	@FindBy(id="input-option225")
	private WebElement deliveryDate;
	
	@FindBy(id="button-cart")
	private WebElement AddToCartButton;
	
	@FindBy(xpath="//*[contains(text(),'Success: You have added ')]")
	private WebElement productAddedConfirmationMessage;
	
	//Actions
	public void enterQuantity(String quantity) {
		quantityTextField.clear();
		quantityTextField.sendKeys(quantity);
	}
	
	public void enterDeliveryDate(String DeliveryDate) {
		deliveryDate.clear();
		deliveryDate.sendKeys(DeliveryDate);
	}
	
	public AddToCartPage clickOnAddToCart() {
		AddToCartButton.click();
		return new AddToCartPage(driver);
	}
	
	public boolean verifyAddToCartConfirmationMessage(String expectedProductAddedConfirmationMessage) {
		String actualProductAddedConfirmationMessage = productAddedConfirmationMessage.getText();
		System.out.println(actualProductAddedConfirmationMessage);
		boolean actualProductAddedConfirmationMessageStatus = actualProductAddedConfirmationMessage.contains(expectedProductAddedConfirmationMessage);
		return actualProductAddedConfirmationMessageStatus;
	}
	
}
