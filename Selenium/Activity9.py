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
    driver.get("https://v1.training-support.net/selenium/ajax")
    wait = WebDriverWait(driver, 10)
    driver.find_element(By.XPATH, "//button[@class='ui violet button']").click()
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//h1[text()='HELLO!']")))
    print(driver.find_element(By.TAG_NAME, "h3").text)
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    print(driver.find_element(By.TAG_NAME, "h3").text)
    driver.close()
