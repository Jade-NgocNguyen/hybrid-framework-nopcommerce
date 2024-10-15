package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.SidebarPageUI;

public class SidebarPageObject extends BasePage{
	public MyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		this.waitForElementClickable(driver, SidebarPageUI.MY_PRODUCT_REVIEW_LINK_ON_SIDEBAR);
		this.clickToElement(driver, SidebarPageUI.MY_PRODUCT_REVIEW_LINK_ON_SIDEBAR);
		return PageGeneratorManager.GetMyProductReviewPage(driver);
	}
	
	public OrderPageObject openOrderPage(WebDriver driver) {
		this.waitForElementClickable(driver, SidebarPageUI.ORDER_LINK_ON_SIDEBAR);
		this.clickToElement(driver, SidebarPageUI.ORDER_LINK_ON_SIDEBAR);
		return PageGeneratorManager.GetOrderPage(driver);
	}
	
	public RewardPointsPageObject openRewardPointsPage(WebDriver driver) {
		this.waitForElementClickable(driver, SidebarPageUI.REWARD_POINTS_LINK_ON_SIDEBAR);
		this.clickToElement(driver, SidebarPageUI.REWARD_POINTS_LINK_ON_SIDEBAR);
		return PageGeneratorManager.GetRewardPointsPage(driver);
	}
}
