package com.freecrm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
 public WebDriver driver;
   SoftAssert softAssert =new SoftAssert();
 public static Properties properties;

   public TestBase() throws IOException {
        properties= new Properties();
       FileInputStream fis= new FileInputStream("src/test/java/com/freecrm/config/config.properties");
       properties.load(fis);
   }
    public void intialization(String siteURL )
    {
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(siteURL);
    }

    public  void tearDownBase()
    {
        softAssert.assertAll();
        driver.close();
    }


}
