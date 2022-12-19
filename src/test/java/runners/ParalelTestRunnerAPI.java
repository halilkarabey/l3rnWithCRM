package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/Paralelcucumber-reports1.html",
                "json:target/json-reports/Paralelcucumber1.json",
                "junit:target/xml-report/Paralelcucumber1.xml"},
        features = "src/test/resources",
        glue = "stepdefinitions",
        tags = "@API",
        dryRun = false
)
public class ParalelTestRunnerAPI {
}
