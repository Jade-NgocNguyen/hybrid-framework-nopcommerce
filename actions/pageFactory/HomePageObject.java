package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginLink;
	
	@FindBy(xpath = "//div[@class='header']//a[text()='My account']")
	WebElement myAccLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToRegisterLink() {
		this.clickToElement(this.registerLink);	
	}

	public boolean isRegisterLinkDisplayed() {
		this.waitForElementVisible(driver, this.registerLink);
		return this.isElementDisplayed(this.registerLink);
	}

	public void clickToLoginLink() {
		this.waitForElementClickable(driver, this.loginLink);
		this.clickToElement(this.loginLink);	
	}

	public boolean isMyAccountLinkDisplayed() {
		this.waitForElementVisible(driver, this.myAccLink);
		return this.isElementDisplayed(this.myAccLink);
	}

	public void clickToMyAccountLink() {
		this.waitForElementClickable(driver, this.myAccLink);
		this.clickToElement(this.myAccLink);	
	}
}
