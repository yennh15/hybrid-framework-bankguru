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
import pageObjects.nopCommerce.PageObjectManager;
import pageObjects.nopCommerce.UserRegisterPO;

public class Login extends BaseTest {
	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	String email;
	String password, firstName, lastName;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = initBrowser(browserName, appUrl);
		homePage = PageObjectManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		email = "yen" + getRandomNumber() + "@gmail.com";
		password = "1234567";
		firstName = "Nguyen";
		lastName = "Yen";

	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	}

	@Test
	public void TC_02_Login_With_Wrong_Email() {
		loginPage.refresh(driver);
		loginPage.enterToEmailTextbox("a");
		Assert.assertTrue(loginPage.isWrongEmailErrorMessageDisplayed(driver));
	}
	@Test
	public void TC_03_Login_With_Nonexistent_Email() {
		loginPage.refresh(driver);
		loginPage.loginError("nonexistent@nongmail.com","12345689");
		Assert.assertTrue(loginPage.isWrongEmailErrorMessageDisplayed(driver));
	}

	@AfterClass
	public void cleanBrowser() {
		// driver.quit();
	}
}
