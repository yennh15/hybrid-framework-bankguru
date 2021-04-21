package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import io.qameta.allure.Feature;
import pageObjects.nopCommerce.PageObjectManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserRegisterPO;

@Feature("User")
public class Register extends BaseTest {

	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	public static String email, password ;
	String firstName, lastName;
	
	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		driver = initBrowser(browserName, appUrl);
		homePage = PageObjectManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		email = "yen" + getRandomNumber() + "@gmail.com";
		password = "1234567";
		firstName = "Nguyen";
		lastName = "Yen";
	
		log.info("TC_Common_Register_With_Valid_Data - Step 1: Register with firstName= " + firstName + " and lastName= " + lastName + " and email= " + email + " and password= " + password);
		registerPage.registerUser(firstName, lastName, email, password );
		
		log.info("TC_Common_Register_With_Valid_Data - Step 2: Verify that register with valid user is successful");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		driver.quit();
	}

}
