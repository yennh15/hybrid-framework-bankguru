package commons;

public class DynamicLocator {
	public static void main(String[] args) {
		String DYNAMIC_LINK_1="//a[text()='%s']";
		clickToElement(DYNAMIC_LINK_1, "Customer");
		
	}
	public static void clickToElement(String pageName, String dynamicValue) {
		System.out.println(String.format(pageName, dynamicValue));
	}
}
