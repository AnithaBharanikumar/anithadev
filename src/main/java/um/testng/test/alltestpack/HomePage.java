package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import um.testng.test.alltests.ActAsDelegate;
import um.testng.test.alltests.HomeBookNowandAbout;
import um.testng.test.alltests.HomeDayMonthDate;
import um.testng.test.alltests.HomeHelpIcon;
import um.testng.test.alltests.HomeMenu;
import um.testng.test.alltests.HomePageDate;
import um.testng.test.alltests.HomePageDay;
import um.testng.test.alltests.HomePageMonth;
import um.testng.test.alltests.HomeReseravtionandBookings;
import um.testng.test.alltests.HomeSearchCancel;
import um.testng.test.alltests.HomeSearchLocation;
import um.testng.test.alltests.HomeSearchName;
import um.testng.test.alltests.HomeVerification;
import um.testng.test.alltests.HomepageSearchCancelEvent;
import um.testng.test.utilities.framework.UMReporter;

public class HomePage extends BaseTest{
	
	@Test(groups = "Home", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void switchToDelegateMode(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Home Page test");			
			ActAsDelegate.actAsDelegate();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void homeMenu(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Home menu Page test");
			HomeMenu.homeMenu();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void homeVerification(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Home Verification Page test");
			HomeVerification.homeVerification();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void homeReservation(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("My Reservation Template and My bookings Page test");
			HomeReseravtionandBookings.homeReservation();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyHelpicon(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Click Help Icon");
			HomeHelpIcon.verifyHelpicon();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyBooknowandAbout(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Verify Book Now and About");
			HomeBookNowandAbout.verifyBooknowandAbout();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyDayMonthDate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Verify Day,Month and Date");
			HomeDayMonthDate.verifyDayMonthDate();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifySearchName(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Search Name");
			HomeSearchName.verifySearchName();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifySearchLocation(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Search Location");
			HomeSearchLocation.verifySearchLocation();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifySearchCancel(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Search Cancel");
			HomeSearchCancel.verifySearchCancel();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void verifySearchCancelEvent(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Search Cancel Event");
			HomepageSearchCancelEvent.verifySearchCancelEvent();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void homepageDay(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Current Date");
			HomePageDay.homepageDate();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void homepageMonth(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Month Test");
			HomePageMonth.homepageMonth();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(groups ="Home", dataProvider ="GlobalTestData",priority=0,invocationCount = 1)		
	public void homepageDate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Date Test");
			HomePageDate.homepageDate();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}


}
