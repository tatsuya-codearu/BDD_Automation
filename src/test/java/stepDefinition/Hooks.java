package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import utilities.actionHelper;

public class Hooks extends actionHelper {
    public static WebDriver driver;
    public static Scenario scenario;

    @Before
    @Parameters({"url","browser"})
    public void setUp(Scenario scenario, String url, String browser){
        Hooks.scenario = scenario;
        driver = setUpBrowser(browser);
    }
}
