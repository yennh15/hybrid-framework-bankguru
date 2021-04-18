package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.UserLoginPageUI;


public class UserLoginPO extends BasePage {

	private WebDriver driver;

	public UserLoginPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePO clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageObjectManager.getUserHomePage(driver);
	}
	
	public void clickToLoginButtonWithoutChangePage() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitForAllElementVisible(driver, UserLoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		clickToElement(driver, UserLoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return false;
	}

	public void loginError(String email, String password) {
		enterToEmailTextbox(email);
		enterToPasswordTextbox(password);
		clickToLoginButtonWithoutChangePage();		
	}

}
