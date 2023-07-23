package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.PrintStream;

public class Activity5 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of webpage:"+driver.getTitle());
        Actions builder = new Actions(driver);
        WebElement cubeElmt=driver.findElement(By.id("D3Cube"));

        builder.click(cubeElmt).pause(1000).build().perform();
        System.out.println("Value in front after left click:"+driver.findElement(By.xpath("//div[@class='active']")).getText());

        builder.doubleClick(cubeElmt).pause(1000).build().perform();
        System.out.println("Value in front after double click:"+driver.findElement(By.xpath("//div[@class='active']")).getText());

        builder.contextClick(cubeElmt).pause(1000).build().perform();
        System.out.println("Value in front after right click:"+driver.findElement(By.xpath("//div[@class='active']")).getText());
        driver.close();

    }
}
