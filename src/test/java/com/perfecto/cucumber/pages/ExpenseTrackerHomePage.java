package com.perfecto.cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.perfecto.PerfectoSerenityDriver;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ExpenseTrackerHomePage extends PageObject {

	@FindBy(xpath = "//*[@content-desc='Open Drawer']")
	 WebElementFacade menuBtn;

	@FindBy(id = "io.perfecto.expense.tracker:id/list_add_btn")
	WebElementFacade addBtn;
	
	@FindBy(id = "io.perfecto.expense.tracker:id/input_layout_head")
	WebElementFacade headDropdown;

	@FindBy(xpath = "//*[@text='Flight']")
	WebElementFacade flightOption;
	
	@FindBy(id = "io.perfecto.expense.tracker:id/add_amount")
	WebElementFacade amountInput;
	
	@FindBy(id = "io.perfecto.expense.tracker:id/layout_buttons")
	WebElementFacade savebtn;
	
	public ExpenseTrackerHomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyHomeScreen() {
		menuBtn.isDisplayed();
//		PerfectoSerenityDriver.getReportiumClient().reportiumAssert("Verify Home Screen.", menuBtn.isDisplayed());
		
	}
	
	public void enterExpenseDetails() {
		addBtn.click();
		String platform = ((RemoteWebDriver)PerfectoSerenityDriver.getDriver()).getCapabilities().getPlatform().name();
		if(platform.equalsIgnoreCase("android") || platform.equalsIgnoreCase("linux")) {
			headDropdown.click();
			flightOption.click();
		}else {
			headDropdown.sendKeys("Flight");
		}
		amountInput.sendKeys("100");
		savebtn.click();
	}
	
	public void verifyPopupText() {
//		PerfectoSerenityDriver.getReportiumClient().reportiumAssert("Verify Popup Text.", savebtn.isDisplayed());
		savebtn.isDisplayed();
		
	}
}
