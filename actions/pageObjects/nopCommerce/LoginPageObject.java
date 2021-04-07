package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;


public class LoginPageObject extends BasePage {

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

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageObjectManager.getHomePage(driver);
	}
	
	public void clickToLoginButtonWithoutChangePage() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitForAllElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		clickToElement(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return false;
	}

	public void loginError(String email, String password) {
		enterToEmailTextbox(email);
		enterToPasswordTextbox(password);
		clickToLoginButtonWithoutChangePage();		
	}

}
