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
	String password, firstName, lastName;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = initBrowser(browserName, appUrl);
		homePage = PageObjectManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		email = "yen" + getRandomNumber() + "@gmail.com";
		password = "1234567";
		firstName = "Nguyen";
		lastName = "Yen";
		
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
		Assert.assertTrue(registerPage.isWrongEmailErrorMessageDisplayed(driver));
	}

	//@Test
	public void TC_03_Register_With_Existing_Email() {
		registerPage.refresh(driver);
		registerPage.registerUser(firstName, lastName, email, password);
		homePage=registerPage.clickToLogoutLink();
		registerPage=homePage.clickToRegisterLink();
		registerPage.registerUser(firstName, lastName, email, password);
		
		Assert.assertTrue(registerPage.isExstingEmailErrorMessageDisplayed());
	}
	
	//@Test
	public void TC_04_Register_With_Password_Less_Than_6() {
		registerPage.refresh(driver);
		registerPage.registerUser(firstName, lastName, email, "123456");
		
		Assert.assertTrue(registerPage.isAtLeast6CharacterPasswordErrorMessageDisplayed());
	}
	@Test
	public void TC_05_Register_With_Unmatching_Confirm_Password() {
		registerPage.refresh(driver);
		registerPage.registerUser(firstName, lastName, email, "123456", "589589" );
		
		Assert.assertTrue(registerPage.isUnmatchingConfirmPasswordErrorMessageDisplayed());
	}
	@Test
	public void TC_06_Register_With_Valid_Data() {
		registerPage.refresh(driver);
		registerPage.registerUser(firstName, lastName, email, password );
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
	}

	@AfterClass
	public void cleanBrowser() {
	//	driver.quit();
	}
}
