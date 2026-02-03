package driverFactorySetUp;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.ConfigReader;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<String> browserName = new ThreadLocal<>();
	    public static void inItBrowser() {
	       String browserName = getBrowser();
	       boolean isHeadless = isHeadless();
	       if (browserName.equalsIgnoreCase("Edge")) {
	          EdgeOptions options = new EdgeOptions();
	          if(isHeadless) {
	          options.addArguments("--headless");
	          }
	          driver.set(new EdgeDriver(options));

	       } else if (browserName.equalsIgnoreCase("Chrome")) {
	          ChromeOptions options = new ChromeOptions();
	          if(isHeadless) {
	          options.addArguments("--headless=new");
	          }
	          driver.set(new ChromeDriver(options));

	       } else if (browserName.equalsIgnoreCase("Firefox")) {
	    	   FirefoxOptions options = new FirefoxOptions();
	    	   if(isHeadless) {
	          driver.set(new FirefoxDriver(options));
	    	   }

	       } else {
	          throw new IllegalArgumentException("Browser instance can not be initialized");
	       }

	    }

	    public static String getBrowser() {
	       String browser = browserName.get();
	       if (browser == null) {
	    	    browser = System.getProperty("browser");
	    	}
	       if (browser == null) {
	          browser = ConfigReader.getProperty("browser");
	       }
	       return browser;
	    }

	    public static WebDriver getDriver() {
	       if (driver.get() == null) {
	          DriverFactory.inItBrowser();
	       }
	       return driver.get();
	    }

	    public static void quitDriver() {
	       if (driver.get() != null) {
	          driver.get().quit();
	          driver.remove();
	       }
	    }

	    public static boolean isHeadless() {
	        String headless = System.getProperty("headless");

	        if (headless == null || headless.isEmpty()) {
	            headless = ConfigReader.getProperty("headless");
	        }

	        return Boolean.parseBoolean(headless);
	    }
	    
	    public static void setupBrowser() {
	       WebDriver localDriver = driver.get();
	       localDriver.get(ConfigReader.getProperty("url"));
	       localDriver.manage().window().maximize();
	       localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   localDriver.manage().deleteAllCookies();
	    }
	    
	    public static String getBrowserName() {
	       return browserName.get();
	    }

	    public static void setBrowserName(String browserName) {
	       DriverFactory.browserName.set(browserName);
	    }
         }








