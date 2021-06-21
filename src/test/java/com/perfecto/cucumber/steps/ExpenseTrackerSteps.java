package com.perfecto.cucumber.steps;

import java.util.Map;

import com.perfecto.PerfectoSerenityDriver;
import com.perfecto.cucumber.pages.ExpenseTrackerHomePage;
import com.perfecto.cucumber.pages.ExpenseTrackerLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import com.perfecto.cucumber.pages;


public class ExpenseTrackerSteps {

	ExpenseTrackerLoginPage loginPage ;
	ExpenseTrackerHomePage homePage ;
	
	@Then("I should see expense tracker login screen")
	public void verifyExpenseTrackerLogin() {
		loginPage = new ExpenseTrackerLoginPage(PerfectoSerenityDriver.getDriver());
		homePage = new ExpenseTrackerHomePage(PerfectoSerenityDriver.getDriver());
		loginPage.verifyExpenseTrackerLoginScreen();
	}
	
	@Then("I should see expense tracker Native login screen")
	public void verifyExpenseTrackerNativeLogin() {
		loginPage.verifyExpenseTrackerNativeLoginScreen();
	}
	
	@When("I enter {string} and {string} in native login")
	public void iEnterLoginDetilsInNativeLoginScreen(String un, String ps) {
//		Map<String, String> map = dataTable.asMap();
		loginPage.loginNative(un, ps);
	}
	
	
	@Then("I should see expense tracker home screen")
	public void iShouldSeeExpenseTrackerHomeScreen() {
		homePage.verifyHomeScreen();
	}
	
	@When("I enter expense details and save")
	public void iEnterExpenseDetailsAndSave() {
		homePage.enterExpenseDetails();
	}
	
	@Then("I should see error popup")
	public void iShouldSeeErrorPopup() {
		homePage.verifyPopupText(); 
	}
}
