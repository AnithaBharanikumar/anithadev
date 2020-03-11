package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class RoomRequestPageElements {
	
	public static By gettextRoomsAndAttendees() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='main-tabs']/li[1]/a");
	}
	
	public static By enterStartDate() {
		return WrapperMethods.locatorValue(Locators.ID, "booking-date-input");
	}
	
	public static By enterStartTime() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='booking-start']/input");
	}
	
	public static By enterEndTime() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='booking-end']/input");
	}
	
	public static By clickSearch() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='location-filter-container']/div[2]/button");
	}
	
	public static By addRoom() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='available-list']/tbody/tr[2]/td[1]/a/i");
	}
	
	public static By searchAttendee() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='attendeeLookup']");
	}
	
	public static By addAttendee() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//span[@class='col-md-3 col-xs-5'])[1]");
	}
	public static By clickNextStep() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//button[text()='Next Step'])[1]");
	}
	
	public static By clickReservationDetails() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='main-tabs']/li[3]/a");
	}

}
