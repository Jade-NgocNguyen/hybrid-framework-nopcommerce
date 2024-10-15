package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		this.waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		this.clickToElement(driver, HomePageUI.REGISTER_LINK);	
		return PageGeneratorManager.GetRegisterPage(driver);
	}

	public boolean isRegisterLinkDisplayed() {
		this.waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return this.isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

	public LoginPageObject clickToLoginLink() {
		this.waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		this.clickToElement(driver, HomePageUI.LOGIN_LINK);	
		return PageGeneratorManager.GetLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		this.waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return this.isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		this.waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		this.clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.GetCustomerInfoPage(driver);
	}

}
