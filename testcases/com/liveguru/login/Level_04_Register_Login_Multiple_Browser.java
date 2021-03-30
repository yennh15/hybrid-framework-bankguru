package com.liveguru.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {
	String projectLocation = System.getProperty("user.dir");
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = initBrowser(browserName); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		// Step 1: Open URL => Home Page
		driver.get("http://live.demoguru99.com/index.php/");
		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refresh(driver);
		loginPage.enterToEmailTextbox("123@456.789");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {
		loginPage.refresh(driver);
		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test(description = "Email does not exist in the system")
	public void Login_04_Incorrect_Email() {
		loginPage.refresh(driver);
		loginPage.enterToEmailTextbox("1dam@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refresh(driver);
		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123678");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void Login_06_Valid_Email_And_Password() {

		loginPage.refresh(driver);
		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboard = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboard.isMyDashboardHeaderDisplayed());
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;
}
