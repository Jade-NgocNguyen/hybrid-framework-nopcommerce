package pageObjects;

import org.openqa.selenium.WebDriver;

public class MyProductReviewPageObject extends SidebarPageObject{
	WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
