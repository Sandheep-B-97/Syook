package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",        // path to feature files
        glue = {"stepDefinitions"},                     // package for step defs
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // report formats
        monochrome = true                               // clean console output
)
public class TestRunner {
}
