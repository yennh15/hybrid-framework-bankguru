package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserMyAccountPO extends BasePage {
	WebDriver driver;

	public UserMyAccountPO(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
