package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserOrderPO extends BasePage{
	WebDriver driver;

	public UserOrderPO(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
