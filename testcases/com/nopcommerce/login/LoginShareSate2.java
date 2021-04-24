package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Register;

import commons.BaseTest;
import pageObjects.nopCommerce.PageObjectManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserRegisterPO;

public class LoginShareSate2 extends BaseTest {
	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = initBrowser(browserName, appUrl);
		homePage = PageObjectManager.getUserHomePage(driver);

	}

	@Test
	public void TC_01_Login_With_Valid_Data() {
		log.info("TC_01_Login_With_Valid_Data - Step 1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		
		sleepInSecond(1);
		
		log.info("TC_01_Login_With_Valid_Data - Step 2: Enter to Email textbox with value "+ Register.email);
		loginPage.enterToEmailTextbox(Register.email);
		
		log.info("TC_01_Login_With_Valid_Data - Step 3: Enter to Password textbox with value "+ Register.email);
		loginPage.enterToPasswordTextbox(Register.password);
		
		log.info("TC_01_Login_With_Valid_Data - Step 4: Click to Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_01_Login_With_Valid_Data - Step 5: Verify My Account Link is displayed");
		verifyTrue(homePage.isLogOutLinkDisplayed());
		
		 
	}

	

	@AfterClass
	public void cleanBrowser() {
		// driver.quit();
	}
}
