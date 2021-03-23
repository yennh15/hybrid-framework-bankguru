package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitAlertPresent(WebDriver driver) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresent(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresent(driver);
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		waitAlertPresent(driver);
		return alert.getText();
	}

	public void sendKeytoAlert(WebDriver driver, String text) {
		waitAlertPresent(driver);
		alert.sendKeys(text);
	}

	public void switchWindowByID(WebDriver driver, String parrentID) {
		Set<String> windownList = driver.getWindowHandles();
		for (String currentWindowID : windownList) {
			if (!currentWindowID.equals(parrentID)) {
				driver.switchTo().window(currentWindowID);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> windownList = driver.getWindowHandles();

		for (String currentWindowID : windownList) {
			driver.switchTo().window(currentWindowID);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindownWithoutParrent(WebDriver driver, String parrentTitle) {
		Set<String> windownList = driver.getWindowHandles();

		for (String currentWindowID : windownList) {
			driver.switchTo().window(currentWindowID);
			if (!driver.getTitle().equals(parrentTitle)) {
				driver.close();
			}
		}
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String text) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(text);
	}

	public void selectItemInDropDown(WebDriver driver, String locator, String value) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(value);
	}

	public void getSelectedItemInDropDown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		select.getFirstSelectedOption();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void waitUtilAllItemDisplayed(WebDriver driver, String locator) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
	}

	public void selectItemInCustomDropDown(WebDriver driver, String dropDownLocator, String valueList,
			String expectedValue) {
		clickToElement(driver, dropDownLocator);
		sleepInSecond(1);
		waitUtilAllItemDisplayed(driver, valueList);
		sleepInSecond(1);
		List<WebElement> elements = getElements(driver, valueList);
		for (WebElement item : elements) {
			if (item.getText().trim().equals(expectedValue)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
			}
		}

	}

	public void sleepInSecond(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public boolean isSelectedElement(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected(); 
	}
	
	public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
		if(!isSelectedElement(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		 if(isSelectedElement(driver, locator)) {
			 getElement(driver, locator).click();
		 }
	}

	private Alert alert;
	private WebDriverWait wait;
	private long timeout = 30000;
	private Select select;
	private JavascriptExecutor jsExecutor;
}
