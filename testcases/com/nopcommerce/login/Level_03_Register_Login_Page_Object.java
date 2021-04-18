package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyAccountPO;
import pageObjects.nopCommerce.UserOrderPO;
import pageObjects.nopCommerce.PageObjectManager;
import pageObjects.nopCommerce.UserRegisterPO;
import pageObjects.nopCommerce.UserSearchPO;

public class Level_03_Register_Login_Page_Object extends BaseTest {
	
	WebDriver driver;
	String email;
	String password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = initBrowser(browserName, appUrl);
		// Step 1: Open URL => Home Page
		homePage = PageObjectManager.getUserHomePage(driver);
				//PageObjectManager.getHomePage(driver);
		email = "yen" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}

	@Test
	public void Login_01_Register_To_System() {

		// Step 2 Click to Register Link => Register Page
		
		registerPage = homePage.clickToRegisterLink();;
		sleepInSecond(1);
		// Step 3 Click to Gender male radio
		registerPage.clickToGenderMaleRadioButton();
		// Step 4 Input to Firstname Textbox
		registerPage.enterToFirstNameTextbox("Yen");
		// Step 5 Input to Lastname textbox
		registerPage.enterToLastNameTextbox("Hai");
		// Step 6 Input to Email textbox
		registerPage.enterToEmailTextbox(email);
		// Step 7 Input to Password textbox
		registerPage.enterToPasswordTextbox(password);
		// Step 8 Input to Confirm Password textbox
		registerPage.enterToConfirmPasswordTextbox(password);
		// Step 9 Click to Register button
		registerPage.clickToRegisterButton();
		// Step 10 Verify Success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		// Step 11 Click to Logout link => HomePage
		homePage = registerPage.clickToLogoutLink();
	}

	//@Test
	public void Login_02_Login_To_System() {
		// Step 1 Click To Login Link => Login Page
		loginPage = homePage.clickToLoginLink();
		// Step 2 Input to Email textbox
		loginPage.enterToEmailTextbox(email);
		// Step 3 Input to Password textbox
		loginPage.enterToPasswordTextbox(password);
		// Step 4 Click to Login button => Home Page
		homePage = loginPage.clickToLoginButton();
		// Step 5 Verify Home Page displayed
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	//@Test
	public void Login_03_Switch_Page_At_Footer() {
		searchPage= homePage.openSearchPage(driver);
		orderPage = searchPage.openOrderPage(driver);
		
	}
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	UserHomePO homePage;
	UserLoginPO loginPage;
	UserRegisterPO registerPage;
	UserSearchPO searchPage;
	UserMyAccountPO myAccountPage;
	UserOrderPO orderPage;
}
