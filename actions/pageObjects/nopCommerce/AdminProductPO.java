package pageObjects.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.AdminProductUI;

public class AdminProductPO extends BasePage {
	WebDriver driver;

	public AdminProductPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(int pageIndex) {
		waitForElementInvisable(driver, AdminProductUI.LOADING_STATUS);
		waitForElementClickable(driver, AdminProductUI.PAGING_AT_TABLE_BY_INDEX, String.valueOf(pageIndex));
		clickToElement(driver, AdminProductUI.PAGING_AT_TABLE_BY_INDEX, String.valueOf(pageIndex));
	}

	public boolean isPageDisplayed(int pageIndex) {
		waitForElementInvisable(driver, AdminProductUI.LOADING_STATUS);
		return isElementDisplayed(driver, AdminProductUI.ACTIVE_PAGE_AT_TABLE, String.valueOf(pageIndex));
	}

	public void checkToSelectAllCheckbox() {
		waitForElementInvisable(driver, AdminProductUI.LOADING_STATUS);
		waitForElementClickable(driver, AdminProductUI.MASTER_CHECKBOX);
		if (!isElementSelected(driver, AdminProductUI.MASTER_CHECKBOX)) {
			clickToElement(driver, AdminProductUI.MASTER_CHECKBOX);
		}
	}

	public void uncheckToSelectAllCheckbox() {
		waitForElementInvisable(driver, AdminProductUI.LOADING_STATUS);
		waitForElementClickable(driver, AdminProductUI.MASTER_CHECKBOX);
		if (isElementSelected(driver, AdminProductUI.MASTER_CHECKBOX)) {
			clickToElement(driver, AdminProductUI.MASTER_CHECKBOX);
		}
	}

	public boolean areCheckboxesSelected() {
		List<WebElement> allCheckboxes = getElements(driver, AdminProductUI.ALL_CHECKBOXES);
		int expectedCount = allCheckboxes.size();
		int actualCount = 0;
		for (WebElement checkboxInstance : allCheckboxes) {
			if (checkboxInstance.isSelected()) {
				actualCount++;
			}
		}
		if (actualCount == expectedCount) {
			return true;
		}
		return false;

	}

	public boolean areCheckboxesDeselected() {
		List<WebElement> allCheckboxes = getElements(driver, AdminProductUI.ALL_CHECKBOXES);
		int expectedCount = allCheckboxes.size();
		int actualCount = 0;
		for (WebElement checkboxInstance : allCheckboxes) {
			if (!checkboxInstance.isSelected()) {
				actualCount++;
			}
		}
		if (actualCount == expectedCount) {
			return true;
		}
		return false;

	}

	public void checkToProductCheckboxByName(String productName) {
		waitForElementVisible(driver, AdminProductUI.CHECKBOX_BY_NAME, productName);
		checkTheCheckboxOrRadio(driver, AdminProductUI.CHECKBOX_BY_NAME, productName);
	}

	public boolean isCheckboxByNameSelected(String productName) {
		return isElementSelected(driver, AdminProductUI.CHECKBOX_BY_NAME, productName);
	}

	public boolean isProductDetailDisplayed(String productName, String sKU, String price, String stockQuantity,
			String published, String edit) {
		waitForElementVisible(driver, AdminProductUI.PRODUCT_DETAIL, productName, sKU, price, stockQuantity, published,
				edit);
		return isElementDisplayed(driver, AdminProductUI.PRODUCT_DETAIL, productName, sKU, price, stockQuantity,
				published, edit);
	}

	public void showItemNumberAtTable(String quantity) {
		waitForAllElementVisible(driver, AdminProductUI.SHOWED_ITEM_NUMBER_PER_PAGE);
		selectItemInDropDown(driver, AdminProductUI.SHOWED_ITEM_NUMBER_PER_PAGE, quantity);

	}

	public void waitForLoading() {
		waitForElementInvisable(driver, AdminProductUI.LOADING_STATUS);
	}

	public boolean isInformationDisplayedAtRowAndColumn(String column, int rowNumber, String expectedValue) {
		waitForLoading();
		int precedingColumnCount = getElementSize(driver, AdminProductUI.PRECEDING_COLUMN, column) + 1;
		String actualValue=getElementText(driver, AdminProductUI.CELL_BY_ROW_AND_COLUMN,String.valueOf(rowNumber), String.valueOf(precedingColumnCount));
		return actualValue.equals(expectedValue);
	}

}
