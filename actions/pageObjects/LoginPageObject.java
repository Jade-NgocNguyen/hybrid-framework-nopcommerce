package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		this.waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		this.sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		this.waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		this.sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginBtn() {
		this.waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		this.clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.GetHomePage(driver);
	}

}
