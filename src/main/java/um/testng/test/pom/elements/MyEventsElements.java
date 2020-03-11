package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class MyEventsElements {
	
	public static By clickBookings() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "bookings");
	}
	
	public static By searchReservation() {
		return WrapperMethods.locatorValue(Locators.ID, "reservation-search");
	}
	
	public static By clickSearchreservation() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='reservations-container']/div[1]/div[2]/button");
	}
	
	public static By searchBookings() {
		return WrapperMethods.locatorValue(Locators.ID, "booking-search");
	}
	
	public static By clickSearchbookings() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='bookings-container']/div[3]/div[2]/button");
	}

}
