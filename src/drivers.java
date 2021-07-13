import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class drivers extends setup {

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
        driver_search_button.sendKeys(Constants.drivername);
        driver_search_button.sendKeys(Keys.ENTER);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // driver.quit();
        try{

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println(driver_search_button.getText());
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[1]/strong")).getText(), Constants.drivername);
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
        driver_search_button.sendKeys(Constants.drivername);
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
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[1]/strong")).getText(),Constants.drivername);
            FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Screenshot3.png"));
            System.out.println("Test 2: searching a driver with Stage and car filter test = Passed");
        }catch (Exception e) {
            System.out.println("Test 2: searching a driver with Stage and car filter test =  Failed");
            System.out.println(e.getMessage());
        }
        //   driver.quit();
    }

    //////Test 3:  Create a new Driver Functionality
    @Test (priority = 3)
    public void create_driver(){
        //System.out.println("Test");

        // checking whether we are on driver page or not
        Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
        WebElement createdriverbtn = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[1]/div[4]/div/button"));
        createdriverbtn.click();
        WebElement firstname, lastname, phone, email, streetaddress, city, state, zip, dmv_licence, tlc_license, adddriverfrombtn, cancelbutn,searchdld ;

       // Accessing Form Elements
        firstname = driver.findElement(By.id("firstName"));
        lastname = driver.findElement(By.id("lastName"));
        phone = driver.findElement(By.id("phone"));
        email = driver.findElement(By.id("email"));
        streetaddress = driver.findElement(By.id("streetAddress"));
        city = driver.findElement(By.id("city"));
        state = driver.findElement(By.id("state"));
        zip = driver.findElement(By.id("zipCode"));
        Select driver_type = new Select(driver.findElement(By.id("isTlc")));
        dmv_licence = driver.findElement(By.id("dmvLicense"));
        tlc_license = driver.findElement(By.id("tlcLicense"));
        searchdld =  driver.findElement(By.name("searchTerm"));
        searchdld.clear();
        adddriverfrombtn = driver.findElement(By.cssSelector("body > div:nth-child(8) > div > div.modal.fade.show > div > div > div.modal-footer > button:nth-child(1)"));
        // Populating form elements
        /// For TLC Drivers
        String random_string = RandomStringUtils.randomAlphanumeric(8);
        Random random = new Random();
        int x = random.nextInt(1000);
        firstname.sendKeys(Constants.driverfirstname+random_string);
        lastname.sendKeys(Constants.driverlastname + random_string);
        phone.sendKeys(Constants.driverphoneno + random_string);
        email.sendKeys(Constants.driveremailf+x+ Constants.driveremailf);

        streetaddress.sendKeys(Constants.driverstreetaddress);
        city.sendKeys(Constants.drivercity);
        state.sendKeys(Constants.driverstate);
        zip.sendKeys(Constants.driverzipcode);
        driver_type.selectByValue("true");
        driver_type.selectByVisibleText("TLC Driver");
        /*
        For Non TLC
        driver_type.selectByValue("false");
        driver_type.selectByVisibleText("Non TLC Driver");
        */
        dmv_licence.sendKeys(Constants.driverdmv_license + random_string);
        tlc_license.sendKeys(Constants.drivertlc_license + random_string);
        System.out.println(firstname.toString()+"Lastname:"+ lastname +"Phone:" + phone + "Email:"+email+"Street Address: "+ streetaddress +"City: "+city+"State: "+state+"ZipCode: "+ zip +"DMV License: "+dmv_licence+"TLC License"+tlc_license);
        adddriverfrombtn.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
            FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Screenshot4.png"));
            System.out.println("Test 3:  Create a new Driver Functionality = Passed");
        }catch (Exception e) {
            System.out.println("Test 3:  Create a new Driver Functionality = Failed");
            System.out.println(e.getMessage());
        }



      driver.quit();
    }


}
