package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class actionHelper {
    public String getBrowserName(){
        String browser = "firefox";
        return browser;
    }

    @Parameters("browser")
    public WebDriver setUpBrowser(String browser){
        WebDriver driver;
        try{
            switch(getBrowserName().toLowerCase()){
                case "chrome":{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default:
                    throw new RuntimeException("Unexpected value: " + getBrowserName().toLowerCase());
            }

        }catch (Exception exception){
            throw new RuntimeException("unable to setup" + browser + "Web Driver", exception);
        }
    }

}
