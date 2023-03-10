package com.TN.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.TN.utilities.UtilityClass;

public class BaseClass {

	WebDriver driver;
	public Properties prop;
	public Properties testDataProp;

	public BaseClass() {
		prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\TN\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		testDataProp = new Properties();
		File testDataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TN\\testData\\testData.properties");
		try {
			FileInputStream testDatafis = new FileInputStream(testDataFile);
			testDataProp.load(testDatafis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityClass.implicitWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityClass.pageLoadTime));
		driver.get(prop.getProperty("url"));

		return driver;
	}
}
