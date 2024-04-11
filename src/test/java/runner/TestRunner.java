package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinations"},
        monochrome=true,
       // plugin = { "pretty", "html:target/Html-Reports" }
        plugin = { "pretty", "json:target/JSONReport/report.json"}
)
public class TestRunner {
}
