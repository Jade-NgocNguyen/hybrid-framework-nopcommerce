package pageFactory;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// Operations on browser
	// Page objects
	protected void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPagesourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void navigateToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void navigateToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// Alert objects
	protected Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptToAlert(WebDriver driver) {
		this.waitForAlertPresence(driver).accept();
	}

	protected void cancelToAlert(WebDriver driver) {
		this.waitForAlertPresence(driver).dismiss();
	}

	protected void sendKeyToAlert(WebDriver driver, String value) {
		this.waitForAlertPresence(driver).sendKeys(value);
	}

	protected String getTextInAlert(WebDriver driver) {
		return this.waitForAlertPresence(driver).getText();
	}

	// Window objects
	protected String getWindowHandler(WebDriver driver) {
		return driver.getWindowHandle();
	}

	protected void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if (windowTitle.equals(title)) {
				break;
			}
		}

	}

	protected void closeAllWindowsExceptForParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id).close();
			}
		}

		driver.switchTo().window(parentID);
	}

	// Operations on web element
	protected boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	protected String getTextElement(WebElement element) {
		return element.getText();
	}

	protected void sendKeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	protected void clickToElement(WebElement element) {
		element.click();
	}

	protected void selectItemInDropdown(WebElement element, String itemValue) {
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	protected String getSelectedItemInDropdown(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	// Wait operation
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(element));
	}
}
