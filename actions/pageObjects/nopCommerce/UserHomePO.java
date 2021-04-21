package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.UserHomePageUI;

public class UserHomePO extends BasePage {
	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageObjectManager.getUserRegisterPage(driver);
	}
	
	/*public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}
*/
	public UserLoginPO clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageObjectManager.getUserLoginPage(driver);
	}

	public boolean isHomePageDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, UserHomePageUI.HOME_PAGE_SLIDER);
	}
	
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	
	public boolean isLogOutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOG_OUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOG_OUT_LINK);
	}

}
