package stepDefinition;

import ObjectRepository.homePageRepo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import utilities.actionHelper;
import utilities.excelData;

import java.io.IOException;

import static stepDefinition.Hooks.driver;

public class productComparisonSteps extends actionHelper {

    homePageRepo homepagerepo = new homePageRepo();
    excelData xl = new excelData();
    //@Parameters({"url"})
    @Given("the user must be on the Home Page")
    public void the_user_must_be_on_the_Home_Page(){
    driver.get(Hooks.url);}

    @Given("the user identified {string} as their product of interest")
    public void the_user_identified_as_their_product_of_interest() throws IOException {
        homepagerepo.getProductByTitle(xl.xlData("TC-001","product"));

    }

    @When("the user hovers over {string} and clicks the Add to Compare button")
    public void the_user_hovers_over_and_clicks_the_Add_to_Compare_button(String productName){
        waitForElement((WebElement) homepagerepo.addComparisonBtn(),Hooks.driver);
        takeScreenshot(Hooks.scenario, Hooks.driver );
        ((WebElement) homepagerepo.addComparisonBtn()).click();
    }

    @When("the user goes and  hovers over {string} and clicks the Add to Compare button")
    public void the_user_goes_and_hovers_over_and_clicks_the_Add_to_Compare_button(String productName){
        waitForElement((WebElement) homepagerepo.addComparisonBtn(),Hooks.driver);
        takeScreenshot(Hooks.scenario, Hooks.driver );
        ((WebElement) homepagerepo.addComparisonBtn()).click();
    }

    @Then("a confirm message, {string} should appear")
    public void a_confirm_message_should_appear(String ConfirmationMsg){
        ConfirmationMsg = "You added product Radiant Tee to the comparison list.";
        if (ConfirmationMsg == homepagerepo.getConfirmationMessage().toString()){
            log("Confirmation message found");
        }else{
            log("Unable to find message");
        }
    }

    @And("the {string} should be added in the Compare Products screen")
    public void the_should_be_added_in_the_Compare_Products_screen(String productName){
        click((WebElement) homepagerepo.getComparisonLink(),driver);
        takeScreenshot(Hooks.scenario,driver);
    }


}
