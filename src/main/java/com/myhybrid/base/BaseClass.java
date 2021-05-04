package com.myhybrid.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
//	public static WebDriver driver;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			System.out.println("Super constructor is involked");
			// Read file from location
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			// Load file
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public static void launchApp(String browserName) {
//		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			// Set Browser To ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("nativeEvents", false);
			cap.setCapability("unexpectedAlertBehaviour", "accept");
			cap.setCapability("ignoreProtectedModeSettings", true);
			cap.setCapability("disable-popup-blocking", true);
			cap.setCapability("enablePersistentHover", true);
			cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(cap);
			driver.set(new InternetExplorerDriver(options));
		}

		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		Action.checkPageIsReady(getDriver());
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		// PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);
		// Launching the URL
		getDriver().get(prop.getProperty("url"));

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
