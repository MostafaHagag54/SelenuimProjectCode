import com.freecrm.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginToFreeCRM extends TestBase {


    SoftAssert softAssert= new SoftAssert();

    public LoginToFreeCRM() throws IOException {

    }

    @Parameters({"siteURL"})
    @BeforeMethod
    public void precondtion(String siteURL)
    {
        intialization(siteURL);

    }

    @Parameters({"signButtonTetx","loginPageProveXpath"})
    @Test(priority = 3)
    public void signUpPageStatus(String signButtonTetx, String loginPageProveXpath)
    {

        driver.findElement(By.partialLinkText(signButtonTetx)).click();
        String prove= driver.findElement(By.xpath(loginPageProveXpath)).getText().toLowerCase().trim();
        String expectedResult= "Authentication".toLowerCase();
        softAssert.assertEquals(prove,expectedResult);
    }

    @Test(priority = 4,dataProvider = "myData")
    public void login( String username,String password,String emailTextBoxID,String passTextBoxID,String loginButtonXpath)
    {
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.name(emailTextBoxID)).sendKeys(username);
        driver.findElement(By.name(passTextBoxID)).sendKeys(password);
        driver.findElement(By.xpath(loginButtonXpath)).click();
        String actualResult= driver.findElement(By.xpath("//span[normalize-space()='mosta mostafa']")).getText().toLowerCase().trim();
        String expectedResult= "mosta mostafa";
        softAssert.assertEquals(actualResult,expectedResult);


    }

    @DataProvider
    public Object[][] myData()
    {
        Object [][] data= new Object[4][5];
        data[0][0]="nnjrjos1u@tmail.ws";
        data[0][1]="12345";

        data [0][2]="email";
        data [0][3]="passwd";
        data [0][4]="//span[normalize-space()='Sign in']";


        data[1][0]="nnjrjos1u@tmail.ws";
        data[1][1]="652143";

        data [1][2]="email";
        data [1][3]="passwd";
        data [1][4]="//span[normalize-space()='Sign in']";

        data[2][0]="nnjrjos1u@tmail.wsl";
        data[2][1]="12345";

        data [2][2]="email";
        data [2][3]="passwd";
        data [2][4]="//span[normalize-space()='Sign in']";


        data[3][0]="nnjrjos1u@tmail.wsl";
        data[3][1]="123456";

        data [3][2]="email";
        data [3][3]="passwd";
        data [3][4]="//span[normalize-space()='Sign in']";

        return data;
    }


    @AfterMethod
    public void tearDown(){
     tearDownBase();
    }



}
