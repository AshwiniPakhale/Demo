package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/VTigerLeadBackgrounExample.feature" }, 
                  tags = "@Smoke or @SpecificHook or @Regression",
                  glue = { "stepdefinations", "hooks" },
                  plugin = { "pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
                  monochrome = true )

public class TestRunner extends AbstractTestNGCucumberTests {

}
