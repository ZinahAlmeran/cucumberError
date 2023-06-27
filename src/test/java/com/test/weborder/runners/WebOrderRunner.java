package com.test.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/weborder",  //feature file location
        glue = "com/test/weborder/stepdefinitions",//step definition file location
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)

public class WebOrderRunner {
}
