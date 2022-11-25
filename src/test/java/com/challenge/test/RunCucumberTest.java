package com.challenge.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.challenge.test.defs",
        features = "src/test/resources/scenarios.feature",
        plugin = {"pretty", "html:target/cucumber-report.html"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
