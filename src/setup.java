import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class setup {
    public WebDriver driver;

    @BeforeTest
    //////// Setting up environment and calling driver.
    public void setupbrowser(){
        ////// for Chrome Browser
        System.setProperty("webdriver.chrome.driver", Constants.chrome_path);
        driver = new ChromeDriver();

        // for firefox browser
        /*
        System.setProperty("webdriver.gecko.driver", "Constants.firefox_path");
        driver= new FirefoxDriver();
        */

        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys(Constants.username);
        password.sendKeys(Constants.password);
        loginbutton.click();
        Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot1.png"));
        } catch(Exception e){
            //FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot1.png"));
            System.out.println(e.getMessage());
        }


    }






}
