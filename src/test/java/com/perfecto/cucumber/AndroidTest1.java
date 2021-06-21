package com.perfecto.cucumber;

import org.junit.runner.RunWith;

import com.perfecto.PerfectoSerenityTest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/appium.feature",
tags = "@expenseTracker",
glue="com.perfecto.cucumber.steps")
public class AndroidTest1 extends PerfectoSerenityTest {

}
