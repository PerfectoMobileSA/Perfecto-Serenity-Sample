package com.perfecto.cucumber.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.perfecto.PerfectoSerenityDriver;
import com.perfecto.reportium.client.ReportiumClient;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ExpenseTrackerLoginPage extends PageObject {
	
	@FindBy(id = "io.perfecto.expense.tracker:id/login_email")
	WebElementFacade emailNativeTextfield;
	
	@FindBy(id = "io.perfecto.expense.tracker:id/tv_login_head")
	WebElementFacade headerTextNative;
	
	@FindBy(id = "io.perfecto.expense.tracker:id/login_password")
	WebElementFacade passwordlNativeTextfield;
	
	@FindBy(id = "io.perfecto.expense.tracker:id/login_login_btn")
	WebElementFacade loginlNativeButton;

	public ExpenseTrackerLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyExpenseTrackerLoginScreen() {
		Map<String, Object> params = new HashMap<>();
		params.put("content", "Email");
		params.put("timeout", "15");
		((RemoteWebDriver)PerfectoSerenityDriver.getDriver()).executeScript("mobile:text:find", params);
	}
	
	public void verifyExpenseTrackerNativeLoginScreen() {
//		if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("ios")) {
//			QAFExtendedWebElement ele = new QAFExtendedWebElement(By.xpath("//*[@label='OK']"));
//			try {
//				ele.click();
//			} catch (Exception e) {
//			}
//		}
//		ReportiumClient client = PerfectoSerenityDriver.getReportiumClient();
		 headerTextNative.isDisplayed();
		 emailNativeTextfield.isDisplayed();
//		PerfectoSerenityDriver.getReportiumClient().reportiumAssert("Verify Login screen title", headerTextNative.isDisplayed());
//		PerfectoSerenityDriver.getReportiumClient().reportiumAssert("Verify Login screen Email", emailNativeTextfield.isDisplayed());
	}
	
	public void loginNative(String email, String password) {
		emailNativeTextfield.sendKeys(email);
		passwordlNativeTextfield.sendKeys(password);
		((AppiumDriver)PerfectoSerenityDriver.getDriver()).hideKeyboard();
		loginlNativeButton.click();
	}
}
