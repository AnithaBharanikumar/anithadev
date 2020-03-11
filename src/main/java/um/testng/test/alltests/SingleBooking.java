package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.RoomRequestFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;
import um.testng.test.utilities.framework.TestDataProvider;
/**
 * 
 * c-xpanxion-aranaswam
 * Feb 21, 2020
 * Creates a single occurence meeting 
 */
public class SingleBooking {
	
	public static void singleBooking() throws IOException {
		try
		{
			SignInPageFunc login = new SignInPageFunc();			
			login.verifySignIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickBookNow();			
			RoomRequestFunc.enterStartDate(TestDataProvider.getData("startDate"));
			RoomRequestFunc.enterStartTime(TestDataProvider.getData("startTime"));
			RoomRequestFunc.enterEndTime(TestDataProvider.getData("endTime"));
			RoomRequestFunc.clickSearch();	
			RoomRequestFunc.addRoom();
			RoomRequestFunc.searchAttendee(TestDataProvider.getData("attendeeName"));
			RoomRequestFunc.selectAttendee();
			RoomRequestFunc.clickNextStep();
			RoomRequestFunc.enterEventName(TestDataProvider.getData("eventName"));
			RoomRequestFunc.verifyHostName();
			RoomRequestFunc.clickCreateReservation();
			HomePageFunc.clickUsername();
			HomePageFunc.clickSignOut();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

}

}