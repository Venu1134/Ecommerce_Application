package com.TN.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Objects
	@FindBy(id = "input-firstname")
	private WebElement firstNameTextField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTextField;

	@FindBy(id = "input-email")
	private WebElement emailTextField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextField;

	@FindBy(id = "input-password")
	private WebElement passwordTextField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//*[@name='newsletter'][@value='1']")
	private WebElement subscribeYes;

	@FindBy(xpath = "//*[@name='newsletter'][@value='0']")
	private WebElement subscribeNo;

	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//*[text()=' Warning: E-Mail Address is already registered!']")
	private WebElement emailExistsWarningMessage;

	@FindBy(xpath = "//*[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//*[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//*[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//*[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//*[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//*[text()=' Warning: You must agree to the Privacy Policy!']")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath="//*[@class='text-danger']")
	private WebElement passwordMismatch;
	
	// Actions
	public void enterFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailTextField.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		telephoneTextField.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTextField.sendKeys(confirmPassword);
	}

	public void clickOnPrivacypolicyCheckBox() {
		privacyPolicyCheckBox.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public boolean verifyEmailExistsWarningMessage() {
		return emailExistsWarningMessage.isDisplayed();
	}

	public void clickOnSubscribeYes() {
		subscribeYes.click();
	}

	public String firstNameWarningMessage() {
		String actualFirstNameWarningMessage = firstNameWarningMessage.getText();
		return actualFirstNameWarningMessage;
	}

	public String lastNameWarningMessage() {
		String actualLastNameWarningMessage = lastNameWarningMessage.getText();
		return actualLastNameWarningMessage;
	}

	public String emailWarningMessage() {
		String actualEmailWarningMessage = emailWarningMessage.getText();
		return actualEmailWarningMessage;
	}

	public String telephoneWarningMessage() {
		String actualTelephoneWarningMessage = telephoneWarningMessage.getText();
		return actualTelephoneWarningMessage;
	}

	public String passwordWarningMessage() {
		String actualPasswordWarningMessage = passwordWarningMessage.getText();
		return actualPasswordWarningMessage;
	}

	public String privacyPolicyWarningMessage() {
		String actualPrivacyPolicyWarningMesssage = privacyPolicyWarningMessage.getText();
		return actualPrivacyPolicyWarningMesssage;
	}
	
	public String passwordMismatch() {
		String actualPasswordMismatchWarningMessage = passwordMismatch.getText();
		return actualPasswordMismatchWarningMessage;
	}

	public AccountSuccessPage registerWithMandatoryFields(String firstName, String lastName, String email,
			String telephone, String password) {
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(email);
		telephoneTextField.sendKeys(telephone);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(password);
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public AccountSuccessPage registerWithAllFields(String firstName, String lastName, String email, String telephone,
			String password) {
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(email);
		telephoneTextField.sendKeys(telephone);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(password);
		subscribeYes.click();
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public boolean verifyWarningMessages(String expectedPrivacyWarningMessage, String expectedFirstNameWarningMessages,
			String expectedLastNameWarningMessage, String expectedEmailWarningMessage,
			String expectedTelephoneWarningMessage, String expectedPasswordWarningMessage) {

		boolean privacyPolicyWarningMessageStatus = privacyPolicyWarningMessage.getText()
				.equals(expectedPrivacyWarningMessage);

		boolean firstNameWarningMessageStatus = firstNameWarningMessage.getText()
				.equals(expectedFirstNameWarningMessages);

		boolean lastNameWarningMessageStatus = lastNameWarningMessage.getText().equals(expectedLastNameWarningMessage);

		boolean emailWarningMessageStatus = emailWarningMessage.getText().equals(expectedEmailWarningMessage);

		boolean telephoneWarningMessageStatus = telephoneWarningMessage.getText()
				.equals(expectedTelephoneWarningMessage);

		boolean passwordWarningMessageStatus = passwordWarningMessage.getText().equals(expectedPasswordWarningMessage);

		return privacyPolicyWarningMessageStatus && firstNameWarningMessageStatus && lastNameWarningMessageStatus
				&& emailWarningMessageStatus && telephoneWarningMessageStatus && passwordWarningMessageStatus;
	}
	
	public void registerAccountWithDifferentPasswords(String firstName, String lastName, String email, String telephone,
			String password, String confirmPassword) {
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(email);
		telephoneTextField.sendKeys(telephone);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(confirmPassword);
		subscribeYes.click();
		privacyPolicyCheckBox.click();
		continueButton.click();
	}
	
	public boolean verifyPasswordMismatchWarningMessage(String expectedPasswordMismatchWarningMessage) {
		boolean passwordMismatchWarningMessageStatus = passwordMismatch.getText().equals(expectedPasswordMismatchWarningMessage);
		return passwordMismatchWarningMessageStatus;
	}
}
