import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class login  extends setup {


    @BeforeTest
    @Override
    public void setupbrowser() {
        super.setupbrowser();
    }
    // Test 0: To verify if login fields can take data or not
    @Test (priority = 0)
    public void login_0(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            username.click();
            password.click();
            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot0.png"));
            System.out.println("Test 0: To verify if login fields can take data or not = Passed");
        } catch (Exception e) {
            System.out.println("Test 0: To verify if login fields can take data or not = Failed");
            System.out.println(e.getMessage());
        }
    }
    ///// Test 1: To verify login
    @Test (priority = 1)
    public void login_1(){
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
            System.out.println("Test 1: To verify login  = Passed");
            WebElement logoutbtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[1]/p/span[1]/a"));
            logoutbtn.click();
        } catch(Exception e){
            System.out.println("Test 1: To verify login  = Failed");
            System.out.println(e.getMessage());
        }
    }
    ///// Test 2: To verify login with Empty Fields
    @Test (priority = 2)
    public void login_2(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys("");
        password.sendKeys("");
        loginbutton.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot2.png"));
            System.out.println("Test 1: To verify login with Empty Fields  = Passed");
        } catch(Exception e){
            System.out.println("Test 2: To verify login with Empty Fields = Failed");
            System.out.println(e.getMessage());
        }
    }
    ///// Test 3: To verify login with blank username and filled password
    @Test (priority = 3)
    public void login_3(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys("");
        password.sendKeys(Constants.password);
        loginbutton.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot3.png"));
            System.out.println("Test 3: To verify login with blank username and filled password = Passed");
        } catch(Exception e){
            System.out.println("Test 3: To verify login with blank username and filled password = Failed");
            System.out.println(e.getMessage());
        }
    }
    ///// Test 4: To verify login with filled username and blank password
    @Test (priority = 4)
    public void login_4(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys(Constants.username);
        password.sendKeys("");
        loginbutton.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot4.png"));
            System.out.println("Test 4: To verify login with filled username and blank password = Passed");
        } catch(Exception e){
            System.out.println("Test 4: To verify login with filled username and blank password = Failed");
            System.out.println(e.getMessage());
        }

    }
    ///// Test 5: To verify login with correct username and incorrect password
    @Test (priority = 5)
    public void login_5(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys(Constants.username);
        password.sendKeys("test");
        loginbutton.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");
            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot5.png"));
            System.out.println(" Test 5: To verify login with correct username and incorrect password = Passed");
        } catch(Exception e){
            System.out.println(" Test 5: To verify login with correct username and incorrect password = Failed");
            System.out.println(e.getMessage());

        }
    }
    ///// Test 6: To verify login with incorrect username and correct password
    @Test (priority = 6)
    public void login_6(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys("Tayyab test");
        password.sendKeys(Constants.password);
        loginbutton.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");

            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot5.png"));
            System.out.println(" Test 6: To verify login with incorrect username and correct password = Passed");
        } catch(Exception e){
            System.out.println("Test 6: To verify login with incorrect username and correct password = Failed");
            System.out.println(e.getMessage());

        }
    }
    ///// Test 7: To verify login with special characters
    @Test (priority = 7)
    public void login_7(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        username.sendKeys("!@#!@#!@#");
        password.sendKeys("!@#!@#!@#");
        loginbutton.click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");

            FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot7.png"));
            System.out.println(" Test 7: To verify login with special characters = Passed");
        } catch(Exception e){
            System.out.println("Test 7: To verify login with special characters = Failed");
            System.out.println(e.getMessage());

        }
    }
    ///// Test 8: To verify login with Alphanumeric characters
    @Test (priority = 8)
    public void login_8(){
        driver.get(Constants.baseurl);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        String random_stringusername = RandomStringUtils.randomAlphanumeric(8);
        username.sendKeys(random_stringusername);
        password.sendKeys(random_stringusername);
        loginbutton.click();
        // File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        try {
            Assert.assertEquals(driver.findElement(By.linkText("Drivers")).getText(),"Drivers");

            //   FileUtils.copyFile(screenshot,new File(Constants.screenshot_directory + "\\Screenshot8.png"));
            System.out.println(" Test 8: To verify login with Alphanumeric characters = Passed");
        } catch(Exception e){
            try{
                // driver.manage().window().maximize();
                ImageIO.write(screenshot.getImage(),"PNG",new File(Constants.screenshot_directory + "\\Screenshot8.png"));
            } catch (Exception a) {
                System.out.println("Test 8: To verify login with Alphanumeric characters = Failed");
                System.out.println(a.getMessage());
            }
        }
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
