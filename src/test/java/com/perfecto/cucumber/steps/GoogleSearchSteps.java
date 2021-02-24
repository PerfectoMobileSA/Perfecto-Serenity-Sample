package com.perfecto.cucumber.steps;


import net.thucydides.core.annotations.Steps;

import java.text.ParseException;


import com.perfecto.PerfectoSerenityDriver;
import com.perfecto.cucumber.pages.GooglePage;
import com.perfecto.reportium.test.TestContext;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;


public class GoogleSearchSteps {
	
    GooglePage googlePage;

    @When("^I type query as \"([^\"]*)\"$")
    public void search_google_for(String searchWord) throws Throwable {
//    	googlePage = new GooglePage(PerfectoSerenityDriver.getDriver(), 10);
        googlePage.open();
        googlePage.searchForString(searchWord);
    }

    @Then("^I submit$")
    public void thenSubmit() throws Throwable {
        googlePage.submitForm();
    }

    @Then("^I should see title \"([^\"]*)\"$")
    public void matchTitle(String matchTitle) throws Throwable {
        googlePage.titleShouldMatch(matchTitle);
    }
}
