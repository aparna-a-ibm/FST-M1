package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity1 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result,"16","Expected output not generated.");
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
