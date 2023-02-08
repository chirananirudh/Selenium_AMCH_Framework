package com.tmb.driver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.tmb.config.ConfigFactory;

public final class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver(String runMode, String browserName) throws MalformedURLException {
		WebDriver driver = null;
		if (runMode.equalsIgnoreCase("local")) {
			driver = LocalDriverFactory.getLocalDriver(browserName);
		} else if (runMode.equalsIgnoreCase("remote")) {
			driver = RemoteDriverFactory.getRemoteDriver(browserName);
		}
		return driver;
	}
}
