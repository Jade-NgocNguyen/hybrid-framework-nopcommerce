package pageObjects;

import org.openqa.selenium.WebDriver;

import pageUI.CustomerInfoPageUI;

public class CustomerInfoPageObject extends SidebarPageObject{
	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMaleRadioChecked() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.MALE_RADIO_BTN);
		return this.isElementSelected(driver, CustomerInfoPageUI.MALE_RADIO_BTN);
	}

	public String getTextOnFirstNameTextBox() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return this.getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getTextOnLastNameTextBox() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return this.getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getSelectedItemOnDateDropdown() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.DATE_DROPDOWN);
		return this.getSelectedItemInDropdown(driver, CustomerInfoPageUI.DATE_DROPDOWN);
	}

	public String getSelectedItemOnMonthDropdown() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return this.getSelectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedItemOnYearDropdown() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return this.getSelectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getTextOnEmailTextbox() {
		this.waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return this.getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

}
