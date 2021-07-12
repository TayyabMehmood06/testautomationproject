import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demotest {
    public WebDriver driver;
    public static String baseurl = "https://buggy-staging-env.appspot.com/";
    @BeforeTest
    //////// Setting up environment and calling driver.
    public void setup(){
        ////// for Chrome Browser

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();


        // for firefox browser
        /*
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver= new FirefoxDriver();
        */

       //driver.close();
    }

    @Test(priority = 0)
    ///// Test case for login
    public void login(){
        driver.get(baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys("afnan.khalid");
        password.sendKeys("techoffice");
        loginbutton.click();
        Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
        //driver.quit();

    }
    @Test (priority = 1)
    public void searchdriver(){

        // checking whether we are on driver page or not
        Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
        WebElement driver_search_button =  driver.findElement(By.name("searchTerm"));
        // WebElement driver_search_button =  driver.findElement(By.name("s;
        driver_search_button.sendKeys("Test driver Tayyab_1");
        driver_search_button.sendKeys(Keys.ENTER);
        // WebDriverWait wait = new WebDriverWait(driver, 30);



    }




}
