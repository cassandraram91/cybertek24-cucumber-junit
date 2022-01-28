package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //this annotation comes from junit. basically saying to run the class as Cucumber BDD tests
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt", //store failed scenario names into rerun.txt file
                "json:target/cucumber.json" //generate json execution report to be used for html report
        },
        features = "src/test/resources/features", //we define address of feature file in our project
        glue = "com/cybertek/step_definitions", // location/path that points to step definitions
        dryRun = false, //false- run the test. true- check for missing steps
        tags = "@spartan"

        //false means run cucumber feature files // true means do not run just check if all feature file scenario steps have a matching step definition
)
public class CukesRunner {

}
