import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class ProjectActivities {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        Reporter.log("Navigating to LMS website:");
        driver.get("https://alchemy.hguy.co/lms");
        Reporter.log("Landed on LMS website:");
    }
    @Test
    public void Activity1(){
        //Verifying the title of the website
        String title= driver.getTitle();
        Assert.assertEquals(title,"Alchemy LMS – An LMS Application");
        Reporter.log("Validated title of website.");
    }

    @Test
    public void Activity2(){
        //Verifying the heading of the website
        String headingText=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(headingText,"Learn from Industry Experts");
    }
    @Test
    public void Activity3(){
        WebElement infoBox=driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[1]"));
        String infoBoxText=infoBox.getText();
        Assert.assertEquals(infoBoxText,"Actionable Training");
    }
    @Test
    public void Activity4(){
        String secondPopularCourseTitle=driver.findElement(By.xpath("(//h3[@class='entry-title'])[2]")).getText();
        Assert.assertEquals(secondPopularCourseTitle,"Email Marketing Strategies");
    }
    @Test
    public void Activity5(){
        WebElement myAccount=driver.findElement(By.linkText("My Account"));
        myAccount.click();
        String websiteTitle= driver.getTitle();
        Assert.assertEquals(websiteTitle,"My Account – Alchemy LMS","Page title is not as expected");
        Reporter.log("Landed on My Account page");
    }
    @Test
    @Parameters({ "sUsername", "sPassword" })
    public void Activity6(String sUsername, String sPassword){

        WebElement myAccount=driver.findElement(By.linkText("My Account"));
        myAccount.click();
        String websiteTitle= driver.getTitle();
        Assert.assertEquals(websiteTitle,"My Account – Alchemy LMS","Page title is not as expected");
        Reporter.log("Landed on My Account page");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_login")).sendKeys(sUsername);
        driver.findElement(By.id("user_pass")).sendKeys(sPassword);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Howdy,')]"));
        Reporter.log("User logged in.");
    }
    @Test
    public void Activity7(){
        driver.findElement(By.linkText("All Courses")).click();
        List<WebElement> numOfCourses=driver.findElements(By.xpath("//div[@class='ld-course-list-items row']"));
        System.out.println("Number of courses : "+ numOfCourses.size());
    }
    @Test
    public void Activity8(){
        driver.findElement(By.linkText("Contact")).click();
        driver.findElement(By.xpath("//label[text()='Full Name ']/following::input[1]")).sendKeys("User A");
        driver.findElement(By.xpath("//label[text()='Email ']/following::input[1]")).sendKeys("UserA@test7.com");
        driver.findElement(By.xpath("//label[text()='Subject']/following::input[1]")).sendKeys("Test message subject");
        driver.findElement(By.xpath("//label[text()='Comment or Message ']/following::textarea")).sendKeys("Test message content");
        driver.findElement(By.xpath("//button[@data-submit-text='Send Message']")).click();
    }
    @Test
    @Parameters({ "sUsername", "sPassword" })
    public void Activity9(String sUsername, String sPassword) throws InterruptedException {

        driver.findElement(By.linkText("All Courses")).click();
        driver.findElement(By.linkText("See more...")).click();
        driver.findElement(By.xpath("//a[text()='Login to Enroll' or  text()='Login']")).click();
        driver.findElement(By.id("user_login")).sendKeys(sUsername);
        driver.findElement(By.id("user_pass")).sendKeys(sPassword);
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Log In']"))).click();
        WebElement courseSection=driver.findElement(By.xpath("(//div[@class='ld-item-title'])[2]"));
        String title= courseSection.getText().split("\n")[0];
        courseSection.click();
        Assert.assertEquals(driver.getTitle(),title+" – Alchemy LMS");
        driver.findElement(By.xpath("//span[@class='ld-topic-title']")).click();
        try {
            WebElement markComplete = driver.findElement(By.xpath("(//input[@value='Mark Complete'])[2]"));
            if (markComplete.isDisplayed()) {
                markComplete.click();
                System.out.println("Course marked Completed");
            } else {
                System.out.println("Mark Complete is disabled.");
            }
        }
        catch (Exception e){
            System.out.println("Course already completed");
        }
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
