package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class OrderPageObject extends BasePage{
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
