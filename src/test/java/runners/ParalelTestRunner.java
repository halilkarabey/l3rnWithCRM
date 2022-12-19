package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/Paralelcucumber-reports2.html",
                "json:target/json-reports/Paralelcucumber2.json",
                "junit:target/xml-report/Paralelcucumber2.xml"},
        features = "src/test/resources",
        glue = "stepdefinitions",
        tags = "@n11",
        dryRun = false
)
public class ParalelTestRunner {

}
