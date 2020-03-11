package um.testng.test.pom.functions;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import um.testng.test.pom.elements.ReservationDetails;
import um.testng.test.pom.elements.RoomRequestPageElements;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.UMReporter;
import um.testng.test.utilities.framework.WrapperMethods;

public class RoomRequestFunc {
	
	public static void enterStartDate(String startDate) throws IOException{
		try {				
				WrapperMethods.explicitWait(RoomRequestPageElements.enterStartDate(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.clear(RoomRequestPageElements.enterStartDate());				
				WrapperMethods.sendkeys(RoomRequestPageElements.enterStartDate(), startDate, "Start date is entered", "Start date is not entered");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	
	public static void enterStartTime(String startTime) throws IOException{
		try {			
				WrapperMethods.explicitWait(RoomRequestPageElements.enterStartTime(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.clear(RoomRequestPageElements.enterStartTime());				
				WrapperMethods.sendkeys(RoomRequestPageElements.enterStartTime(), startTime, "Start time is entered", "Start time is not entered");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	
	public static void enterEndTime(String endTime) throws IOException{
		try {				
				WrapperMethods.explicitWait(RoomRequestPageElements.enterEndTime(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.clear(RoomRequestPageElements.enterEndTime());
				WrapperMethods.sendkeys(RoomRequestPageElements.enterEndTime(), endTime, "End time is entered", "End time is not entered");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	
	public static void clickSearch() throws IOException{
		try {
			WrapperMethods.explicitWait(RoomRequestPageElements.clickSearch(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(RoomRequestPageElements.clickSearch(), "Search button is clicked", "Search button is not clicked");	
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
		
		public static void addRoom() throws IOException{
			try {
				WrapperMethods.explicitWait(RoomRequestPageElements.addRoom(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(RoomRequestPageElements.addRoom(), "Room is selected", "Room is not selected");	
				Thread.sleep(15000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			}
	}
		
		public static void searchAttendee(String attendeeName) throws IOException{
			try {				
				WrapperMethods.explicitWait(RoomRequestPageElements.searchAttendee(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(RoomRequestPageElements.searchAttendee(), "Search Attendee is clicked", "Search Attendee is not clicked");
				WrapperMethods.sendkeys(RoomRequestPageElements.searchAttendee(), attendeeName, "Attendee name is entered", "Attendee name is not entered");
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			}
	}
		
		public static void selectAttendee() throws IOException{
			try {
				WrapperMethods.explicitWait(RoomRequestPageElements.addAttendee(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(RoomRequestPageElements.addAttendee(), "Search Attendee is selected", "Search Attendee is not selected");					
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			}
	}
		
		public static void clickNextStep() throws IOException{
			try {				
				WrapperMethods.explicitWait(RoomRequestPageElements.clickNextStep(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.scrollToTopOfThePage();				
				WrapperMethods.click(RoomRequestPageElements.clickNextStep(), "NextStep is clicked", "NextStep is clicked");	
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			}
	}

		public static void enterEventName(String eventName) throws IOException{
			try {					
					WrapperMethods.explicitWait(ReservationDetails.enterEventName(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
					WrapperMethods.clear(ReservationDetails.enterEventName());
					WrapperMethods.sendkeys(ReservationDetails.enterEventName(), eventName, "Event Name is entered", "Event Name is not entered");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			} 
		}
		
		public static void selectEventType(String eventtype) throws IOException{
			try {					
					WrapperMethods.explicitWait(ReservationDetails.selectEventType(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
					WrapperMethods.dropdownSelect(ReservationDetails.selectEventType(), "visibletext", eventtype, "Event Type is selected", "Event Type is not selected");					
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			} 
		}
		
		public static void selectReminder(String reminder) throws IOException{
			try {					
					WrapperMethods.explicitWait(ReservationDetails.selectReminder(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
					WrapperMethods.dropdownSelect(ReservationDetails.selectReminder(), "visibletext", reminder, "Reminder is selected", "Reminder is not selected");					
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			} 
		}
		
		public static void verifyHostName() throws IOException{
			try {
				String actualhostname = WrapperMethods.getSelectedValueInDropdown(ReservationDetails.verifyHostName(), 30);	
				String expectedhostname = HomePageFunc.getUsername();
				System.out.println("actualhostname: "+actualhostname);
				System.out.println("expectedhostname: "+expectedhostname);
				WrapperMethods.compares_Text(actualhostname, expectedhostname, "HostName and username is matching", "HostName and username is not matching");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			}
	}
		
		public static void clickCreateReservation() throws IOException{
			try {
				WrapperMethods.explicitWait(ReservationDetails.clickCreateReservation(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(ReservationDetails.clickCreateReservation(), "Create Reservation is clicked", "Create Reservation is clicked");	
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				UMReporter.log(Status.FAIL, e.getMessage());
			}
	}

}
