package pageUI;

public class RegisterPageUI {
	public static final String MALE_RADIO_BTN = "//span/label[text()='Male']";
	public static final String FEMALE_RADIO_BTN = "//span/label[text()='Female']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@name='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@name='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@name='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@name='ConfirmPassword']";
	public static final String FIRST_NAME_ERROR_SPAN = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_SPAN = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_SPAN = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_SPAN = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_SPAN = "//span[@id='ConfirmPassword-error']";
	public static final String DATE_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String REGISTER_BUTTON = "//div[@class='buttons']//button[text()='Register']";
	public static final String REGISTER_SUCCESSFUL_MSG = "//div[@class='result']";
	public static final String CONTINUE_BUTTON = "//div[@class='buttons']/a[text()='Continue']";
}
