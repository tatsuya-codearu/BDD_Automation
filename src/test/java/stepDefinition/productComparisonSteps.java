package stepDefinition;

import ObjectRepository.homePageRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import utilities.excelData;

import java.io.IOException;

public class productComparisonSteps {

    homePageRepo homepagerepo = new homePageRepo();
    excelData xl = new excelData();
    @Parameters({"url"})
    @Given("the user must be on the Home Page")
    public void the_user_must_be_on_the_Home_Page(String url){
        Hooks.driver.get(url);
    }

    @Given("the user identified {string} as their product of interest")
    public void the_user_identified_as_their_product_of_interest() throws IOException {
        homepagerepo.getProductByTitle(xl.xlData("TC-001","product"));

    }

    @When("the user hovers over <productName> and clicks the Add to Compare button")
    public void the_user_hovers_over_and_clicks_the_Add_to_Compare_button(){
        homepagerepo.getComparisonLink();
    }


}
