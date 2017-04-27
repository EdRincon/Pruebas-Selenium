import unittest
import re
import time

from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.keys import Keys


class FirstWebDriverTest(unittest.TestCase):
    # set_up
    driver = webdriver.Chrome()
    URL = 'http://www.bestbuy.com'
    ITEM = "moto x pure"
    CHARACTERISTICS = '32'
    PRICE = '199.99'
    STATE = 'Refurbished'
    Quantity = '2'
    SHOP = 'MCALLEN TX'

    def test_buy_motox(self):
        self.driver.get(self.URL)
        self.driver.implicitly_wait(10)
        c_url = self.driver.current_url
        self.driver.find_element_by_class_name('intl_drop').send_keys('u')
        self.driver.find_element_by_class_name('go_button').click()
        if c_url != self.URL:
            try:
                self.driver.find_element_by_class_name('close').click()
            except NoSuchElementException:
                pass
                self.driver.find_element_by_id('gh-search-input').send_keys(self.ITEM)
        self.driver.find_element_by_class_name('hf-icon-search').click()
        x = self.driver.find_elements_by_class_name('facet-value  ')
        for element in x:
            if re.search(self.CHARACTERISTICS, element.text):
                element.click()
                time.sleep(2)
                break
        prices = self.driver.find_elements_by_class_name('list-item-price-content')
        for element in prices:
            if re.search(self.PRICE, element.text):
                time.sleep(2)
                element.find_element_by_link_text('Add to Cart').click()
                time.sleep(5)
        self.driver.find_element_by_class_name('go-to-cart').click()
        desc = self.driver.find_element_by_class_name('emphasized-copy').text
        assert re.search(self.STATE, desc)
        time.sleep(2)
        box = self.driver.find_element_by_xpath('/html/body/div[3]/div[2]/div/div/div[4]/div/div[1]/div[2]/div[2]/ul/l'
                                                'i/div[2]/div/div/div[3]/div[2]/div/div/div[1]/input')
        box.clear()
        box.send_keys(2)
        box.send_keys(Keys.RETURN)
        time.sleep(5)
        self.driver.find_element_by_link_text('Select a store').click()
        time.sleep(2)
        stores = self.driver.find_elements_by_class_name('store-name')
        for element in stores:
            if element.text == self.SHOP:
                element.click()
        self.driver.find_element_by_class_name('modal-select-store--primary').click()
        time.sleep(5)
        p_total = self.driver.find_elements_by_xpath('//*[@id="order-summary"]/div/div[1]/div/div[3]/div[2]')
        assert re.search((str(float(self.PRICE) * 2)), p_total[0].text)
        self.driver.find_element_by_link_text('Checkout').click()
        time.sleep(5)
        self.driver.find_element_by_link_text('Continue as Guest').click()

    def tear_down(self):
        self.driver.close()
