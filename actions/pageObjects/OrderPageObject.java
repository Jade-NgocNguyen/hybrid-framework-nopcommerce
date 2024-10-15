package pageObjects;

import org.openqa.selenium.WebDriver;

public class OrderPageObject extends SidebarPageObject{
	WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
