package com.perfecto.cucumber;

import org.junit.runner.RunWith;

import com.perfecto.PerfectoSerenityTest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/second.feature",
tags = "@googleSearch",
glue="com.perfecto.cucumber.steps")
public class ParallelFirefoxTest extends PerfectoSerenityTest {

}
