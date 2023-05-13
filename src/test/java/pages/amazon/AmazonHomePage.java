package pages.amazon;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends AmazonBasePage{

    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Home Page ile ilgili diger elementleri locate edebilirsiniz


}
