package pageUIs.nopCommerce;

public class PageUIs {
	public static final String SEARCH_LINK_AT_FOOTER = "//div[@class='footer']//a[text()='Search']"; 
	public static final String MY_ACCOUNT_LINK_AT_FOOTER = "//div[@class='footer']//a[text()='My account']"; 
	public static final String ORDERS_LINK_AT_FOOTER = "//div[@class='footer']//a[text()='Orders']"; 
	public static final String WRONG_EMAIL_ERROR_MESSAGE = "//span[@id='Email-error' and text()='Wrong email']";
	
	public static final String COLLAPSED_SUB_MENU_ARROW = "//li[@class='nav-item has-treeview']//p[contains(text(),'%s')]/i[@class='right fas fa-angle-left ']";
	public static final String SUB_MENU_ITEM = "//li[@class='nav-item has-treeview menu-open']//p[contains(text(),'%s')]/parent::a/following-sibling::ul//p[text()=' %s']";
	
	public static final String REGISTER_LINK = "//a[text()='Register']"; 
}
