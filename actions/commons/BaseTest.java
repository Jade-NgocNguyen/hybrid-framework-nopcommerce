package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Logger log;
//	private String projPath;
//	private String os;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowserDriver(@Optional("chrome") String browser, String url) {
//		projPath = System.getProperty("user.dir");
//		os = System.getProperty("os.name");

		BrowserName browserName = BrowserName.valueOf(browser.toUpperCase());

		switch (browserName) {
		case CHROME:
			//System.setProperty("webdriver.chrome.driver", projPath + "\\browserDriver\\chromedriver.exe");
			//driver = new ChromeDriver();
			driver = WebDriverManager.chromedriver().create();
			break;
		case FIREFOX:
			//System.setProperty("webdriver.gecko.driver", projPath + "\\browserDriver\\geckodriver.exe");
			//driver = new FirefoxDriver();
			driver = WebDriverManager.firefoxdriver().create();
			break;
		default:
			throw new RuntimeException("Please provide a valid browser name!!");
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

	protected int genRandomNumber() {
		Random random = new Random();

		return random.nextInt(999999);
	}
}
