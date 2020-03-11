package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class HomePageElements {


	public static By clickUsername() {
		return WrapperMethods.locatorValue(Locators.ID, "user-name");
	}

	public static By clickMyAccount() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "My Account");
	}

	public static By clickActAs() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Act As");
	}	

	public static By clickDelegateName() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='row row-selectable']//div[1]");
	}

	public static By clickActOk() {
		return WrapperMethods.locatorValue(Locators.ID, "actas-ok-btn");
	}


	public static By clickSignOut() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@href='LogOut.aspx']");
	}

	public static By clickHome() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@title='Home']");
	}

	public static By clickCreateReservation() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//span[text()='Create A Reservation']");
	}

	public static By clickMyEvents() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//span[text()='My Events']");
	}

	public static By gettextMyHome() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//span[text()='My Home']");
	}

	public static By gettextMyTemplates() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='my-reservation-templates']/h2']");
	}

	public static By gettextMyBookings() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='my-reservations']/h2']");
	}

	public static By gettextCurrentDate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='my-bookings-title']");
	}

	public static By clickSearch() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Search");
	}

	public static By clickDay() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Day");
	}

	public static By clickMonth() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Month");
	}

	public static By clickDate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[text()[normalize-space()='Date']]");
	}

	public static By clickPrevious() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Previous");
	}

	public static By clickToday() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Today");
	}

	public static By clickNext() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Next");
	}

	public static By clickAbout() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='templates-grid']/div/div[1]/div[2]/button[2]");
	}

	public static By clickBookNow() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='templates-grid']/div/div[1]/div[2]/button[1]");
	}

	public static By bookingTimezone(){
		return WrapperMethods.locatorValue(Locators.CLASS_NAME,"time-zone-heading");
	}


}
