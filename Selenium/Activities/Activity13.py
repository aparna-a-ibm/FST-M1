from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    wait = WebDriverWait(driver, 10)
    print("Title of webpage:" + driver.title)
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
    print("Number of rows in first table:" + str(len(rows)))
    columns = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("Number of columns in first table:" + str(len(columns)))
    thirdRow = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]/td")
    print("Cell values of third row:")
    for cell in thirdRow:
        print(cell.text)
    print("Cell value in second row and column:" + driver.find_element(By.XPATH, "//table[contains(@class, "
                                                                                 "'striped')]/tbody/tr[2]/td[2]").text)
    driver.close()
