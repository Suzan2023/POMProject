package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    private Driver() {   //->Singleton Design Pattern

    }
    //TODO Driver classini cross browser calisacak formata getir


    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");
        if(driver == null){

            // Bu kisimda farkli browserlarda calismasi icin switch case kullandik
            switch (browser){

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
