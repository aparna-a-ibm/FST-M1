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
    multiSelect = Select(driver.find_element(By.ID, "multi-select"))
    multiSelect.select_by_visible_text("Javascript")

    multiSelect.select_by_index(4)

    multiSelect.select_by_index(5)

    multiSelect.select_by_index(6)

    multiSelect.select_by_value("node")

    print("Selected options are: ")
    for option in multiSelect.all_selected_options:
        print(option.text)

    multiSelect.deselect_by_index(5)
    print("\nSelected options after deselecting fifth option: ")
    for option in multiSelect.all_selected_options:
        print(option.text)
    driver.close()
