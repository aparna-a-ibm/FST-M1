from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    wait = WebDriverWait(driver, 10)
    print("Title of webpage:" + driver.title)
    driver.find_element(By.ID, "prompt").click()
    print("Text from alert box:" + driver.switch_to.alert.text)
    driver.switch_to.alert.send_keys("Awesome!")
    driver.switch_to.alert.accept()
    driver.close()
