package pages.amazon;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class AmazonProductPage extends AmazonBasePage{


    public AmazonProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "add-to-cart-button")
    WebElement btnAddToCart;

    public void addProductToCart(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
    }



}
