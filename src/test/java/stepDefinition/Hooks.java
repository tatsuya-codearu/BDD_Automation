package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import jdk.vm.ci.meta.Local;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import utilities.actionHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.exec.util.DebugUtils.handleException;

public class Hooks extends actionHelper {
    public static WebDriver driver;
    public static Scenario scenario;

    @Before
    @Parameters({"url","browser"})
    public void setUp(Scenario scenario, String url, String browser){
        Hooks.scenario = scenario;
        driver = setUpBrowser(browser);
        //driver.get(url);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }


}
