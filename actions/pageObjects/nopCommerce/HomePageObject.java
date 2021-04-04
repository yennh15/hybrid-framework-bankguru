package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		System.out.println("Yen test register");
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageObjectManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageObjectManager.getLoginPage(driver);
	}

	public boolean isHomePageDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

}
