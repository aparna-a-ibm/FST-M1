import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Activity6 {
    WebDriver driver;
    @BeforeMethod()
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    @Parameters({ "username", "password" })
    public void test(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        assertEquals(loginMessage, "Welcome Back, admin");
    }
    @AfterMethod()
    public void tearDown(){
        driver.close();
    }

}
