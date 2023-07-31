import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity5 {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void titleTest(){
        String title=driver.getTitle();
        assertEquals("Target Practice",title);
    }

    @Test(groups = {"HeaderTests"})
    public void headerTest1(){
        WebElement thirdHeader= driver.findElement(By.tagName("h3"));
        assertEquals("Third header",thirdHeader.getText());
    }
    @Test(groups = {"HeaderTests"})
    public void headerTest2(){
        WebElement fifthHeader=driver.findElement(By.tagName("h5"));
        String hexColourCode = Color.fromString(fifthHeader.getCssValue("color")).asHex();
        assertEquals("#21ba45",hexColourCode);
    }
    @Test(groups = {"ButtonTests"})
    public void buttonTest1(){
        WebElement oliveBtn=driver.findElement(By.xpath("//button[contains(@class,'olive')]"));
        assertEquals("Olive",oliveBtn.getText());
    }
    @Test(groups = {"ButtonTests"})
    public void buttonTest2(){
        WebElement oliveBtn=driver.findElement(By.xpath("//button[text()='Brown']"));
        String hexColourCode = Color.fromString(oliveBtn.getCssValue("background-color")).asHex();
        assertEquals("#a5673f",hexColourCode);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
