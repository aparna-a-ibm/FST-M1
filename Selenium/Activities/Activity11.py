from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    wait = WebDriverWait(driver, 10)
    print("Title of webpage:" + driver.title)
    checkBox = driver.find_element(By.XPATH, "//input[@class='willDisappear']")
    checkBox.click()
    checkSelected = checkBox.is_selected()
    print("Checkbox selected=" + str(checkSelected))
    checkBox.click()
    checkSelected = checkBox.is_selected()
    print("Checkbox selected=" + str(checkSelected))
    driver.close()
