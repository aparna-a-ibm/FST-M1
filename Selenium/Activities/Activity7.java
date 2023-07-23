package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import java.io.IOException;

public class Activity7 {
    public static void main(String[] args) throws IOException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Title of webpage:"+driver.getTitle());
        Actions builder=new Actions(driver);

        // Find the football
        WebElement football = driver.findElement(By.id("draggable"));
        // Find the dropzone1
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        // Find the dropzone2
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        builder.clickAndHold(football).moveToElement(dropzone1).release().build().perform();
        String verifyDropped1=driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        if(verifyDropped1.equalsIgnoreCase("Dropped!")){
            System.out.println("Ball dropped to Dropzone 1");
        }
        builder.dragAndDrop(dropzone1,dropzone2).perform();
        String verifyDropped2=driver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText();
        if(verifyDropped2.equalsIgnoreCase("Dropped!")){
            System.out.println("Ball dropped to Dropzone 2");
        }
        driver.close();
    }
}
