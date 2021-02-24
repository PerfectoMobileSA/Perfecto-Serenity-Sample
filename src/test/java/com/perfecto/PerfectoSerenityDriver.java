package com.perfecto;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

public class PerfectoSerenityDriver implements DriverSource {

//	private static final ThreadLocal<ReportiumClient> reportThreadLocal = new ThreadLocal<ReportiumClient>();
//
//	public static void setReportiumClinet(ReportiumClient report) {
//		reportThreadLocal.set(report);
//	}
//
//	public static ReportiumClient getReportiumClient() {
//		return reportThreadLocal.get();
//	}
	
	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

	public static void setDriver(WebDriver driver) {
		driverThreadLocal.set(driver);
	}

	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}


	@Override
	public WebDriver newDriver() {
		RemoteWebDriver driver = null;
		EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

		String securityToken = (String) environmentVariables.getProperty("perfecto.capabilities.securityToken");
		String cloudName = (String) environmentVariables.getProperty("perfecto.capabilities.cloudName")+".perfectomobile.com";

		String environment = System.getProperty("environment");
		System.out.println("Env - "+environment);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		List<String> envList = environmentVariables.getKeys();
		if(environment==null)
			environment = "perfecto";
		String keyCap = environment+".";
		System.out.println("Key cap : "+keyCap);
		for (String key : envList) {
			if(key.contains(keyCap)) {
				capabilities.setCapability(key.replace(keyCap+"capabilities.", ""), (String) environmentVariables.getProperty(key));
			}
		}
		System.out.println(capabilities);
		capabilities.setCapability("securityToken", securityToken);

		try {
			driver = new RemoteWebDriver(new URL("https://" + cloudName + "/nexperience/perfectomobile/wd/hub"), capabilities);
			return driver;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private static ReportiumClient createRemoteReportiumClient(RemoteWebDriver driver) {
		PerfectoExecutionContext perfectoExecutionContext = null;
		if(System.getProperty("reportium-job-name")!=null)
		{
			String branch = System.getProperty("reportium-job-branch") == null ? "local" : System.getProperty("reportium-job-branch");
			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
					.withProject(new Project("GS Serenity Automation", "1.0"))
					.withJob(new Job(System.getProperty("reportium-job-name"), Integer.parseInt(System.getProperty("reportium-job-number"))).withBranch(branch))
					.withWebDriver(driver)
					.build();
		}
		else {
			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
					.withProject(new Project("GS Serenity Automation", "1.0"))
					.withWebDriver(driver)
					.build();
		}

		return new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
	}


	public boolean takesScreenshots() {
		return true;
	}
}
