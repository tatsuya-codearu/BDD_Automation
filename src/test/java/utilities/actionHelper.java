package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.exec.util.DebugUtils.handleException;
import static stepDefinition.Hooks.driver;

public class actionHelper {
    static ExtentTest test;
    @Parameters("browser")
    public String getBrowserName(){
        String browser = "firefox";
        return browser;
    }


    public WebDriver setUpBrowser(String browser){
        WebDriver driver;
        browser = getBrowserName();
        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unexpected value: " + browser);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return driver;

        } catch (Exception exception) {
            throw new RuntimeException("Unable to setup " + browser + " Web Driver", exception);
        }
    }

    public void scrollTo(int x, int y) {
        Actions a = new Actions(driver);
        a.scrollByAmount(x, y).build().perform();

    }

    public void scrollElement(WebElement element, WebDriver driver) {
        Actions a = new Actions(driver);
        a.scrollToElement(element).build().perform();

    }


    public void hover(WebElement element, WebDriver driver) {
        Actions a = new Actions(driver);
        a.moveToElement(element).build().perform();
    }

    public void hover2(WebElement element, int x, int y, WebDriver driver) {
        Actions a = new Actions(driver);
        a.moveToElement(element, x, y);
    }

    public void click(WebElement element, WebDriver driver) {
        Actions a = new Actions(driver);
        a.click().build().perform();
    }

    public void waitForElement(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClick(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void takeScreenshot(Scenario scenario, WebDriver driver){
        try{
            String screenshotName ="screenshot_" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(String.valueOf(scenario),"image/png", screenshotName);
        }catch (Exception e){
            handleException("Unable to take screenshot",e);
        }
    }

    public void log(String desc){
        test.log(Status.INFO,desc);
    }

}
