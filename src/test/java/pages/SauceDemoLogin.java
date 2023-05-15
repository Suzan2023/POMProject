package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLogin {

//yapilacak ilk islem constructor olusturup PageFactory.initElement cagirarak initilaze ediyoruz.
// ancak bunu sadece FindBy kullanacagimiz zaman yapiyoruz
    public SauceDemoLogin() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    WebElement txtUsername;   //default elementler olusturulur

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    public void enterUsername(String username){  //elementleri cagiracagimiz methodlar olusturulur
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){  //sitede animasyonlar vs yuzunden yuklenme sorunlari oluyorsa
        btnLogin.click();                     // burda btnLogin.click ten once WebDriverWait objesi olusturulup boylece
                               // btnLogin tiklanabilir oldugunda tiklar

    }
}
