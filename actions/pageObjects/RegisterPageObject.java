package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterBtn() {
		this.waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		this.clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.GetRegisterPage(driver);
	}

	public String getAlertTextOnFirstName() {
		this.waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_SPAN);
		return this.getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_SPAN);
	}

	public String getAlertTextOnLastName() {
		this.waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_SPAN);
		return this.getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_SPAN);
	}

	public String getAlertTextOnEmail() {
		this.waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_SPAN);
		return this.getTextElement(driver, RegisterPageUI.EMAIL_ERROR_SPAN);
	}

	public String getAlertTextOnPassword() {
		this.waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_SPAN);
		return this.getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_SPAN);
	}

	public String getAlertTextOnConfirmPassword() {
		this.waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_SPAN);
		return this.getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_SPAN);
	}

	public void clickToMaleRadioBtn() {
		this.waitForElementClickable(driver, RegisterPageUI.MALE_RADIO_BTN);
		this.checkTheCheckboxOrRadio(driver, RegisterPageUI.MALE_RADIO_BTN);
	}

	public void inputToFirstNameTextbox(String firstName) {
		this.waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		this.sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		this.waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		this.sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void selectItemInDateDropdown(String item) {
		this.waitForElementVisible(driver, RegisterPageUI.DATE_DROPDOWN);
		this.selectItemInDropdown(driver, RegisterPageUI.DATE_DROPDOWN, item);
	}

	public void selectItemInMonthDropdown(String item) {
		this.waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		this.selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, item);
	}

	public void selectItemInYearDropdown(String item) {
		this.waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		this.selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, item);
	}

	public void inputToEmailTextbox(String email) {
		this.waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		this.sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		this.waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		this.sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPwdTextbox(String password) {
		this.waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		this.sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public String getRegisterSuccessMsg() {
		this.waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESSFUL_MSG);
		return this.getTextElement(driver, RegisterPageUI.REGISTER_SUCCESSFUL_MSG);
	}

	public void clickToContinueBtn() {
		this.waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		this.clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
	}

}
