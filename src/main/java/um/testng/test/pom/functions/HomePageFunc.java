package um.testng.test.pom.functions;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import um.testng.test.pom.elements.HomePageElements;
import um.testng.test.pom.elements.MyAccountElements;
import um.testng.test.pom.elements.ReservationDetails;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.UMReporter;
import um.testng.test.utilities.framework.WrapperMethods;

public class HomePageFunc {

	public static void clickUsername() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickUsername(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickUsername(), "user name is clicked in Home", "user name is not clicked in Home");	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static String getUsername() throws IOException{
		String username = null;
		try {

			WrapperMethods.explicitWait(HomePageElements.clickUsername(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			username = WrapperMethods.getText(HomePageElements.clickUsername());
			if(username.contains("Acting As "))
				username = username.replace("Acting As ", "");	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		}
		return username; 
	}
	public static void clickMyAccount() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickMyAccount(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickMyAccount(), "MyAccount is clicked in Home", "MyAccount is not clicked in Home");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickSignOut() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickSignOut(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickSignOut(), "SignOut is clicked", "SignOut is not clicked");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickActAs() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickActAs(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickActAs(), "ActAs is clicked", "ActAs is not clicked");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static String clickDelegateName() throws IOException{
		String expectedDelegateName = null;
		try {

			WrapperMethods.explicitWait(HomePageElements.clickDelegateName(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			expectedDelegateName = WrapperMethods.getText(HomePageElements.clickDelegateName());
			System.out.println("Inside clickdelegate method: "+expectedDelegateName);
			WrapperMethods.click(HomePageElements.clickDelegateName(), "Delegate name is clicked", "Delegate name is not clicked");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
		return expectedDelegateName;
	}

	public static void clickActOk() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickActOk(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickActOk(), "OK button is clicked in Act As popup", "OK button is not clicked in Act As popup");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyDelegateSwitch() throws IOException{
		try {
			Thread.sleep(5000);
			//WrapperMethods.explicitWait(HomePageElements.clickUsername(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.explicitWait(HomePageElements.clickUsername(), 5000);			
			String actualusername = WrapperMethods.getText(HomePageElements.clickUsername());
			System.out.println("actualusername: "+actualusername);
			//System.out.println("expectedhostname: "+expectedDelegate);
			//WrapperMethods.compares_Text(actualDelegate, expectedDelegate, "Switch to delegate mode is successful", "Switch to delegate mode failed");
			WrapperMethods.contains_Text(actualusername, "Acting As", "Switch to delegate mode is successful", "Switch to delegate mode failed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		}
	}
	public static void clickBookNow() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickBookNow(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickBookNow(), "Book Now is clicked in Home", "Book Now is not clicked in Home");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickAbout() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickAbout(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickAbout(), "Book Now is clicked in Home", "Book Now is not clicked in Home");
			//WrapperMethods.mouseHoverAndClick(HomePageElements.clickAbout(), HomePageElements.clickAbout(), "Book Now is clicked in Home", "Book Now is not clicked in Home");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickMyEvents() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickMyEvents(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickMyEvents(), "My Events is clicked in Home", "My Events is not clicked in Home");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickHome() throws IOException{
		try {				
			WrapperMethods.explicitWait(HomePageElements.clickHome(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickHome(), "Home is clicked", "Failed to click Home");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static String getTimeZone() throws IOException{
		String timezone_home = null;
		try {			
			WrapperMethods.explicitWait(HomePageElements.bookingTimezone(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			timezone_home = WrapperMethods.getText(HomePageElements.bookingTimezone());					

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
		return timezone_home;
	}


}
