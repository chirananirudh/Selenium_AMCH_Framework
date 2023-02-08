package com.tmb.driver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.tmb.config.ConfigFactory;

public final class RemoteDriverFactory {

	private RemoteDriverFactory() {
	}

	public static WebDriver getRemoteDriver(String browser) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
		} else if (browser.equalsIgnoreCase("edge")) {
			capabilities.setBrowserName("edge");
		}
		return new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteurl()), capabilities);
	}
}
