package not.nopcommerce.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {
	String projectLocation = System.getProperty("user.dir");
	WebDriver driver;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		//Step 1: Open URL => Home Page
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Register_To_System() {
		//Step 2 Click to Register Link => Register Page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver); 
		//Step 3 Click to Gender male radio
		registerPage.clickToGenderMaleRadioButton();
		//Step 4 Input to Firstname Textbox
		registerPage.enterToFirstNameTextbox(""); 
		//Step 5 Input to Lastname textbox
		registerPage.enterToLastNameTextbox(""); 
		//Step 6 Input to Email textbox
		registerPage.enterToEmailTextbox("");
		//Step 7 Input to Password textbox
		registerPage.enterToPasswordTextbox("");
		//Step 8 Input to Confirm Password textbox
		registerPage.enterToConfirmPasswordTextbox("");
		//Step 9 Click to Register button
		registerPage.clickToRegisterButton();
		//Step 10 Verify Success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());	
		//Step 11 Click to Logout link => HomePage
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void Login_02_Login_To_System() {
		//Step 1 Click To Login Link => Login Page
		homePage.clickToLoginLink(); 
		loginPage = new LoginPageObject(driver);
		//Step 2 Input to Email textbox
		loginPage.enterToEmailTextbox(""); 
		//Step 3 Input to Password textbox
		loginPage.enterToPasswordTextbox(""); 
		//Step 4 Click to Login button => Home Page 
		loginPage.clickToLoginButton(); 
		homePage = new HomePageObject(driver);
		//Step 5 Verify Home Page displayed
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	
	HomePageObject homePage; 
	LoginPageObject loginPage; 
	RegisterPageObject registerPage; 
}
