package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
		return new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent());
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
	private By getByXPath(String locator) {
		return By.xpath(locator);
	}

	private WebElement findWebElement(WebDriver driver, String locator) {
		return driver.findElement(this.getByXPath(locator));
	}

	private List<WebElement> findWebElements(WebDriver driver, String locator) {
		return driver.findElements(this.getByXPath(locator));
	}

	protected boolean isElementDisplayed(WebDriver driver, String locator) {
		return this.findWebElement(driver, locator).isDisplayed();
	}

	protected boolean isElementEnabled(WebDriver driver, String locator) {
		return this.findWebElement(driver, locator).isEnabled();
	}

	protected boolean isElementSelected(WebDriver driver, String locator) {
		return this.findWebElement(driver, locator).isSelected();
	}

	protected String getTextElement(WebDriver driver, String locator) {
		return this.findWebElement(driver, locator).getText();
	}

	protected void sendKeyToElement(WebDriver driver, String locator, String value) {
		this.findWebElement(driver, locator).clear();
		this.findWebElement(driver, locator).sendKeys(value);
	}

	protected void clickToElement(WebDriver driver, String locator) {
		this.findWebElement(driver, locator).click();
	}

	protected void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		Select select = new Select(this.findWebElement(driver, locator));
		select.selectByVisibleText(itemValue);
	}

	protected String getSelectedItemInDropdown(WebDriver driver, String locator) {
		Select select = new Select(this.findWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(this.findWebElement(driver, locator));
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String itemValue) {
		this.findWebElement(driver, parentLocator).click();
		this.sleepInSecond(1);

		List<WebElement> allItems = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.getByXPath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().equals(itemValue)) {
				item.click();
				this.sleepInSecond(1);
				break;
			}
		}
	}

	protected String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return this.findWebElement(driver, locator).getAttribute(attributeName);
	}

	protected String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return this.findWebElement(driver, locator).getCssValue(propertyName);
	}

	protected String getHexaColorByGBR(String gbrValue) {
		return Color.fromString(gbrValue).asHex();
	}

	protected int getNumbersOfElement(WebDriver driver, String locator) {
		return this.findWebElements(driver, locator).size();
	}

	protected void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
		if (!this.isElementSelected(driver, locator)) {
			this.findWebElement(driver, locator).click();
		}
	}

	protected void uncheckTheCheckbox(WebDriver driver, String locator) {
		if (this.isElementSelected(driver, locator)) {
			this.findWebElement(driver, locator).click();
		}
	}

	protected void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(this.findWebElement(driver, locator));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(this.findWebElement(driver, locator)).perform();
	}

	protected void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(this.findWebElement(driver, locator)).perform();
	}

	protected void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(this.findWebElement(driver, locator)).perform();
	}

	protected void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(this.findWebElement(driver, sourceLocator), this.findWebElement(driver, targetLocator))
				.perform();
	}

	protected void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(this.findWebElement(driver, locator), key).perform();
	}

	// JavaScript Executor wrappers
	protected Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	protected String getInnerText(WebDriver driver) {
		return (String) this.executeForBrowser(driver, "return document.documentElement.innerText;");
	}

	protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) this.executeForBrowser(driver,
				"return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		this.executeForBrowser(driver, "window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void navigateToUrlByJS(WebDriver driver, String url) {
		this.executeForBrowser(driver, "window.location = '" + url + "'");
	}

	protected void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;

		WebElement element = this.findWebElement(driver, locator);
		String originalStyle = this.getElementAttribute(driver, locator, "style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.findWebElement(driver, locator));
	}

	protected void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				this.findWebElement(driver, locator));
	}

	protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				this.findWebElement(driver, locator));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				this.findWebElement(driver, locator));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				this.findWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				this.findWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	// Wait operation
	protected void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(this.findWebElement(driver, locator)));
	}
	
	protected void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOf(this.findWebElement(driver, locator)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(this.findWebElement(driver, locator)));
	}
	
	protected void waitForElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(this.getByXPath(locator)));
	}
	
	protected void waitForListElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.getByXPath(locator)));
	}
	
	protected void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElements(this.findWebElements(driver, locator)));
	}
	
	protected void waitForListElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOfAllElements(this.findWebElements(driver, locator)));
	}
	
	protected boolean waitForPageUrlToBe(WebDriver driver, String url) {
		return new WebDriverWait(driver,30).until(ExpectedConditions.urlToBe(url));
	}

	private void sleepInSecond(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
