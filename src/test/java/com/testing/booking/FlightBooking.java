package com.testing.booking;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightBooking {

	static String cost;

	@BeforeTest(enabled = true)
	public void setup() {

		BaseUI.initialise();

	}

	@Test(enabled = true, priority = 1, description = "To verify that Website open successfully")
	public void openWebsite() throws IOException {

		BaseUI.openURL(GlobalConstants.WEB_URL);
		Assert.assertEquals(BaseUI.getText(GlobalConstants.TITLE), "Welcome to the Simple Travel Agency!");

	}

	@Test(enabled = true, priority = 2, description = "Choose Cities as per Config.properties")
	public void chooseCities() {

		WebElement source = BaseUI.findElement(GlobalConstants.DEPARTURE_LOCATOR);
		BaseUI.dropDown(source, GlobalConstants.DEPARTURE_CITY);
		WebElement destination = BaseUI.findElement(GlobalConstants.DESTINATION_LOCATOR);
		BaseUI.dropDown(destination, GlobalConstants.DESTINATION_CITY);
		BaseUI.click(GlobalConstants.FIND_FLIGHTS);
		Assert.assertEquals(BaseUI.getText(GlobalConstants.FIND_TITLE), "Flights from Boston to Rome:");

	}

	@Test(enabled = true, priority = 4, description = "Reservation Screen Open succcessfully")
	public void flightSelected() {

		cost = BaseUI.chooseFlight(GlobalConstants.PRICE_LOCATOR);
		BaseUI.click(cost);
		Assert.assertEquals(BaseUI.getText(GlobalConstants.RESERVATION_TITLE),"Please submit the form below to purchase the flight.");

	}

	@Test(enabled = true, priority = 5, description = "Reservation form filled up and submitted succesfully")
	public void reservationForm() {

		BaseUI.sendKeys(GlobalConstants.NAME, "BOOKER");
		BaseUI.sendKeys(GlobalConstants.ADDRESS, "BOOKER ADDRESS");
		BaseUI.sendKeys(GlobalConstants.CITY, "BOOKER CITY");
		BaseUI.sendKeys(GlobalConstants.STATE, "BOOKER STATE");
		BaseUI.sendKeys(GlobalConstants.ZIPCODE, "12345");
		BaseUI.dropDown(BaseUI.findElement(GlobalConstants.CARDTYPE), "Visa");
		BaseUI.sendKeys(GlobalConstants.CREDITCARDNUMBER, "98979999697434");
		BaseUI.sendKeys(GlobalConstants.CREDITMONTH, "DECEMBER");
		BaseUI.clear(GlobalConstants.CREDITYEAR);
		BaseUI.sendKeys(GlobalConstants.CREDITYEAR, "2020");
		BaseUI.sendKeys(GlobalConstants.CREDITNAME, "BOOKER NAME");
		BaseUI.click(GlobalConstants.REMEBERME);
		BaseUI.click(GlobalConstants.PURCHASEFLIGHT);
		Assert.assertEquals(BaseUI.getText(GlobalConstants.THANKYOU), "Thank you for your purchase today!");
		Assert.assertEquals(BaseUI.getText(GlobalConstants.PURCHASE_ID).length(), 13,"Invalid ID");

	}

	@AfterMethod(description = "To capture screenshot after each method execution")
	public void screenShot(ITestResult result) {
		WebUtils.snapshotCapture(result.getMethod().getMethodName());
	}
	
	@AfterTest(enabled = true)
	public void tearDown() {
		BaseUI.close();
	}
}
