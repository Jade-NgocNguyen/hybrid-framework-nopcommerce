package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject GetHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject GetLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject GetRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInfoPageObject GetCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	
	public static MyProductReviewPageObject GetMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static OrderPageObject GetOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
	public static RewardPointsPageObject GetRewardPointsPage(WebDriver driver) {
		return new RewardPointsPageObject(driver);
	}
}
