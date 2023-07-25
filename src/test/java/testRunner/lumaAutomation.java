package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import utilities.actionHelper;

import java.awt.datatransfer.FlavorEvent;
@CucumberOptions(features = "src/test/java/features", glue = {"stepDefinition"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:src/test/java/Reporting/index.html"})
public class lumaAutomation extends AbstractTestNGCucumberTests {

   /* Replace "output-folder" with the desired folder path for your Extent report  @BeforeClass
    public static void setup() {

        System.setProperty("com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output-folder", "src/test/java/Reporting");
    }*/
}
