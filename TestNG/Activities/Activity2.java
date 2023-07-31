import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        // Set up the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void testCaseOne(){
        String title=driver.getTitle();
        assertEquals("Target Practice",title);
    }
    @Test
    public void testCaseTwo(){
        WebElement blackBtn=driver.findElement(By.xpath("//button[text()='Black']"));
        assertEquals("Blue",blackBtn.getText());
    }

    @Test(enabled = false)
    public void testCaseThree(){
        String heading=driver.findElement(By.tagName("h3")).getText();
        System.out.println("Third heading:"+heading);
    }
    @Test
    public void testCaseFour(){
        throw new SkipException("Skipping test four");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
