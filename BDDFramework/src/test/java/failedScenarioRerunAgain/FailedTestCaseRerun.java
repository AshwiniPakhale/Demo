package failedScenarioRerunAgain;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "@target/failedrerun.txt" }, 
                 glue = { "stepdefinations", "hooks" }, 
                 plugin = { "pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failedrerun.txt" },
                 monochrome = true)

public class FailedTestCaseRerun extends AbstractTestNGCucumberTests {

}
