from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/popups")
    wait = WebDriverWait(driver, 10)
    print("Title of homepage:" + driver.title)
    builder = ActionChains(driver)
    button = driver.find_element(By.XPATH, "//button[contains(@class,'orange button')]")
    builder.move_to_element(button).perform()
    print("Tooltip message:" + button.get_attribute("data-tooltip"))

    button.click()
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//button[text()='Log in']").click()
    print("Login message:" + driver.find_element(By.ID, "action-confirmation").text)
    driver.close()
