package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class ReservationDetails {
	
	
	public static By enterEventName() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='event-name']");
	}
	
	public static By selectEventType() {
		return WrapperMethods.locatorValue(Locators.ID, "event-type");
	}
	
	public static By selectReminder() {
		return WrapperMethods.locatorValue(Locators.ID, "reminder");
	}
	
	public static By verifyHostName() {
		return WrapperMethods.locatorValue(Locators.ID, "availablegroups");
	}
	
	public static By clickCreateReservation() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//button[text()='Create Reservation'])[1]");
	}	
	
}
