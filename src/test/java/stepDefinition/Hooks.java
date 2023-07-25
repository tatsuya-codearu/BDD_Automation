package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import utilities.actionHelper;
import utilities.excelData;

public class Hooks extends actionHelper {
    public static WebDriver driver;
    public static Scenario scenario;
    public static String url;
    public static String browser;

    @Before
    @Parameters({"url", "browser"})
    public void before(){
        Hooks.url = url;
        Hooks.browser = browser;
        driver = setUpBrowser(browser);
        System.setProperty("com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output-folder", "src/test/java/Reporting");
    }

    @After
    public void tearDown(){
        excelData xl = new excelData();
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
