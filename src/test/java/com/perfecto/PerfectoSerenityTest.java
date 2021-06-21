package com.perfecto;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class PerfectoSerenityTest {

	@BeforeClass
	public static void setup() {
		new PerfectoSerenityDriver().newDriver();
		ThucydidesWebDriverSupport.useDriver(PerfectoSerenityDriver.getDriver());
	}
	
	
	@AfterClass
	public static void teardown() {
		System.out.println("Done");
		System.out.println("Quit driver");
		ThucydidesWebDriverSupport.closeDriver();
//		PerfectoSerenityDriver.getDriver().quit();
	}
	
	
}
