import com.freecrm.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class LoginUsingDataFromConfigFile extends TestBase {

SoftAssert softAssert= new SoftAssert();
    public LoginUsingDataFromConfigFile() throws IOException {
        super();
    }

    @BeforeMethod
    public void perconditionsMethod(){

        intialization(properties.getProperty("URL"))  ;
    }


    @Test
    public void loginUsingDataFromConfigFile()
    {



        String username= properties.getProperty("username");
        String password=properties.getProperty("password");

        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("passwd")).sendKeys(password);
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
        String actualResult= driver.findElement(By.xpath("//span[normalize-space()='mosta mostafa']")).getText().toLowerCase().trim();
        String expectedResult= "mosta mostafa";
        softAssert.assertEquals(actualResult,expectedResult);

    }


}
