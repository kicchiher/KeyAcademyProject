package com.theherakles.keyacademy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features/ui",
        glue = "com/theherakles/keyacademy/step_definitions/ui",
        dryRun = true,
        tags = ""
)
public class UICukesRunner {


}