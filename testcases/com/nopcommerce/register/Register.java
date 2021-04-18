package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.PageObjectManager;
import pageObjects.nopCommerce.UserRegisterPO;

public class Register extends BaseTest {

	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
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
		log.info("TC_02_Register_With_Wrong_Email - Step 1: Enter wrong email ");
		registerPage.sendKeyToEmail("a");
		
		log.info("TC_02_Register_With_Wrong_Email - Step 2: Click enter button ");
		registerPage.clickToRegisterButton();
		
		log.info("TC_02_Register_With_Wrong_Email - Step 3:  Verify wrong email error message displayed");
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
	//@Test
	public void TC_05_Register_With_Unmatching_Confirm_Password() {
		registerPage.refresh(driver);
		registerPage.registerUser(firstName, lastName, email, "123456", "589589" );
		
		Assert.assertTrue(registerPage.isUnmatchingConfirmPasswordErrorMessageDisplayed());
	}
	@Test
	public void TC_06_Register_With_Valid_Data() {
		registerPage.refresh(driver);
		
		log.info("TC_06_Register_With_Valid_Data - Step 1: Register with firstName= " + firstName + " and lastName= " + lastName + " and email= " + email + " and password= " + password);
		registerPage.registerUser(firstName, lastName, email, password );
		
		log.info("TC_06_Register_With_Valid_Data - Step 2: Verify that register with valid user is successful");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("TC_06_Register_With_Valid_Data - Step 3: Verify that Register Link is not displayed");
		verifyTrue(registerPage.isRegisterPageUndisplayed(driver));
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
