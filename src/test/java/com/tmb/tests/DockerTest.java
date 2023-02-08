package com.tmb.tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DockerTest {

	@Test
	public void dockerTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4445"), cap);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		driver.quit();
	}
}
