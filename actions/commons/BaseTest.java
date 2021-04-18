package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected final Log log; 
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver initBrowser(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if (browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
		//	System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser==BROWSER.FIREFOX) {
		//	System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Please enter correct browser");
		}
		return driver;
	}
	public WebDriver initBrowser(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", projectLocation+ getSlash("browserDrivers") + "chromedriver.exe");
			 driver = new ChromeDriver();
		} else if (browser==BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation+ getSlash("browserDrivers") + "geckodriver.exe");
			 driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Please enter correct browser");
		}
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public int getRandomNumber() {
		Random rd = new Random(); 
		return rd.nextInt(999999);
	}
	
	private String getSlash(String folderName) {
		String seperator = System.getProperty("file.seperator");
		seperator = File.separator;
		return seperator+folderName+seperator;
	}
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI;
	}
	private String projectLocation = System.getProperty("user.dir");
	private WebDriver driver;
	
	public void sleepInSecond(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
