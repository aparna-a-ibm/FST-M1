package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) throws IOException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage:"+driver.getTitle());

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement toggleCheckbox=driver.findElement(By.id("toggleCheckbox"));
        WebElement checkBox=driver.findElement(By.id("dynamicCheckbox"));

        toggleCheckbox.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Whether checkbox present on webpage:"+checkBox.isDisplayed());

        toggleCheckbox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Whether checkbox present on webpage:"+checkBox.isDisplayed());

        driver.findElement(By.xpath("//input[@class='willDisappear']")).click();
        driver.close();

    }
}
