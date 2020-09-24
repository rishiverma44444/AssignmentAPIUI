 package com.testing.booking;

public class GlobalConstants {

	public static final String CONFIG = System.getProperty("user.dir") + "\\Config.properties";
	public static final String BROWER_NAME = "Chrome";
	public static final String CITY_NAME = WebUtils.getValue("CITY_NAME");
	public static final String WEB_URL = WebUtils.getValue("WEB_URL");
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\Screenshot\\";
	public static final String CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String CHROME_PATH = System.getProperty("user.dir") + "\\chromedriver.exe";
	public static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
	public static final String FIREFOX_PATH = System.getProperty("user.dir") + "\\geckodriver.exe";
	public static final String DEPARTURE_LOCATOR = "//*[@name = 'fromPort']";
	public static final String DESTINATION_LOCATOR = "//*[@name = 'toPort']";
	public static final String FIND_FLIGHTS = "//input[@type='submit']";
	public static final String TITLE = "//*[text()='Welcome to the Simple Travel Agency!']";
	public static final String DEPARTURE_CITY = WebUtils.getValue("DEPARTURE_CITY");
	public static final String DESTINATION_CITY = WebUtils.getValue("DESTINATION_CITY");
	public static final String FIND_TITLE = "//*[text()='Flights from Boston to Rome: ']";
	public static final String CHOOSE_FLIGHT = "//input[@type='submit']";
	public static final String PRICE_LOCATOR = "//input[@name='price']";
	public static final String RESERVATION_TITLE = "//*[text() = 'Please submit the form below to purchase the flight.']";
	public static final String RESERVATION_PRICE = "//*[contains(text() ,'Price:')]";
	public static final String NAME = "//input[@id='inputName']";
	public static final String ADDRESS = "//input[@id ='address']";
	public static final String CITY = "//input[@id ='city']";
	public static final String STATE = "//input[@id ='state']";
	public static final String ZIPCODE = "//input[@id ='zipCode']";
	public static final String CARDTYPE = "//*[@id ='cardType']";
	public static final String CREDITCARDNUMBER = "//input[@id ='creditCardNumber']";
	public static final String CREDITMONTH = "//input[@id ='creditCardMonth']";
	public static final String CREDITYEAR = "//input[@id='creditCardYear']";
	public static final String CREDITNAME = "//input[@id ='nameOnCard']";
	public static final String REMEBERME = "//input[@id='rememberMe']";
	public static final String PURCHASEFLIGHT = "//input[@type ='submit']";
	public static final String THANKYOU = "//*[text()='Thank you for your purchase today!']";
	public static final String PURCHASE_ID = "//*[@class='table']/tbody/tr/td[2]";
	
	/*====================================API Constants=====================================================*/
			
	public static final String JSON_REPSONSE = System.getProperty("user.dir")+"\\TestResources\\SpaceXJsonResponse.json";
	public static final String API_URI = WebUtils.getValue("API_HOST");
}