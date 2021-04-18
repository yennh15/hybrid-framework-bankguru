package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
	public UserRegisterPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private WebDriver driver;

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO_BUTTON);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.SUCCESS_MESSAGE);
	}

	public UserHomePO clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageObjectManager.getUserHomePage(driver);
	}

	public boolean isFirstNameErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public boolean isLastNameErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public boolean isEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public boolean isPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public boolean isConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void sendKeyToEmail(String emailValue) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailValue);

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
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public boolean isAtLeast6CharacterPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.RULE_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.RULE_PASSWORD_ERROR_MESSAGE)
				&& isElementDisplayed(driver, UserRegisterPageUI.AT_LEAST_6_CHARACTER_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isUnmatchingConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.UNMATCHING_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.UNMATCHING_PASSWORD_ERROR_MESSAGE);
	}

	

}
