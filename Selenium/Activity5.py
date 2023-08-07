from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title of webpage:" + driver.title)
    actions = webdriver.ActionChains(driver)

    actions.click().pause(3).perform()
    print("Value of the side on front after left click:" + driver.find_element(By.XPATH, "//div[@class='active']").text)

    actions.double_click().pause(3).perform()
    print("Value of the side on front after left click:" + driver.find_element(By.XPATH, "//div[@class='active']").text)

    actions.context_click().pause(3).perform()
    print("Value of the side on front after left click:" + driver.find_element(By.XPATH, "//div[@class='active']").text)

    driver.close()
