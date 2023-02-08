package com.tmb.tests;

import com.tmb.driver.Driver;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		Driver.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
}
