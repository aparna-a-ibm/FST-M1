import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        // Set up the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
    }
    @Test
    public void activity1Test(){
        String title=driver.getTitle();
        System.out.println("Home page title:"+title);
        assertEquals(title,"Training Support",title);
        driver.findElement(By.id("about-link")).click();
        String newTitle=driver.getTitle();
        System.out.println("New title:"+newTitle);
        assertEquals("About Training Support",newTitle);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
