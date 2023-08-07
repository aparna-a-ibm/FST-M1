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
    driver.get("https://v1.training-support.net/selenium/tab-opener")
    wait = WebDriverWait(driver, 10)
    print("Title of homepage:" + driver.title)
    print("Parent tab: " + str(driver.current_window_handle))
    driver.find_element(By.ID, "launcher").click()
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("Currently open windows: " + str(driver.window_handles))
    for handle in driver.window_handles:
        driver.switch_to.window(handle)
    wait.until(expected_conditions.title_is("Newtab"))
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "actionButton"))).click()
    print("Current tab: " + driver.current_window_handle)
    print("Page title: " + driver.title)
    print("Heading of web page:" + driver.find_element(By.XPATH, "//div[@class='content']").text)
    wait.until(expected_conditions.number_of_windows_to_be(3))
    for handle in driver.window_handles:
        driver.switch_to.window(handle)
    wait.until(expected_conditions.title_is("Newtab2"))
    print("Current tab: " + driver.current_window_handle)
    print("Page title: " + driver.title)
    print("Heading of web page:" + driver.find_element(By.XPATH, "//div[@class='content']").text)

    driver.quit()
