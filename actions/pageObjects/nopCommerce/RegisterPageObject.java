package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private WebDriver driver;

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageObjectManager.getHomePage(driver);
	}

	public boolean isFirstNameErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public boolean isLastNameErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public boolean isEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public boolean isPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public boolean isConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void sendKeyToEmail(String emailValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);

	}

	

	public void registerUser(String firstName, String lastName, String email, String password) {
		enterToFirstNameTextbox(firstName);
		enterToLastNameTextbox(lastName);
		enterToEmailTextbox(email);
		enterToPasswordTextbox(password);
		enterToConfirmPasswordTextbox(password);
		clickToRegisterButton();
	}
	public void registerUser(String firstName, String lastName, String email, String password, String confirmPassword) {
		enterToFirstNameTextbox(firstName);
		enterToLastNameTextbox(lastName);
		enterToEmailTextbox(email);
		enterToPasswordTextbox(password);
		enterToConfirmPasswordTextbox(confirmPassword);
		clickToRegisterButton();
	}

	public boolean isExstingEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public boolean isAtLeast6CharacterPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.RULE_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.RULE_PASSWORD_ERROR_MESSAGE)
				&& isElementDisplayed(driver, RegisterPageUI.AT_LEAST_6_CHARACTER_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isUnmatchingConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.UNMATCHING_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.UNMATCHING_PASSWORD_ERROR_MESSAGE);
	}

}
