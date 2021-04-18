package pageUIs.nopCommerce;

public class AdminProductUI {
	public static final String LOADING_STATUS = "//div[@id='ajaxBusy']"; 
	public static final String PAGING_AT_TABLE_BY_INDEX = "//a[@class='page-link' and text()='%s']"; 
	public static final String ACTIVE_PAGE_AT_TABLE = "//li[@class='paginate_button page-item active']/a[@class='page-link' and text()='%s']"; 
	public static final String MASTER_CHECKBOX = "//th[@class='sorting_disabled text-center']/input[@class='mastercheckbox']"; 
	public static final String ALL_CHECKBOXES = "//input[@name='checkbox_products']"; 
	public static final String CHECKBOX_BY_NAME = "//td[text()='%s']/preceding-sibling::td/input[@name='checkbox_products']"; 
	public static final String PRODUCT_DETAIL = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td//i[contains(@class,'%s')]/parent::td/following-sibling::td/a[contains(@href,'%s')]"; 
	public static final String SHOWED_ITEM_NUMBER_PER_PAGE = "//select[@name='products-grid_length']"; 
	public static final String PRECEDING_COLUMN= "//th[text()='%s']/preceding::th"; 
	public static final String CELL_BY_ROW_AND_COLUMN= "//tr[%s]//td[%s]"; 
	
	
}
