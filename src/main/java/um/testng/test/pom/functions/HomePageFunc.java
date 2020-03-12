package um.testng.test.pom.functions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

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

	public static void clickMyEvents1() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickMyEvents(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickMyEvents(), "My Events is clicked in Home", "My Events is not clicked in Home");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickMyEvents() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickMyEvents() ,Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickMyEvents() , "My Events is clicked in Home", "My Events is not clicked in Home");
			WrapperMethods.explicitWait(HomePageElements.clickMyEvents() ,Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String color=WrapperMethods.getCssValue(HomePageElements.clickMyEvents(), "border-left-color");
			if(color.contains("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS,"Vertical Green notch is displayed");
			else
				UMReporter.log(Status.PASS,"Vertical Green notch is not  displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickHome1() throws IOException{
		try {				
			WrapperMethods.explicitWait(HomePageElements.clickHome(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickHome(), "Home is clicked", "Failed to click Home");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickHome() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickHome() , Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickHome() , "HomeMenu is clicked in Home", "HomeMenu is not clicked in Home");
			String color=WrapperMethods.getCssValue(HomePageElements.clickHome(), "border-left-color");
			if(color.equalsIgnoreCase("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS,"Vertical Green notch is displayed");
			else
				UMReporter.log(Status.PASS,"Vertical Green notch is not  displayed");
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

	public static void clickCreateReservation() throws IOException{
		try {

			WrapperMethods.explicitWait(HomePageElements.clickCreateReservation() , Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickCreateReservation() , "Create Reservation is clicked in Home", "Create Reservation is not clicked in Home");
			WrapperMethods.explicitWait(HomePageElements.clickCreateReservation() , Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String color=WrapperMethods.getCssValue(HomePageElements.clickCreateReservation(), "border-left-color");
			if(color.equalsIgnoreCase("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS,"Vertical Green notch is displayed");
			else
				UMReporter.log(Status.PASS,"Vertical Green notch is not  displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyTitles()  throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.gettextMyHome(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.gettextMyHome(),"My Home is displayed","My home is not displayed");
			String color=WrapperMethods.getCssValue(HomePageElements.gettextMyHome(), "border-bottom-color");
			if(color.contains("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS,"Vertical Green notch is displayed");
			else
				UMReporter.log(Status.PASS,"Vertical Green notch is not  displayed");
			WrapperMethods.explicitWait(HomePageElements.gettextMyTemplates(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.gettextMyTemplates(),"My Reservation Template is displayed","My Reservation Template is not displayed");
			WrapperMethods.explicitWait(HomePageElements.gettextMyBookings(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.gettextMyBookings(),"My Bookings is displayed","My Bookings is not displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyHelpicon() throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.helpIcon(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.helpIcon(),"Help Icon is displayed","Help Icon is not displayed");
			String color=WrapperMethods.getCssValue(HomePageElements.helpIcon(), "color");

			if(color.contains("rgba(33, 70, 126, 1)")|color.equalsIgnoreCase("rgb(33, 70, 126)"))
				UMReporter.log(Status.PASS,"Help icon is displayed in Blue Color");
			else
				UMReporter.log(Status.PASS,"Help icon is not displayed in Blue Color");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	//Testcase-3		
	public static void verfiyReservationTem()  throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.templateName(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.templateName(),"Template Name is displayed","Template Name is not displayed");	
			WrapperMethods.isElementAvailable(HomePageElements.clickBookNow(),"Book Now is displayed for Each Template","Book Now is not displayed for Each Template");	
			WrapperMethods.isElementAvailable(HomePageElements.clickAbout(),"About is displayed for Each Template","About is not displayed for Each Template");	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verfiyMyBookings()  throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.templateName(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.bookingDate(),"Today Date is displayed under My Bookings","Today Date is not displayed under My Bookings");	
			String color=WrapperMethods.getCssValue(HomePageElements.bookingDate(), "border-bottom-color");
			if(color.contains("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS,"Vertical Green notch is displayed");
			else
				UMReporter.log(Status.PASS,"Vertical Green notch is not  displayed");
			WrapperMethods.isElementAvailable(HomePageElements.bookingSearch(),"Search is displayed under My Bookings","Search is not displayed under My Bookings");	
			WrapperMethods.isElementAvailable(HomePageElements.bookingday(),"Day is displayed under My Bookings","Day not displayed under My Bookings");	
			String colors=WrapperMethods.getCssValue(HomePageElements.bookingday(), "background-color");
			System.out.println(colors);
			if(colors.contains("rgba(51, 122, 183, 1)")|color.equalsIgnoreCase("rgb(51, 122, 183)"))
				UMReporter.log(Status.PASS,"Day is Selected by Default");
			else
				UMReporter.log(Status.PASS,"Day is not  Selected by Default");
			WrapperMethods.isElementAvailable(HomePageElements.bookingMonth(),"Month is displayed under My Bookings","Month is not displayed under My Bookings ");
			WrapperMethods.isElementAvailable(HomePageElements.bookingDates(),"Date is displayed under My Bookings","Date is not displayed under My Bookings ");
			WrapperMethods.isElementAvailable(HomePageElements.bookingPrevious(),"Previous is displayed under My Bookings","Previous is not displayed under My Bookings ");
			WrapperMethods.isElementAvailable(HomePageElements.bookingToday(),"Today is displayed under My Bookings","Today is not displayed under My Bookings ");
			WrapperMethods.isElementAvailable(HomePageElements.bookingNext(),"Next is displayed under My Bookings","Next is not displayed under My Bookings ");
			WrapperMethods.isElementAvailable(HomePageElements.bookingTimezone(),"TimeZone is displayed under My Bookings","TimeZone is not displayed under My Bookings ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	//Testcase-4
	public static void clickHelpicon() throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.helpIcon(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.helpIcon() , "A Pop-Up Titled Help is opened", "A Pop-Up Titled Help is not opened");
			WrapperMethods.explicitWait(HomePageElements.helpIconTitle(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String actualText = WrapperMethods.getText(HomePageElements.helpIconTitle()).trim();				
			System.out.println("actualText: "+actualText);					
			if(actualText.contains("WELCOME!"))
				UMReporter.log(Status.PASS,"The Text Titled Welcome is displayed");
			else
				UMReporter.log(Status.PASS,"The Text Titled Welcome is  not displayed");
			WrapperMethods.explicitWait(HomePageElements.helpIconMessage(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));	 
			String actualMessage = WrapperMethods.getText(HomePageElements.helpIconMessage()).trim();
			String exceptedMessage="WELCOME! Be sure to log out once you?re finished. If you are experiencing difficulty using this site, please click here or select the Help icon for more information";
			System.out.println(actualMessage);
			if(actualMessage.contains(exceptedMessage))
				UMReporter.log(Status.PASS,"The Message is displayed");
			else
				UMReporter.log(Status.PASS,"The Message is not displayed");

			WrapperMethods.explicitWait(HomePageElements.helpIconOk(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.helpIconOk() , "Button name ok is displayed", "Button name ok is not displayed");
			WrapperMethods.click(HomePageElements.helpIconOk() , "Pop-up is closed", "Pop-Up is not closed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		}
	}
	//Testcase-5		
	public static void verifyBookNow() throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.clickBookNow(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickBookNow() , "Book Now is clicked", "Book Now is not clicked");
			String Title= WrapperMethods.getText(HomePageElements.RoomRequestpage());
			if(Title.contains("Room Request"))
				UMReporter.log(Status.PASS,"Room Request page is displayed");
			else
				UMReporter.log(Status.PASS,"Room Request page is not displayed");
			WrapperMethods.explicitWait(HomePageElements.clickWarnerMedia(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickWarnerMedia() , "Home Page is displayed", "Home Page is not displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void verifyAbout() throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.clickAbout(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickAbout() , "About is Clicked", "About is not Clicked");
			WrapperMethods.explicitWait(HomePageElements.AboutTemplateHeading(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String Title=WrapperMethods.getText(HomePageElements.AboutTemplateHeading());
			System.out.println(Title);
			if(Title.contains("About The "))
				UMReporter.log(Status.PASS,"About <> Template is displayed");
			else
				UMReporter.log(Status.PASS,"About <> Template is not displayed");
			WrapperMethods.explicitWait(HomePageElements.aboutTemplateBookingrule(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String color=WrapperMethods.getCssValue(HomePageElements.aboutTemplateBookingrule(), "border-bottom-color");
			if(color.contains("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS," Booking rule is highlighted with green color notch");
			else
				UMReporter.log(Status.PASS," Booking rule is not highlighted with green color notch");
			WrapperMethods.click(HomePageElements.aboutTemplateClose() , "Room Booking Tool page is displayed", "Room Booking Tool page is not displayed");
			WrapperMethods.explicitWait(HomePageElements.clickAbout(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.clickAbout() , "About is Clicked", "About is not Clicked");
			WrapperMethods.explicitWait(HomePageElements.aboutTemplateBooknow(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.aboutTemplateBooknow() , "Room Request page is displayed", "Room Request page is not displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	//Testcase-6		
	public static void validateDay()throws IOException{
		try {
			WrapperMethods.page_scrollDown();
			UMReporter.log(Status.PASS,"Page is Scrollable");
			WrapperMethods.explicitWait(HomePageElements.bookingday(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String color=WrapperMethods.getCssValue(HomePageElements.bookingday(), "background-color");
			if(color.equalsIgnoreCase("rgba(51, 122, 183, 1)") |color.equalsIgnoreCase("rgb(51, 122, 183)"))
				UMReporter.log(Status.PASS,"Day is selected by default and displayed in blue color");
			else
				UMReporter.log(Status.PASS,"Day is not selected by default");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void validateMonth()throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.bookingMonth(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingMonth() , "Month is Clicked", "Month is not Clicked");
			String color=WrapperMethods.getCssValue(HomePageElements.bookingMonth(), "background-color");
			if(color.equalsIgnoreCase("rgba(51, 122, 183, 1)") |color.equalsIgnoreCase("rgb(51, 122, 183)"))
				UMReporter.log(Status.PASS,"Month is highlighted in blue color");
			else
				UMReporter.log(Status.PASS,"Month is not highlighted in blue color");
			WrapperMethods.isElementAvailable(HomePageElements.monthCal() , "Current month details is displayed ", "Current month details is not displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}	
	public static void validateDate() throws IOException{
		try {
			WrapperMethods.explicitWait(HomePageElements.bookingDates(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingDates() , "Date is Clicked", "Date is not Clicked");
			WrapperMethods.isElementAvailable(HomePageElements.datecal() , "Pop up is opened with current month calender ", "Pop up is not opened with current month calender");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}	
	//Testcase-7
	public static void validateSearchName() throws IOException{
		try {
			WrapperMethods.page_scrollDown();
			WrapperMethods.explicitWait(HomePageElements.bookingSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingSearch() , "Search is Clicked", "Search is not Clicked");
			String color=WrapperMethods.getCssValue(HomePageElements.bookingSearch(), "border-bottom-color");
			if(color.contains("rgba(151, 202, 61, 1)")|color.equalsIgnoreCase("rgb(151, 202, 61)"))
				UMReporter.log(Status.PASS," Search is highlighted with green color notch");
			else
				UMReporter.log(Status.PASS," Search is not highlighted with green color notch");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}	
	public static void validateSearchNameResult(String Searchtext)throws IOException{
		try {			
			WrapperMethods.explicitWait(HomePageElements.searchTextBox(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(HomePageElements.searchTextBox(), Searchtext, "Event name is Typed", "Event name is not Typed");
			WrapperMethods.explicitWait(HomePageElements.bookingClickSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingClickSearch(), "Search button is Clicked", "Search button is not Clicked");
			String Text=WrapperMethods.getText(HomePageElements.bookingsearchnoresult());
			if(Text.contains("Nothing was found for ")) {
				UMReporter.log(Status.PASS,"Nothing was Found for search");
			}
			else {
				WrapperMethods.explicitWait(HomePageElements.bookingsearchresult(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.bookingsearchresult(), "List of events is displayed based on the search event name ", "List of events is not displayed based on the search event name ");
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchTitle(), "Text titled Title is displayed ", "Text titled Title is not displayed ");			 
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchLocation(), "Text titled Location is displayed ", "Text titled Location is not displayed ");	
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchDateTime(), "Text titled Date&Time is displayed ", "Text titled Date&Time is not displayed ");	
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancel(), "Cancel button is displayed ", "Cancel Button is not displayed ");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}	
	//Testcase-8		
	public static void validateSearchLocationResult(String Searchtext)throws IOException{
		try {			
			WrapperMethods.explicitWait(HomePageElements.searchTextBox(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(HomePageElements.searchTextBox(), Searchtext, "Location Name is Typed", "Location name is not Typed");
			WrapperMethods.explicitWait(HomePageElements.bookingClickSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingClickSearch(), "Search button is Clicked", "Search button is not Clicked");
			String Text=WrapperMethods.getText(HomePageElements.bookingsearchnoresult());
			if(Text.contains("Nothing was found for ")) {
				UMReporter.log(Status.PASS,"Nothing was Found for search");
			}
			else {
				WrapperMethods.explicitWait(HomePageElements.bookingsearchresult(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.bookingsearchresult(), "List of events is displayed based on the search event name ", "List of events is not displayed based on the search event name ");
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchTitle(), "Text titled Title is displayed ", "Text titled Title is not displayed ");			 
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchLocation(), "Text titled Location is displayed ", "Text titled Location is not displayed ");	
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchDateTime(), "Text titled Date&Time is displayed ", "Text titled Date&Time is not displayed ");	
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancel(), "Cancel button is displayed ", "Cancel Button is not displayed ");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}	

	//Testcase-9
	public static void verifySearchcancel(String Searchtext)throws IOException{
		try {	
			WrapperMethods.page_scrollDown();
			WrapperMethods.explicitWait(HomePageElements.bookingSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingSearch() , "Search is Clicked", "Search is not Clicked");
			WrapperMethods.explicitWait(HomePageElements.searchTextBox(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(HomePageElements.searchTextBox(), Searchtext, "Event name is Typed", "Event name is not Typed");
			WrapperMethods.explicitWait(HomePageElements.bookingClickSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingClickSearch(), "Search button is Clicked", "Search button is not Clicked");
			WrapperMethods.implicitWait();
			String Text=WrapperMethods.getText(HomePageElements.bookingsearchnoresult());
			if(Text.contains("Nothing was found for ")) {
				UMReporter.log(Status.PASS,"Nothing was Found for search");
			}
			else {
				WrapperMethods.explicitWait(HomePageElements.bookingsearchresult(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancel(), "Cancel button is displayed ", "Cancel Button is not displayed ");
				WrapperMethods.explicitWait(HomePageElements.bookingSearchCancel(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(HomePageElements.bookingSearchCancel(),"Cancel button is clicked", "Cancel button is not clicked");
				WrapperMethods.explicitWait(HomePageElements.bookingSearchCancelHeading(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancelHeading(), "A pop-up is opened with Title Cancel Booking? is displayed ", "A pop-up is opened with Title Cancel Booking? is not  displayed ");
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancelTimezone(), "Date,Month,Time,Event name and Event Location is displayed", "Date,Month,Time,Event name and Event Location is not  displayed ");
				WrapperMethods.explicitWait(HomePageElements.bookingSearchCancelNoBooking(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(HomePageElements.bookingSearchCancelNoBooking(),"Pop-up is closed", "Pop-up is not closed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	//TestCase-10
	public static void verifySearchcancelEvent(String Searchtext)throws IOException{
		try {	
			WrapperMethods.page_scrollDown();
			WrapperMethods.explicitWait(HomePageElements.bookingSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingSearch() , "Search is Clicked", "Search is not Clicked");
			WrapperMethods.explicitWait(HomePageElements.searchTextBox(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(HomePageElements.searchTextBox(), Searchtext, "Event name is Typed", "Event name is not Typed");
			WrapperMethods.explicitWait(HomePageElements.bookingClickSearch(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingClickSearch(), "Search button is Clicked", "Search button is not Clicked");
			WrapperMethods.implicitWait();
			String Text=WrapperMethods.getText(HomePageElements.bookingsearchnoresult());
			if(Text.contains("Nothing was found for ")) {
				UMReporter.log(Status.PASS,"Nothing was Found for search");
			}
			else {
				WrapperMethods.explicitWait(HomePageElements.bookingsearchresult(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancel(), "Cancel button is displayed ", "Cancel Button is not displayed ");
				WrapperMethods.explicitWait(HomePageElements.bookingSearchCancel(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(HomePageElements.bookingSearchCancel(),"Cancel button is clicked", "Cancel button is not clicked");
				WrapperMethods.explicitWait(HomePageElements.bookingSearchCancelHeading(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.bookingSearchCancelHeading(), "A pop-up is opened with Title Cancel Booking? is displayed ", "A pop-up is opened with Title Cancel Booking? is not  displayed ");
				WrapperMethods.implicitWait();
				WrapperMethods.click(HomePageElements.bookingSearchCancelYesBooking(),"Yes cancel booking is clicked", "Yes cancel booking is not clicked");
				WrapperMethods.implicitWait();
				String Message=WrapperMethods.getText(HomePageElements.bookingSearchCanceMessage());
				if(Message.contains( "booking was cancelled")) {
					UMReporter.log(Status.PASS,"Booking was cancelled");}
				else {
					UMReporter.log(Status.PASS,"Booking was not cancelled");
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	//Testcase-11
	public static void Bookingday() throws IOException{
		try {
			WrapperMethods.page_scrollDown();
			WrapperMethods.explicitWait(HomePageElements.bookingCurrentDate(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String Date=WrapperMethods.getText(HomePageElements.bookingCurrentDate());
			UMReporter.log(Status.PASS,"Current date is displayed:"+Date);
			String Message=WrapperMethods.getText(HomePageElements.bookingSearchCanceMessage());
			if(Message.contains("There are no bookings for ")) {
				UMReporter.log(Status.PASS,"There are no Events");}
			else {
				WrapperMethods.isElementAvailable(HomePageElements.bookingDate(), "List of Events are displayed", "List of Event not not displayed");
			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	//Testcase-12

	public static void bookingMonth()throws IOException{
		try {
			WrapperMethods.page_scrollDown();
			WrapperMethods.explicitWait(HomePageElements.bookingMonth(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingMonth(), "Month is clicked","Month is not clicked");
			WrapperMethods.isElementAvailable(HomePageElements.monthCal() , "Current month details is displayed ", "Current month details is not displayed");
			WrapperMethods.implicitWait();
			List<WebElement> month=WrapperMethods.findElements(HomePageElements.monthCal());
			month.get(1).click();
			UMReporter.log(Status.PASS,"Particular day is clicked");
			WrapperMethods.explicitWait(HomePageElements.clickMonthMessage(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String Message= WrapperMethods.getText(HomePageElements.clickMonthMessage());
			if(Message.contains("There are no bookings for" )) {
				UMReporter.log(Status.PASS,"There are no Events");} 
			else
			{
				WrapperMethods.explicitWait(HomePageElements.Event(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.Event(),"Event are displayed","Events are not displayed"); 
			}
			WrapperMethods.explicitWait(HomePageElements.bookingMonth(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingMonth(), "Month is clicked","Month is not clicked");
			WrapperMethods.explicitWait(HomePageElements.bookingPrevious(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingPrevious(), "Previous is clicked","Previous is not clicked");
			WrapperMethods.isElementAvailable(HomePageElements.monthCal() , "Calender is displayed ", "Calender is not displayed");
			WrapperMethods.explicitWait(HomePageElements.bookingNext(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingNext(), "Next is clicked","Next is not clicked");
			WrapperMethods.isElementAvailable(HomePageElements.monthCal() , "Calender is displayed ", "Calender is not displayed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	//Testcase-13
	public static void bookingDate()throws IOException{
		try {
			WrapperMethods.page_scrollDown();
			WrapperMethods.explicitWait(HomePageElements.bookingDates(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.bookingDates(), "Date is clicked","Date is not clicked");
			WrapperMethods.explicitWait(HomePageElements.datecal(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementAvailable(HomePageElements.datecal(), "Pop-up opened with current calendar", "Pop-up is not opened with current calendar");
			WrapperMethods.explicitWait(HomePageElements.dateCalPrevious(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.dateCalPrevious(), "Previous month calendar is displayed", "Previous month calendar is not displayed");
			WrapperMethods.explicitWait(HomePageElements.dateCalNext(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(HomePageElements.dateCalNext(), "Next month calendar is displayed", "Next month calendar is not displayed");
			WrapperMethods.implicitWait();
			List<WebElement> Date=WrapperMethods.findElements(HomePageElements.datePicker());
			Date.get(1).click();
			UMReporter.log(Status.PASS,"Particular day is clicked");
			WrapperMethods.explicitWait(HomePageElements.clickMonthMessage(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			String Message= WrapperMethods.getText(HomePageElements.clickMonthMessage());
			if(Message.contains("There are no bookings for" )) {
				UMReporter.log(Status.PASS,"There are no Events");} 
			else
			{
				WrapperMethods.explicitWait(HomePageElements.Event(),Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.isElementAvailable(HomePageElements.Event(),"Event are displayed","Events are not displayed"); 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}


}
