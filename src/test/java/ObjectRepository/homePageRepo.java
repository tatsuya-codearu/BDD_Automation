package ObjectRepository;

import org.openqa.selenium.By;

public class homePageRepo {
    public By getProductByTitle(String productName){
        return By.xpath("//a[normalize-space()='"+productName +"']");
    }

    public By getConfirmationMessage(){
        return By.cssSelector(".message-success.success.message");
    }

    public By getComparisonLink(){
        return By.linkText("comparison list");
    }

}
