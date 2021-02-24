package com.perfecto.cucumber.steps;


import net.thucydides.core.annotations.Steps;

import java.text.ParseException;


import com.perfecto.cucumber.pages.LocalPage;

import cucumber.api.java.en.Then;

//import io.cucumber.java.en.Then;


public class LocalCheckSteps {
    LocalPage localPage;

    @Then("^I should see \"([^\"]*)\"$")
    public void matchTitle(String matchTitle) throws Throwable {
        localPage.open();
        localPage.bodyShouldMatch(matchTitle);
    }
}
