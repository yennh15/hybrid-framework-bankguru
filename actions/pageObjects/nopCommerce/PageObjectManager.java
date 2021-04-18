package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private static UserHomePO homePage;
	private static UserLoginPO loginPage;
	private static UserRegisterPO registerPage;
	private static UserSearchPO searchPage;
	private static UserMyAccountPO myAccountPage;
	private static UserOrderPO orderPage;
	private static AdminLoginPO adminLoginPage;
	private static AdminDashboardPO adminDashboardPage;
	private static AdminProductPO adminProductPage;

	/*
	 * public static HomePageObject getHomePage(WebDriver driver) { if (homePage ==
	 * null) { homePage = new HomePageObject(driver); } return homePage; }
	 * 
	 * public static LoginPageObject getLoginPage(WebDriver driver) { if (loginPage
	 * == null) { loginPage = new LoginPageObject(driver); } return loginPage; }
	 * 
	 * public static RegisterPageObject getRegisterPage(WebDriver driver) { if
	 * (registerPage == null) { registerPage = new RegisterPageObject(driver); }
	 * return registerPage;
	 * 
	 * } public static SearchPageObject getSearchPage(WebDriver driver) { if
	 * (searchPage == null) { searchPage = new SearchPageObject(driver); } return
	 * searchPage;
	 * 
	 * } public static MyAccountPageObject getMyAccountPage(WebDriver driver) { if
	 * (myAccountPage == null) { myAccountPage = new MyAccountPageObject(driver); }
	 * return myAccountPage;
	 * 
	 * } public static OrderPageObject getOrderPage(WebDriver driver) { if
	 * (orderPage == null) { orderPage = new OrderPageObject(driver); } return
	 * orderPage; }
	 * 
	 */
	public static UserHomePO getUserHomePage(WebDriver driver) {

		homePage = new UserHomePO(driver);
		return homePage;

	}

	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		loginPage = new UserLoginPO(driver);
		return loginPage;
	}

	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {

		registerPage = new UserRegisterPO(driver);
		return registerPage;
	}

	public static UserSearchPO getUserSearchPage(WebDriver driver) {

		searchPage = new UserSearchPO(driver);
		return searchPage;
	}

	public static UserMyAccountPO getUserMyAccountPage(WebDriver driver) {

		myAccountPage = new UserMyAccountPO(driver);
		return myAccountPage;
	}

	public static UserOrderPO getUserOrderPage(WebDriver driver) {
		
		orderPage = new UserOrderPO(driver);
		return orderPage;
	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		
		adminLoginPage = new AdminLoginPO(driver);
		return adminLoginPage;
	}
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		
		adminDashboardPage = new AdminDashboardPO(driver);
		return adminDashboardPage;
	}
	public static AdminProductPO getProductPage(WebDriver driver) {

		adminProductPage = new AdminProductPO(driver);
		return adminProductPage;
	}
}
