from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/selects")
    wait = WebDriverWait(driver, 10)
    print("Title of webpage:" + driver.title)
    singleSelect = Select(driver.find_element(By.ID, "single-select"))
    singleSelect.select_by_visible_text("Option 2")
    print("Selected the second option using visible text:" + singleSelect.first_selected_option.text)
    singleSelect.select_by_index(3)
    print("Selected the third option using index:" + singleSelect.first_selected_option.text)
    singleSelect.select_by_value("4")
    print("Selected the fourth option using value:" + singleSelect.first_selected_option.text)
    print("All items from select dropdown:")
    for selectOption in singleSelect.options:
        print(selectOption.text)
    driver.close()
