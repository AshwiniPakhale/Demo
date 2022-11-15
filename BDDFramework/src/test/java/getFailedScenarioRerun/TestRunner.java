package getFailedScenarioRerun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/VTigerLeadBackgrounExample.feature" }, 
                 glue = { "stepdefinations", "hooks" }, 
                 plugin = { "pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failedrerun.txt" },
                 monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests{

}
