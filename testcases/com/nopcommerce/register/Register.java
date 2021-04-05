package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageObjectManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Register extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String email;
	String password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = initBrowser(browserName, appUrl);
		homePage = PageObjectManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		email = "yen" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}

	// @Test
	public void TC_01_Register_With_Empty_Data() {
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isFirstNameErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isLastNameErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isEmailErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());

	}

	@Test
	public void TC_02_Register_With_Wrong_Email() {
		registerPage.refresh(driver);
		registerPage.sendKeyToEmail("a");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isWrongEmailErrorMessageDisplayed());
	}

	@Test
	public void TC_03_Register_With_Existing_Email() {
		registerPage.refresh(driver);
		registerPage.registerUser("Yen", "Nguyen", email, password);
		homePage=registerPage.clickToLogoutLink();
		registerPage=homePage.clickToRegisterLink();
		registerPage.registerUser("Yen", "Nguyen", email, password);
		
		Assert.assertTrue(registerPage.isExstingEmailErrorMessageDisplayed());
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
