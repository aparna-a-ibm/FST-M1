package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of webpage:" + driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
        System.out.println("Number of rows in first table:"+rows.size());
        List<WebElement> columns=driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
        System.out.println("Number of columns in first table:"+columns.size());

        List<WebElement> thirdRow=driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        System.out.println("Cell values of third row:");
        for(WebElement cell:thirdRow) {
            System.out.println(cell.getText());
        }
        System.out.println("Cell value in second row and column:"+driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")).getText());
        driver.close();
    }
}
