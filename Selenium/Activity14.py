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
    rows = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr")
    print("Number of rows in first table:" + str(len(rows)))
    columns = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr[1]/td")
    print("Number of columns in first table:" + str(len(columns)))
    print("Cell value in second row and column:" + driver.find_element(By.XPATH,"//table[@id='sortableTable']/tbody/tr[2]/td[2]").text)
    print("Clicking on header of the first column...")
    driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th[1]").click()
    print("Cell value in second row and column after sorting by name:" + driver.find_element(By.XPATH,"//table[@id='sortableTable']/tbody/tr[2]/td[2]").text)
    footer = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tfoot/tr/th")
    print("Cell values of the footer: ")
    for cell in footer:
        print(cell.text)
    driver.close()
