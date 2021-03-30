package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isMyDashboardHeaderDisplayed() {
		waitForElementVisible(driver, MyDashboardUI.MY_DASHBOARD_HEADER);
		return isElementDisplayed(driver, MyDashboardUI.MY_DASHBOARD_HEADER);
	}
}
