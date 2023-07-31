package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("User is on Google Home Page")
    public void user_is_on_google_home_page() throws Throwable{
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.google.com");
    }
    @When("User types in Cheese and hits ENTER")
    public void type_into_searchbox(){
        WebElement searchBox=driver.findElement(By.xpath("//textarea[@type='search']"));
        searchBox.sendKeys("Cheese");
        searchBox.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
    }
    @Then("Show how many search results were shown")
    public void show_search_result(){
        System.out.println("Number of search results shown on first page:"+driver.findElements(By.xpath("//h3")).size());
    }
    @And("Close the browser")
    public void close_browser(){
        driver.close();
    }

}
