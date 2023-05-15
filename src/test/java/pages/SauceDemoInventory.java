package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SauceDemoInventory {

    public SauceDemoInventory() {
        PageFactory.initElements(Driver.getDriver(), this);  //tum WebElementleri baslatmak icin bu method cagirilir
    }

    @FindBy(tagName = "select")
    WebElement sortBy;

    @FindBy(className = "inventory_item_price")
    List<WebElement> products;

    public void sortBy(String filter) {
        Select select = new Select(sortBy);
        select.selectByVisibleText(filter);
    }

    public void validateProductsAreSorted() {
//  yontem 1: For ile

        for (int i = 0; i < products.size() - 1; i++) {

            WebElement currentProduct = products.get(i);
            WebElement nextProduct = products.get(i + 1);

            //suanki urunun(currentproduct)textinin,$'siz string olan ifadenin double bir ifade olarak parseDouble ile yazilmasi:
            double currentPrice = Double.parseDouble(currentProduct.getText().substring(1));  //4.99
            double nextPrice = Double.parseDouble(nextProduct.getText().substring(1));  //7.99

            Assert.assertTrue(currentPrice <= nextPrice, "Products are not sorted");


        }
    }


}
