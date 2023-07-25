package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinition.Hooks;
import utilities.actionHelper;


public class homePage extends actionHelper {

    public void getProduct(WebElement productName, WebDriver driver){
        scrollTo(0, 1600);
        takeScreenshot(Hooks.scenario,Hooks.driver);
        waitForElement(productName,Hooks.driver);
        hover(productName, Hooks.driver);
    }

    public void addToCompList(WebElement addComparison){
        waitForClick(addComparison, Hooks.driver);
        click(addComparison,Hooks.driver);
    }

}
