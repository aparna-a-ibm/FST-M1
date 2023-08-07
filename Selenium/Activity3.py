from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Activity1 with XPATH
    driver.get("https://v1.training-support.net/")
    print("Title of the webpage:" + driver.title)
    driver.find_element(By.XPATH, "//a[text()='About Us']").click()
    print("Title of the webpage now:" + driver.title)

    # Activity2 with XPATH
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Navigate to webpage:" + driver.title)
    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")
    driver.find_element(By.XPATH, "//button[text()='Log in']").click()
    if (driver.find_element(By.XPATH, "//div[@id='action-confirmation']")).is_displayed():
        print("Login successful!")
    driver.close()
