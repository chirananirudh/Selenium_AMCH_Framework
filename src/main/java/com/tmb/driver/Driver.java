package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public final class Driver { // IS A relationship

	private Driver() {
	}

	public static void initDriver() throws MalformedURLException {
		String browser = ConfigFactory.getConfig().browser();
		String runmode = ConfigFactory.getConfig().runmode();

		if (DriverManager.getDriver() == null) {
			WebDriver driver = DriverFactory.getDriver(runmode, browser);
			DriverManager.setDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(),
					TimeUnit.SECONDS);// presence of element in the dom
			DriverManager.getDriver().get(ConfigFactory.getConfig().url());
		}
	}

	public static void quitDriver() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.setDriver(null);
		}
	}
}
