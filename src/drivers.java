import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class drivers extends setup{
    public static String drivername = "Test driver Tayyab_1";

    @BeforeTest
    @Override
    public void setupbrowser() {
        super.setupbrowser();
    }

    //////Test 1:  For searching a driver
    @Test (priority = 1)
    public void searchdriver(){
    //System.out.println("Test");

     // checking whether we are on driver page or not
        Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
        WebElement driver_search_button =  driver.findElement(By.name("searchTerm"));
        driver_search_button.sendKeys(drivername);
        driver_search_button.sendKeys(Keys.ENTER);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // driver.quit();
        try{

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println(driver_search_button.getText());
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[1]/strong")).getText(),drivername);
            FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Screenshot2.png"));
            System.out.println("Test 1: searching a driver test = Passed");
        }catch (Exception e) {
            System.out.println("Test 1: searching a driver test = Failed");
            System.out.println(e.getMessage());
        }
    //    driver.quit();
    }

    //////Test 2:  Searching a driver with Filter Criteria
    @Test (priority = 2)
    public void searchdriver_filter(){
        //System.out.println("Test");

        // checking whether we are on driver page or not
        Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
        WebElement driver_search_button =  driver.findElement(By.name("searchTerm"));
        driver_search_button.sendKeys(drivername);
        // Selecting Filter by stage value
        Select filter_by_stage = new Select(driver.findElement(By.id("stages")));
        filter_by_stage.selectByVisibleText("Active");
        filter_by_stage.selectByValue("6");

       /*  Other Filters Values
       filter_by_stage.selectByVisibleText("Inactive");
        filter_by_stage.selectByValue("10");
        filter_by_stage.selectByVisibleText("Applied");
        filter_by_stage.selectByValue("1");
        filter_by_stage.selectByVisibleText("Didnt Take Car");
        filter_by_stage.selectByValue("0");
        filter_by_stage.selectByVisibleText("All");
        filter_by_stage.selectByValue("6");

        */
        // Selecting Filter Car Status value
        Select filter_car_status = new Select(driver.findElement(By.id("carStatus")));
        filter_car_status.selectByVisibleText("All");
        filter_car_status.selectByValue("null");

       /*  Other Filters Values
       filter_by_stage.selectByVisibleText("Enabled");
        filter_by_stage.selectByValue("Enabled");
        filter_by_stage.selectByVisibleText("Disabled");
        filter_by_stage.selectByValue("Disabled");
        */

        driver_search_button.sendKeys(Keys.ENTER);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // driver.quit();
        try{

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println(driver_search_button.getText());
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[1]/strong")).getText(),drivername);
            FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Screenshot3.png"));
            System.out.println("Test 2: searching a driver with Stage and car filter test = Passed");
        }catch (Exception e) {
            System.out.println("Test 2: searching a driver with Stage and car filter test =  Failed");
            System.out.println(e.getMessage());
        }
           driver.quit();
    }

    //////Test 3:  Create a new Driver Functionality
    @Test (priority = 3)
    public void create_driver(){
        //System.out.println("Test");

        // checking whether we are on driver page or not
        Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
        WebElement createdriverbtn = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[1]/div[4]/div/button"));
        createdriverbtn.click();

        driver.quit();
    }


}
