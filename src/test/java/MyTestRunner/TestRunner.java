package MyTestRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\main\\java\\Features\\SignUp.feature", //the path of the feature files
		glue={"StepDefinition"}, 
		format= {"pretty","html:test-outout", "json:report_json/cucumber.json", "junit:report_xml/cucumber.xml"},
		dryRun = true,
		monochrome = true
		//tags = {"@Smoke"}
		)

public class TestRunner {

}
