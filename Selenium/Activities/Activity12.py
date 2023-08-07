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
    textField = driver.find_element(By.ID, "input-text")
    checkIfEnabled = textField.is_enabled()
    print("Text field enabled=" + str(checkIfEnabled))
    driver.find_element(By.ID, "toggleInput").click()
    checkIfEnabled = textField.is_enabled()
    print("Text field enabled=" + str(checkIfEnabled))
    driver.close()
