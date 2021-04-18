package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}


	public String getEmptyPasswordErrorMessage() {
		waitForAllElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_MESSAGE);
	}

	public String getEmptyEmailErrorMessage() {
		waitForAllElementVisible(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.VALIDATE_EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.VALIDATE_EMAIL_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.VALIDATE_PASSWORD_MESSAGE);
		return getElementText(driver, LoginPageUI.VALIDATE_PASSWORD_MESSAGE);
	}

	public String getIncorrectEmailOrPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_MESSAGE);
	}
}
