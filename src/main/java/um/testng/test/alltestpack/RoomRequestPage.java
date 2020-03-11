package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import um.testng.test.alltests.SingleBooking;
import um.testng.test.alltests.SingleBookingAsDelegate;
import um.testng.test.utilities.framework.UMReporter;

public class RoomRequestPage extends BaseTest{
	
	@Test(groups = "RoomRequest", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void singleBooking(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Room Request Page test");
			SingleBooking.singleBooking();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups = "RoomRequest", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void singleBookingAsDelegate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Room Request Page test");
			SingleBookingAsDelegate.singleBookingAsDelegate();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

}
