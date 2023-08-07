from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    wait = WebDriverWait(driver, 10)
    print("Title of page:" + driver.title)
    toggleCheckbox = driver.find_element(By.ID, "toggleCheckbox")
    checkBox = driver.find_element(By.ID, "dynamicCheckbox")
    toggleCheckbox.click()
    wait.until(expected_conditions.invisibility_of_element(toggleCheckbox))
    print("Whether checkbox present on webpage:" + str(checkBox.is_displayed()))
    toggleCheckbox.click()
    print("Whether checkbox present on webpage:" + str(checkBox.is_displayed()))
    driver.find_element(By.XPATH, "//input[@class='willDisappear'")
    driver.close()
