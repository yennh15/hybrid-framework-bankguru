package pageUIs.nopCommerce;

public class UserRegisterPageUI {
	public static final String GENDER_MALE_RADIO_BUTTON = "//input[@id='gender-male']"; 
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']"; 
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']"; 
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']"; 
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']"; 
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']"; 
	public static final String REGISTER_BUTTON = "//button[@id='register-button']"; 
	public static final String SUCCESS_MESSAGE = "//div[text()='Your registration completed']"; 
	public static final String LOGOUT_LINK = "//a[text()='Log out']"; 
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error' and text()='First name is required.']"; 
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error' and text()='Last name is required.']"; 
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error' and text()='Email is required.']"; 
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error' and text()='Password is required.']"; 
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error' and text()='Password is required.']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors']//li[text()='The specified email already exists']";
	public static final String RULE_PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']//p[text()='Password must meet the following rules: ']";
	public static final String AT_LEAST_6_CHARACTER_PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']//li[text()='must have at least 6 characters']";
	public static final String UNMATCHING_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error' and text()='The password and confirmation password do not match.']";	
}
