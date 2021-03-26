import com.freecrm.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainPage extends TestBase {

    SoftAssert softAssert= new SoftAssert();

    public MainPage() throws IOException {
    }

    @Parameters({"siteURL"})
    @BeforeMethod
    public void precondtion(String siteURL)
    {
     intialization(siteURL);
    }
    @Parameters({"siteURL"})
    @Test(priority = 1 )
    public void checkURL( String siteURL){

        String currentURL= driver.getCurrentUrl();
        System.out.println(currentURL);
        softAssert.assertEquals(currentURL,siteURL);

    }
    @Parameters({"logoXpath"})
    @Test (priority = 2 )
    public void checkLogo(String logoXpath)
    {
       Boolean LogoStatus= driver.findElement(By.xpath(logoXpath)).isDisplayed();
       softAssert.assertTrue(LogoStatus);
    }
    @AfterMethod
    public void  tearDown()
    {
        tearDownBase();
    }



}
