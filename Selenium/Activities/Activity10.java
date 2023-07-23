package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) throws IOException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/dynamic-controls");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Title of webpage:" + driver.getTitle());
        WebElement checkBox=driver.findElement(By.xpath("//input[@class='willDisappear']"));
        if(checkBox.isDisplayed()){
            System.out.println("Checkbox is displayed.");
        }
        else{
            System.out.println("Checkbox is not displayed.");
        }
        driver.findElement(By.id("toggleCheckbox")).click();
        if(checkBox.isDisplayed()){
            System.out.println("Checkbox is displayed.");
        }
        else{
            System.out.println("Checkbox is not displayed.");
        }
        driver.close();
    }
}
