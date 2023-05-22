package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    public static Properties properties;

    static{  // static blog icinde file bulma isini yapiyoruz. Try catch kullanma nedenimiz ise olasi bir hatadan kurtulmak
        String filePath="config.properties";
        try {
            FileInputStream fis=new FileInputStream(filePath);

            properties=new Properties();
            properties.load(fis);

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Bu method ile config dosyasi icinde elementlere her yerden ulasmak.
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
