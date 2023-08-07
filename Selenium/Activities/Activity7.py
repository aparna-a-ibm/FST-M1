from selenium import webdriver
from selenium.webdriver import Keys, ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Page title is: ", driver.title)
    actions = ActionChains(driver)
    footBall = driver.find_element(By.ID, "draggable")
    dropZoneOne = driver.find_element(By.ID, "droppable")
    dropZoneTwo = driver.find_element(By.ID, "dropzone2")
    actions.click_and_hold(footBall).move_to_element(dropZoneOne).release().perform()
    verifyDroppedOne = driver.find_element(By.XPATH, "//div[@id='droppable']/p").text
    if verifyDroppedOne == "Dropped!":
        print("Ball dropped to Dropzone 1")
    actions.drag_and_drop(dropZoneOne, dropZoneTwo).perform()
    verifyDroppedTwo = driver.find_element(By.XPATH, "//div[@id='dropzone2']/p").text
    if verifyDroppedOne == "Dropped!":
        print("Ball dropped to Dropzone 2")
    driver.close()
