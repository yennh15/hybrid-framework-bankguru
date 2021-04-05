package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
