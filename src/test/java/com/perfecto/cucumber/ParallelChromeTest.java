package com.perfecto.cucumber;


import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/single.feature",
tags = { "@googleSearch" })
public class ParallelChromeTest {

	
}
