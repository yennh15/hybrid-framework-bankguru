package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXT_BOX);
		sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXT_BOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	public AdminDashboardPO clickLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageObjectManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPO loginToAdminSystem(String email, String password) {
		enterToEmailTextbox(email);
		enterToPasswordTextbox(password);
		return clickLoginButton();
	}
	
}
