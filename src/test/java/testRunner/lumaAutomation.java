package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.actionHelper;

import java.awt.datatransfer.FlavorEvent;
@CucumberOptions(features = "src/test/java/features", glue = {"stepDefinition"},
        plugin = {"com.avantstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class lumaAutomation extends AbstractTestNGCucumberTests {

}
