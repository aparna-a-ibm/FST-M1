from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Title of webpage:" + driver.title)
    print(driver.find_element(By.XPATH, "//h3").text)
    print(driver.find_element(By.XPATH, "//h5").value_of_css_property("color"))
    print(driver.find_element(By.XPATH,"//button[text()='Violet']").get_attribute("class"))
    print(driver.find_element(By.XPATH,"//button[text()='Grey']").text)
    driver.close()


