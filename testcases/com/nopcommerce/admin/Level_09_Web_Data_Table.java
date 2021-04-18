package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.AdminDashboardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.AdminProductPO;
import pageObjects.nopCommerce.PageObjectManager;

public class Level_09_Web_Data_Table extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = initBrowser(browserName, appUrl);
		loginPage= PageObjectManager.getAdminLoginPage(driver); 
		dashboardPage = loginPage.loginToAdminSystem("admin@yourstore.com","admin");
		dashboardPage.collapseSubMenuItems(driver, "Catalog");
		productPage = dashboardPage.clickSubMenu(driver, "Catalog" , "Products"); 
	}

	//@Test
	public void TC_01_Data_Table() {
		productPage.goToPageAtTableByIndex(2);
		Assert.assertTrue(productPage.isPageDisplayed(2));
	}
	//@Test
	public void TC_02_Select_Deselect_All() {
		productPage.checkToSelectAllCheckbox();
		Assert.assertTrue(productPage.areCheckboxesSelected());
		productPage.uncheckToSelectAllCheckbox();
		Assert.assertTrue(productPage.areCheckboxesDeselected());
		
		productPage.checkToProductCheckboxByName("Digital Storm VANQUISH 3 Custom Performance PC");
		Assert.assertTrue(productPage.isCheckboxByNameSelected("Digital Storm VANQUISH 3 Custom Performance PC"));
		
	}
	@Test
	public void TC_03_Displayed_All() {
		Assert.assertTrue(productPage.isProductDetailDisplayed("Windows 8 Pro", "MS_WIN_8P", "65", "10000", "true", "Edit"));
		productPage.showItemNumberAtTable("50");
		
		Assert.assertTrue(productPage.isInformationDisplayedAtRowAndColumn("Product name", 2, "Digital Storm VANQUISH 3 Custom Performance PC" ));
	}

	@AfterClass
	public void cleanBrowser() {
		//driver.quit();
	}
	
	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;
	
}
