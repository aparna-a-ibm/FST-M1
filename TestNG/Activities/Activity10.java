import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Activity10 {
    WebDriver driver;
    @BeforeMethod()
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/simple-form");
        Reporter.log("--Landed on simple form page--",true);
        driver.switchTo().defaultContent();

    }
    @DataProvider(name = "Registration")
    public Object[][] signUpInfo() throws IOException {
        String filePath = "src/data/Activity10_Data.xlsx";
        List<List<String>> data = readData(filePath);
        return new Object[][]{
                {data.get(1)},
                {data.get(2)},
                {data.get(3)},
        };
    }
    public List<List<String>> readData(String filePath) throws IOException {
        List<List<String>> dataList = new ArrayList<List<String>>();
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Data");
        // Iterate through each rows one by one
        for(Row cells : sheet) {
            List<String> rowData = new ArrayList<String>();
            for(Cell cell : cells) {
                if (cell!= null) {
                    if (cell.getCellType() == CellType.STRING) {
                        rowData.add(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC){
                        rowData.add(Double.toString(cell.getNumericCellValue()));
                      }
                   }
                }
            dataList.add(rowData);
            }
        file.close();
        workbook.close();
        return dataList;
    }
    @Test(dataProvider = "Registration")
    public void registerTest(List<String> rows){
        WebElement fName=driver.findElement(By.id("firstName"));
        WebElement lName=driver.findElement(By.id("lastName"));
        WebElement email=driver.findElement(By.id("email"));
        WebElement number=driver.findElement(By.id("number"));
        WebElement message=driver.findElement(By.xpath("//label[text()='Message']/following::textarea"));
        fName.sendKeys(rows.get(1));
        lName.sendKeys(rows.get(2));
        email.sendKeys(rows.get(3));
        number.sendKeys(rows.get(4));
        message.sendKeys(fName.getText()+"entered details.");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String alertText=(driver.switchTo().alert().getText());
        Reporter.log("Text from alert message:"+alertText,true);
        assertEquals(alertText,"Thank You for reaching out to us, "+rows.get(1)+" "+rows.get(2));
        driver.switchTo().alert().accept();
    }
    @AfterMethod()
    public void tearDown() {
        driver.close();
    }

}
