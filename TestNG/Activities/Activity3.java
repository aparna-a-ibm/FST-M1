import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    public void loginTest(){
        WebElement username=driver.findElement(By.id("username"));
        WebElement pass=driver.findElement(By.id("password"));
        WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));

        username.sendKeys("admin");
        pass.sendKeys("password");
        loginBtn.click();

        String cnfrmMessage=driver.findElement(By.id("action-confirmation")).getText();
        assertEquals("Welcome Back, admin",cnfrmMessage);

    }
    @AfterClass
    public void tearDown(){

        driver.close();
    }


}


