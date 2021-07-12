import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class setup {
    public WebDriver driver;
    public static String baseurl = "https://buggy-staging-env.appspot.com/";

    @BeforeTest
    //////// Setting up environment and calling driver.
    public void setupbrowser(){
        ////// for Chrome Browser

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        // for firefox browser
        /*
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver= new FirefoxDriver();
        */

        driver.get(baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys("afnan.khalid");
        password.sendKeys("techoffice");
        loginbutton.click();
        Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Screenshot1.png"));
        } catch(Exception e){
            //FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Screenshot1.png"));
            System.out.println(e.getMessage());
        }


    }






}
