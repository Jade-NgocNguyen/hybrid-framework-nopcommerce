package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.OrderPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Users_01_Register extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	MyProductReviewPageObject myProductReviewPage;
	OrderPageObject orderPage;
	RewardPointsPageObject rewardPointsPage;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public void beforeClass(@Optional("chrome") String browser, String url) {
			this.driver = this.getBrowserDriver(browser, url);
			homePage = PageGeneratorManager.GetHomePage(driver);
		}

	@Test(groups = { "regression", "users" })
	public void Register_01_EmptyData() {
		log.info("TC 01: Register with empty data");
		log.info("Register - Step 01: navigate to register page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: click to register button");
		registerPage.clickToRegisterBtn();
		
		log.info("Register - Step 03: verify that message First name is required. is displayed for the First name text box");
		Assert.assertEquals(registerPage.getAlertTextOnFirstName(), "First name is required.");
		
		log.info("Register - Step 04: verify that message Last name is required. is displayed for the Last name text box");
		Assert.assertEquals(registerPage.getAlertTextOnLastName(), "Last name is required.");
		
		log.info("Register - Step 05: verify that message Email is required. is displayed for the Email text box");
		Assert.assertEquals(registerPage.getAlertTextOnEmail(), "Email is required.");
		
		log.info("Register - Step 06: verify that message Password is required. is displayed for the Password text box");
		Assert.assertEquals(registerPage.getAlertTextOnPassword(), "Password is required.");
		
		log.info("Register - Step 07: verify that message Password is required. is displayed for the Confirmation password text box");
		Assert.assertEquals(registerPage.getAlertTextOnConfirmPassword(), "Password is required.");
	}

	@Test(groups = { "users" })
	public void Register_02_ValidData() {
		String firstName = "Test";
		String lastName = "User_" + this.genRandomNumber();
		String email = firstName + lastName + "@gmail.com";
		String password = "ABC123";
		String registerSuccessMsg = "Your registration completed";
		
		log.info("TC 01: Register with valid data");
		log.info("Register - Step 01: select Male radio button");
		registerPage.clickToMaleRadioBtn();
		
		log.info("Register - Step 02: fill in the first name text box with '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 03: fill in the last name text box with '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 04: select date 15 in the Date dropdown list");
		registerPage.selectItemInDateDropdown("15");
		
		log.info("Register - Step 05: select month Februray in the Month dropdown list");
		registerPage.selectItemInMonthDropdown("February");
		
		log.info("Register - Step 06: select 1992 in the Year dropdown list");
		registerPage.selectItemInYearDropdown("1992");
		
		log.info("Register - Step 07: fill in the email text box with '" + firstName + "'");
		registerPage.inputToEmailTextbox(email); 
		
		log.info("Register - Step 08: fill in the password text box with '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 09: fill in the confirm password text box with '" + password + "'");
		registerPage.inputToConfirmPwdTextbox(password);
		
		log.info("Register - Step 10: click on the register button");
		registerPage.clickToRegisterBtn();
		
		log.info("Register - Step 11: Verify that" + registerSuccessMsg + "is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMsg(), registerSuccessMsg);
		
		log.info("Register - Step 12: click on the Continue button");
		registerPage.clickToContinueBtn();
		
		log.info("Register - Step 13: verify that the register link is displayed");
		Assert.assertTrue(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 14: click on the Login button");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Register - Step 15: fill in the Email text box with '" + email + "'");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 16: fill in the Password text box with " + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 17: click on the Login button");
		loginPage.clickToLoginBtn();
		
		log.info("Register - Step 18: verify that the My Account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Register - Step 19: click on the My Account link");
		customerInfoPage = homePage.clickToMyAccountLink();
		
		log.info("Register - Step 20: verify that the Male radio button is checked");
		Assert.assertTrue(customerInfoPage.isMaleRadioChecked());
		
		log.info("Register - Step 21: verify that value of the first name text box is '" + firstName + "'");
		Assert.assertEquals(customerInfoPage.getTextOnFirstNameTextBox(), firstName);
		
		log.info("Register - Step 22: verify that value of the last name text box is '" + lastName + "'");
		Assert.assertEquals(customerInfoPage.getTextOnLastNameTextBox(), lastName);
		
		log.info("Register - Step 23: verify that date 15 is selected in the Date dropdown list");
		Assert.assertEquals(customerInfoPage.getSelectedItemOnDateDropdown(), "15");
		
		log.info("Register - Step 24: verify that month Februray is selected in the Month dropdown list");
		Assert.assertEquals(customerInfoPage.getSelectedItemOnMonthDropdown(), "March");
		
		log.info("Register - Step 25: verify that 1992 is selected in the Year dropdown list");
		Assert.assertEquals(customerInfoPage.getSelectedItemOnYearDropdown(), "1992");
		
		log.info("Register - Step 26: verify that the email text box is filled with '" + firstName + lastName + "@gmail.com'");
		Assert.assertEquals(customerInfoPage.getTextOnEmailTextbox(), firstName + lastName + "@gmail.com");	
	}
	
	@Test(groups = { "users" })
	public void Register_03_Navigation() {
		this.orderPage = this.customerInfoPage.openOrderPage(this.driver);
		this.myProductReviewPage = this.orderPage.openMyProductReviewPage(this.driver);
		this.rewardPointsPage = this.myProductReviewPage.openRewardPointsPage(this.driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
