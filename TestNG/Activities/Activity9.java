import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;
    @BeforeMethod()
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("--Landed on Login page--",true);
        driver.switchTo().defaultContent();
    }
    @Test(priority =1)
    public void simpleAlertTestCase(){
        Reporter.log("--Running Test Case for simple alert--",true);
        driver.findElement(By.id("simple")).click();
        Reporter.log("--Clicked on simple alert--",true);
        Alert simpleAlert=driver.switchTo().alert();
        Reporter.log("--Switched focus to alert--",true);
        String alertTextMsg=simpleAlert.getText();
        Reporter.log("Text from alert:"+alertTextMsg,true);
        Assert.assertEquals("This is a JavaScript Alert!", alertTextMsg);
        simpleAlert.accept();
        Reporter.log("--Closed simple alert--",true);
        Reporter.log("----------Testcase completed----------",true);
    }
    @Test(priority = 2)
    public void confirmAlertTestCase(){
        Reporter.log("--Running Test Case for confirmation alert--",true);
        driver.findElement(By.id("confirm")).click();
        Reporter.log("--Clicked on confirm alert--",true);
        Alert confirmAlert=driver.switchTo().alert();
        Reporter.log("--Switched focus to alert--",true);
        String alertTextMsg=confirmAlert.getText();
        Reporter.log("Text from confirmation alert:"+alertTextMsg,true);
        Assert.assertEquals("This is a JavaScript Confirmation!", alertTextMsg);
        confirmAlert.accept();
        Reporter.log("--Closed confirmation alert--",true);
        Reporter.log("----------Testcase completed----------",true);
    }
    @Test(priority =3)
    public void promptAlertTestCase(){
        Reporter.log("--Running Test Case for prompt alert--",true);
        driver.findElement(By.id("prompt")).click();
        Reporter.log("--Clicked on prompt alert--",true);
        Alert promptAlert=driver.switchTo().alert();
        Reporter.log("--Switched focus to alert--",true);
        String alertTextMsg=promptAlert.getText();
        promptAlert.sendKeys("Sending input to prompt alert.");
        Reporter.log("Text from prompt alert:"+alertTextMsg,true);
        Assert.assertEquals("This is a JavaScript Prompt!", alertTextMsg);
        promptAlert.dismiss();
        Reporter.log("--Closed prompt alert--",true);
        Reporter.log("----------Testcase completed----------",true);
    }

    @AfterMethod()
    public void tearDown() {
        driver.close();
    }
}
