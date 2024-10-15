package reportConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;
import commons.GlobalConstant;

public class ReportNGListener implements ITestListener{
		
	@Override
	public void onStart(ITestContext context) {
		Reporter.log("\n---------- " + context.getName() + " STARTED test ----------");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("\n---------- " + context.getName() + " FINISHED test ----------");
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("<br>---------- " + result.getName() + " STARTED test ----------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("<br>---------- " + result.getName() + " SUCCESS test ----------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("<br>---------- " + result.getName() + " FAILED test ----------");
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
		Object testClass = result.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getDriver();

		// Attach screenshot by file
//		String screenshotPath = captureScreenshotFile(webDriver, result.getName());
//		Reporter.getCurrentTestResult();
//		Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
//		Reporter.setCurrentTestResult(null);
		
		// Attach screenshot by base64
		String screenshotPath = captureScreenshotBase64(webDriver, result.getName());
		Reporter.getCurrentTestResult();

		Reporter.log("<br><a href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		Reporter.setCurrentTestResult(null);
		} catch (NoSuchSessionException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("<br>---------- " + result.getName() + " SKIPPED test ----------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("<br>---------- " + result.getName() + " SKIPPED test ----------");
	}

	public String captureScreenshotFile(WebDriver driver, String screenshotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String screenPath = GlobalConstant.REPORTNG_SCREENSHOT_PATH + File.separator + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		} catch (IOException e) {
			Reporter.log("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}
	
	public String captureScreenshotBase64(WebDriver driver, String screenshotName) {
		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
	}
	
}
