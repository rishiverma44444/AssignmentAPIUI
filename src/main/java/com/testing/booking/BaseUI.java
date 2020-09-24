package com.testing.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI {

	static WebDriver driver = null;

	//Driver Initialised
	public static void initialise() {
		if (driver == null) {
			if (GlobalConstants.BROWER_NAME.equalsIgnoreCase("Chrome")) {
				System.setProperty(GlobalConstants.CHROME_DRIVER, GlobalConstants.CHROME_PATH);
				driver = new ChromeDriver();
			} else {
				if (GlobalConstants.BROWER_NAME.equalsIgnoreCase("Firefox")) {
					System.setProperty(GlobalConstants.FIREFOX_DRIVER, GlobalConstants.FIREFOX_PATH);
					driver = new FirefoxDriver();
				}
			}
		}
	}

	/*Open Web URL
	 * URL website URL
	 */
	public static void openURL(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	//Quit Window
	public static void quit() {
		driver.quit();
	}

	//Close tab
	public static void close() {
		driver.close();
	}

	/*Find elements
	 * Provide locator of the element
	 * Return webelement
	 */
	public static WebElement findElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	//CLick element
	public static void click(String locater) {
		driver.findElement(By.xpath(locater)).click();
	}

	//Send Input to fill fields
	public static void sendKeys(String locater, String Input) {
		driver.findElement(By.xpath(locater)).sendKeys(Input);
	}

	/* To get text of selected Element
	 * locator element locator
	 * Return String
	 */
	public static String getText(String locater) {
		return driver.findElement(By.xpath(locater)).getText();
	}

	/*Explicit Wait
	 * time Any valid integer value
	 * Locator element to be searched 
	 */
	public static void customWait(long time, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	/*Select element on basis of visible text
	 * element Weblement of Select Element
	 * value Visible text to be selected
	 */
	public static void dropDown(WebElement element, String value) {
		Select slt = new Select(element);
		slt.selectByVisibleText(value);
	}

	/*This method will fetch all prices and select the Flight which have the minimum cost
	 * locator element to be searched
	 * Return minimum price
	 */
	public static String chooseFlight(String locator) {
		List<WebElement> list = driver.findElements(By.xpath(locator));
		ArrayList<String> prices = new ArrayList<String>();
		for (WebElement str : list) {
			prices.add(str.getAttribute("value").toString());
		}
		Collections.sort(prices);
		String price = "//*[contains(text(),'" + prices.get(0) + "')]/parent::tr//input[@type='submit']";
		return price;
	}
	
	//Return Locator String
	public static String ValidatePrice(String price){
		return "//*[contains(text(),'" + price + "')]";
	}
	
	//Clear exisiting data from a field
	public static void clear(String locator){
		driver.findElement(By.xpath(locator)).clear();
	}
}
