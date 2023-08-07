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
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    wait = WebDriverWait(driver, 10)
    print("Title of webpage:" + driver.title)
    driver.find_element(By.XPATH, "//input[contains(@class, '-username')]").send_keys("Aparna")
    driver.find_element(By.XPATH, "//input[contains(@class, '-password')]").send_keys("Aparna")
    driver.find_element(By.XPATH, "//label[text()='Confirm Password']/following-sibling::input").send_keys("Aparna")
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'email-')]").send_keys("aparna.a4@ibm.com")

    driver.find_element(By.XPATH, "//button[text()='Sign Up']").click()
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation")))
    print("Login message:" + driver.find_element(By.ID, "action-confirmation").text)

    driver.close()
