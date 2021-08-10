import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class drivers_profile extends setup{
    @BeforeTest
    @Override
    public void setupbrowser() { super.setupbrowser(); }

    // Test 1:  Opening the Drivers Profile Screen
    @Test(priority = 1)
    public void open_driver_profile(){
        // Declaring the Web elements.
        WebElement openbutton, fetcheddrivername;

        Assert.assertEquals(driver.findElement(By.linkText("Non TLC Drivers")).getText(),"Non TLC Drivers");
        WebElement driver_search_button =  driver.findElement(By.name("searchTerm"));
        driver_search_button.sendKeys(Constants.searchdrivername);
        driver_search_button.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'OPEN')]")));


        openbutton = driver.findElement(By.xpath("//span[contains(text(),'OPEN')]"));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        openbutton.click();

        try{

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.ByTagName,'OPEN')]")));

            FileUtils.copyFile(screenshot,new File("D:\\Buggy Workspace\\testautomationproject\\Screenshots\\Open_driver_profile.png"));
            System.out.println("Test 1:  Opening the Drivers Profile Screen = Passed");
        }catch(Exception e) {
            System.out.println("Test 1:  Opening the Drivers Profile Screen = Failed");
            System.out.println(e.getMessage());
        }


    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
