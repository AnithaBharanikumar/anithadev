package um.testng.test.pom.functions;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import um.testng.test.pom.elements.HomePageElements;
import um.testng.test.pom.elements.MyAccountElements;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.UMReporter;
import um.testng.test.utilities.framework.WrapperMethods;

public class MyAccountFunc {

	public static void clickDelegates() throws IOException{
		try {

			WrapperMethods.explicitWait(MyAccountElements.clickDelegates(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(MyAccountElements.clickDelegates(), "Delegates link is clicked", "Delegates link is not clicked");				

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	
	public static void verifyDelegateGreenNotch() throws IOException{
		try {

			WrapperMethods.explicitWait(MyAccountElements.clickDelegates(), 50);			
			String color = WrapperMethods.getCssValue(MyAccountElements.clickDelegates(), "border-bottom-color");
			if(color.contains("rgba(151, 202, 61, 1)")||color.contains("rgb(151, 202, 61)"))	
				UMReporter.log(Status.PASS, "Green color notch is present below Delegates");
			else
				UMReporter.log(Status.FAIL, "Green color notch is not present below Delegates");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void isAddDelegateAvailable() throws IOException{
		try {

			WrapperMethods.explicitWait(MyAccountElements.searchDelegate(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementPresent(MyAccountElements.searchDelegate(), "Search delegates is available in delegates section", "Search delegates is not available in delegates section");
			WrapperMethods.isElementPresent(MyAccountElements.textAddNewDelegate(), "Add delegate is available in delegates section", "Add delegate is not available in delegates section");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	
	public static void isYourSavedDelegatesAvailable() throws IOException{
		try {

			WrapperMethods.explicitWait(MyAccountElements.textYourSavedDelegates(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.isElementPresent(MyAccountElements.textYourSavedDelegates(), "Text your saved delegates is available in delegates section", "Text your saved delegates is not available in delegates section");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void enterDelegate(String delegateName) throws IOException{
		try {

			WrapperMethods.explicitWait(MyAccountElements.searchDelegate(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));				
			WrapperMethods.click(MyAccountElements.searchDelegate());
			WrapperMethods.sendkeys(MyAccountElements.searchDelegate(), delegateName, "delegate name is entered", "delegate name is not entered");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void getduplicateDelagateMessage() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.searchDelegateText(), 30);				
			String actualmessage = WrapperMethods.getText(MyAccountElements.searchDelegateText());	
			String exptectedmessage = "There are no names that match your search criteria.";				
			WrapperMethods.compares_Text(exptectedmessage, actualmessage, "Not able to add duplicate delegate name", "Able to add duplicate delegate name");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void selectDelagateName() throws IOException{
		try {			
			WrapperMethods.explicitWait(MyAccountElements.searchDelegateText(), 50);
			String searchtext = WrapperMethods.getText(MyAccountElements.searchDelegateText());
			System.out.println("searchtext:"+searchtext);
			if(searchtext!=null && (searchtext.contentEquals("There are no names that match your search criteria."))) 
			{ 					
				System.out.println("Delegate existing already");
			}
			else{					
				WrapperMethods.explicitWait(MyAccountElements.selectDelegate(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.click(MyAccountElements.selectDelegate(), "Delegate is selected", "Delegate is not selected");
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void getSavedDelagate(String delegateName) throws IOException{
		try {				
			WrapperMethods.explicitWait(MyAccountElements.getSavedDelegate(), 50);
			String saveddelgatename = WrapperMethods.getText(MyAccountElements.getSavedDelegate());		
			if(saveddelgatename.contains(delegateName)) 
			{ 					
				System.out.println("Delegate added successfully to saved delegate list");
				UMReporter.log(Status.PASS, "Delegate added successfully to saved delegate list");
			}
			else{					
				System.out.println("Delegate not added to delegate list");
				UMReporter.log(Status.FAIL, "Delegate not added to delegate list");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void deleteDelagate() throws IOException{
		try {				

			int total_size = WrapperMethods.getElementsSize(MyAccountElements.getAllDelegates(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			System.out.println("total_size prior deletion: "+total_size);			
			while(total_size>0) {				
				WrapperMethods.explicitWait(MyAccountElements.deleteDelegate(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.javascriptclick(MyAccountElements.deleteDelegate(), "Delegate is deleted", "Delegate is not deleted");					
				WrapperMethods.pageRefresh();
				WrapperMethods.explicitWait(MyAccountElements.clickDelegates(), 30);
				WrapperMethods.click(MyAccountElements.clickDelegates(), "Clicked delegates link", "Failed to click delegates link");

				total_size--;	
			}

			if(total_size==0)
				UMReporter.log(Status.PASS, "No delegates existing to delete");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void noDelagateText() throws IOException{
		try {				

			int total_size = WrapperMethods.getElementsSize(MyAccountElements.getAllDelegates(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			System.out.println("total_size prior deletion: "+total_size);			
			while(total_size>0) {				
				WrapperMethods.explicitWait(MyAccountElements.deleteDelegate(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
				WrapperMethods.javascriptclick(MyAccountElements.deleteDelegate(), "Delegate is deleted", "Delegate is not deleted");					
				WrapperMethods.pageRefresh();
				WrapperMethods.explicitWait(MyAccountElements.clickDelegates(), 30);
				WrapperMethods.click(MyAccountElements.clickDelegates(), "Clicked delegates link", "Failed to click delegates link");

				total_size--;	
			}

			WrapperMethods.explicitWait((MyAccountElements.noDelegateText()), 30);	
			String actualText = WrapperMethods.getText(MyAccountElements.noDelegateText()).trim();				
			System.out.println("actualText: "+actualText);					
			WrapperMethods.compares_Text("You don't have any saved Delegates. Search above to add one.", actualText, "Message You don't have any saved Delegates. Search above to add one. is displayed when there are no delegates" , "Message You don't have any saved Delegates. Search above to add one. is not displayed when there are no delegates");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void getinvalidDelagateMessage() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.searchDelegateText(), 30);				
			String actualmessage = WrapperMethods.getText(MyAccountElements.searchDelegateText());	
			String exptectedmessage = "There are no names that match your search criteria.";				
			WrapperMethods.compares_Text(exptectedmessage, actualmessage, "Not able to add invalid/non-existing delegate name", "Able to add invalid/non-existing duplicate delegate name");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyMyAccountDetailsEnabled() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.clickAccountDetails(), 30);
			if(WrapperMethods.isElementPresent(MyAccountElements.clickAccountDetails(), 30)) {
				UMReporter.log(Status.PASS, "My Account Details is selected by default");			
			}
			else
				UMReporter.log(Status.FAIL, "My Account Details is not selected by default");		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyGreenNotch() throws IOException{
		try {

			WrapperMethods.explicitWait(MyAccountElements.clickAccountDetails(), 50);			
			String color = WrapperMethods.getCssValue(MyAccountElements.clickAccountDetails(), "border-bottom-color");
			if(color.contains("rgba(151, 202, 61, 1)")||color.contains("rgb(151, 202, 61)"))	
				UMReporter.log(Status.PASS, "Green color notch is present below Account details");
			else
				UMReporter.log(Status.FAIL, "Green color notch is not present below Account details");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void verifyMyAccountSubmenus() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.myAccountSubmenus(), 30);	
			List<String> expectedSubmenus = Arrays.asList("ACCOUNT DETAILS", "DELEGATES", "PERSONALIZATION", "MY FAVORITE ROOMS");
			List<WebElement> myaccountlinksall = WrapperMethods.findElements(MyAccountElements.myAccountSubmenus());
			List<String> acutalSubmenus = new ArrayList<String>();

			for(WebElement eachelement:myaccountlinksall) {
				acutalSubmenus.add(eachelement.getText());}	
			System.out.println(acutalSubmenus);

			if(acutalSubmenus.containsAll(expectedSubmenus)) 
				UMReporter.log(Status.PASS, "Expected and acutal submenus are matching in Account Section");
			else
				UMReporter.log(Status.FAIL, "Expected and acutal submenus are not matching in Account Section");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyAccountDetails() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.clickAccountDetails(), 30);
			WrapperMethods.isElementAvailable(MyAccountElements.getLabelTimeZone(), "Time zone is available", "Time zone is not available");	
			WrapperMethods.isElementAvailable(MyAccountElements.getLabelEmail(), "Email is available", "Email is not available");
			WrapperMethods.isElementAvailable(MyAccountElements.getLabelName(), "Username is available", "Username is not available");
			WrapperMethods.isElementAvailable(MyAccountElements.getLabelPhone1(), "Phone1 is available", "Phone1 is not available");
			WrapperMethods.isElementAvailable(MyAccountElements.getLabelPhone2(), "Phone2 is available", "Phone2 is not available");
			WrapperMethods.isElementAvailable(MyAccountElements.clickAccountDetailsSaveChanges(), "Save Changes button is available", "Save Changes button is not available");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void validateEmail() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getEmail(), 30);
			String email = WrapperMethods.getAttribute(MyAccountElements.getEmail(), "value");		
			WrapperMethods.explicitWait(HomePageElements.clickUsername(), 30);
			String username = WrapperMethods.getText(HomePageElements.clickUsername());	

			String[] fname = username.split(", ");
			String expectedemail = fname[1]+"."+fname[0];	
			if(email.contains(expectedemail))
				UMReporter.log(Status.PASS, "EmailID and username are matching");
			else
				UMReporter.log(Status.PASS, "Mismatch in emailID and username");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void validateName() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getName(), 30);
			String actualname = WrapperMethods.getAttribute(MyAccountElements.getName(), "value");				
			WrapperMethods.explicitWait(HomePageElements.clickUsername(), 30);
			String expectedname = WrapperMethods.getText(HomePageElements.clickUsername());				
			WrapperMethods.verify_Two_Given_Text(actualname, expectedname, "Username and login name are matching", "Mismatch in username and login name");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void selectTimeZone(String timezone) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getTimeZone(), 30);
			WrapperMethods.dropdownSelect(MyAccountElements.getTimeZone(), "visibletext", timezone, "Time zone selection is successful", "Failed to select a value for timezone");		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyTimeZone(String timezone) throws IOException{		
		try {			
			WrapperMethods.pageRefresh();			
			String actualvalue = getTimeZone();			
			WrapperMethods.verify_Two_Given_Text(actualvalue, timezone, "Time zone updated successfully", "Failed to update time zone");

			WrapperMethods.click(HomePageElements.clickHome());	
			WrapperMethods.pageRefresh();
			WrapperMethods.explicitWait(HomePageElements.bookingTimezone(), 30);
			String hometimezone = HomePageFunc.getTimeZone();			
			WrapperMethods.verify_Two_Given_Text(actualvalue, hometimezone, "Time zone updated in account details is matching with home page time zone", "Time zone updated in account details is not matching with home page time zone");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 

	}

	public static String getTimeZone() throws IOException{
		String timezone = null;
		try {
			WrapperMethods.explicitWait(MyAccountElements.getTimeZone(), 30);			
			timezone = WrapperMethods.getSelectedValueInDropdown(MyAccountElements.getTimeZone(), 30);						

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
		return timezone;
	}
	public static void enterEmail(String email) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getEmail(), 30);	
			WrapperMethods.click(MyAccountElements.getEmail());
			WrapperMethods.clear(MyAccountElements.getEmail());
			WrapperMethods.sendkeys(MyAccountElements.getEmail(), email, "Email is entered successfully", "Failed to update email id");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyEmail(String email) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getEmail(), 30);					
			String actualvalue = WrapperMethods.getAttribute(MyAccountElements.getEmail(), "value");
			WrapperMethods.verify_Two_Given_Text(actualvalue, email, "Email updation is successful", "Failed to update email");	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void enterName(String name) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getName(), 30);
			WrapperMethods.click(MyAccountElements.getName());
			WrapperMethods.clear(MyAccountElements.getName());
			WrapperMethods.sendkeys(MyAccountElements.getName(), name, "Name is entered successfully", "Failed to update name");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyName(String name) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getName(), 30);					
			String actualvalue = WrapperMethods.getAttribute(MyAccountElements.getName(), "value");
			WrapperMethods.verify_Two_Given_Text(actualvalue, name, "Name updation is successful", "Failed to update name");	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void enterPhone1(String phone1) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getPhone1(), 30);	
			WrapperMethods.click(MyAccountElements.getPhone1());
			WrapperMethods.clear(MyAccountElements.getPhone1());
			WrapperMethods.sendkeys(MyAccountElements.getPhone1(), phone1, "Phone1 is entered successfully", "Failed to enter Phone1");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyPhone1(String phone1) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getPhone1(), 30);					
			String actualvalue = WrapperMethods.getAttribute(MyAccountElements.getPhone1(), "value");
			WrapperMethods.verify_Two_Given_Text(actualvalue, phone1, "Phone1 updation is successful", "Failed to update Phone1");	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void enterPhone2(String phone2) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getPhone2(), 30);	
			WrapperMethods.click(MyAccountElements.getPhone2());
			WrapperMethods.clear(MyAccountElements.getPhone2());
			WrapperMethods.sendkeys(MyAccountElements.getPhone2(), phone2, "Phone2 is entered successfully", "Failed to enter Phone2");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		}
	}

	public static void verifyPhone2(String phone2) throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.getPhone2(), 30);					
			String actualvalue = WrapperMethods.getAttribute(MyAccountElements.getPhone2(), "value");
			WrapperMethods.verify_Two_Given_Text(actualvalue, phone2, "Phone2 updation is successful", "Failed to update Phone2");	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		}
	}

	public static void clickSaveChanges() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.clickAccountDetailsSaveChanges(), 30);					
			WrapperMethods.click(MyAccountElements.clickAccountDetailsSaveChanges(), "Clicked Save Changes", "Failed to click Save Changes");
			//WrapperMethods.verify_Text(MyAccountElements.saveChangesMessage(), "Your request was completed.", "Message Save changes is successful is displayed", "Message Save changes is successful is not displayed");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		}
	}

	public static void clickHelpIcon() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.clickHelpIcon(), 30);	
			WrapperMethods.click(MyAccountElements.clickHelpIcon(), "Clicked help icon", "Failed to clicked help icon");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
	public static void getHelpIconMenu() throws IOException{
		try {

			List<String> expectedSubmenus = Arrays.asList("About", "User Manual");
			List<WebElement> alllinks = WrapperMethods.findElements(MyAccountElements.helpMenus());
			List<String> acutalSubmenus = new ArrayList<String>();

			for(WebElement eachelement:alllinks) {
				acutalSubmenus.add(eachelement.getText());	
				System.out.println(acutalSubmenus);
			}

			if(acutalSubmenus.containsAll(expectedSubmenus)) 
				UMReporter.log(Status.PASS, "Expected and acutal submenus are matching for Help Icon");
			else
				UMReporter.log(Status.FAIL, "Expected and acutal submenus are not matching for Help Icon");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickHelpIconAboutLink() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.clickHelpAbout(), 30);	
			WrapperMethods.mouse_Hover(MyAccountElements.clickHelpAbout());
			WrapperMethods.click(MyAccountElements.clickHelpAbout(), "Clicked help about link", "Failed to clicked help about link");							
			WrapperMethods.verify_Two_Given_Text("About", WrapperMethods.getText(MyAccountElements.clickHelpAboutTitle()), "Expected and acutal title for about link is matching", "Expected and acutal title for about link is not matching");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void verifyHelpIconLinkAttributes(String connection, String emsversion,String sqlPatchNumber, String serverVersion, String clientVersion,String interfaceVersion,String roomWizardVersion, String kioskVersion, String masterCalendarVersion) throws IOException{
		try {
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextConnection()), connection, "Attribute Connection Successful is available", "Attribute Connection Successful is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextEMSWebVersion()), emsversion, "Attribute EMS Web Application Interface Version is available", "Attribute EMS Web Application Interface Version is missing");

			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextSQLPatchNumber()), sqlPatchNumber, "Attribute SQL Patch Number is available", "Attribute SQL Patch Number is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextServerVersion()), serverVersion, "Attribute Server Version is available", "Attribute Server Version is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextClientVersion()), clientVersion, "Attribute Client Version is available", "Attribute Client Version is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextClientSQLInterfaceVersion()), interfaceVersion, "Attribute Client SQL Interface Version is available", "Attribute Client SQL Interface Version is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextRoomWizardVersion()), roomWizardVersion, "Attribute Room Wizard SQL Interface Version is available", "Attribute Room Wizard SQL Interface Version is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextKioskVersion()), kioskVersion, "Attribute Kiosk SQL Interface Version is available", "Attribute Kiosk SQL Interface Version is missing");
			WrapperMethods.verify_Two_Given_Text(WrapperMethods.getText(MyAccountElements.getTextMasterCalendarVersion()), masterCalendarVersion, "Attribute Master Calendar SQL Interface Version is available", "Master Calendar SQL Interface Version is missing");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void clickHelpIconUserManualLink() throws IOException{
		try {
			WrapperMethods.explicitWait(MyAccountElements.clickHelpUserManual(), 30);	
			WrapperMethods.mouse_Hover(MyAccountElements.clickHelpUserManual());

			WrapperMethods.click(MyAccountElements.clickHelpUserManual(), "Clicked help user manual link", "Failed to clicked help user manual link");
			WrapperMethods.explicitWait(MyAccountElements.getTextUserManual(), 50);	
			String actualtext = WrapperMethods.getText(MyAccountElements.getTextUserManual());			
			System.out.println("actualtext: "+actualtext);
			WrapperMethods.verify_Two_Given_Text("User Guide", actualtext, "Expected and acutal title for about link is matching", "Expected and acutal title for about link is not matching");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}

	public static void getUserDetailsSubmenu() throws IOException{
		try {			
			List<String> expectedSubmenus = Arrays.asList("MyAccountSignOut");
			HomePageFunc.clickUsername();
			List<WebElement> alllinks = WrapperMethods.findElements(MyAccountElements.getUserDetailsSubmenu());
			List<String> acutalSubmenus = new ArrayList<String>();
			for(WebElement eachelement:alllinks) {				
				acutalSubmenus.add(eachelement.getText().replaceAll("\\s+", ""));				
			}
			
			if(acutalSubmenus.containsAll(expectedSubmenus)) 
				UMReporter.log(Status.PASS, "Expected and acutal submenus are matching for User Details");
			else
				UMReporter.log(Status.FAIL, "Expected and acutal submenus are not matching for User Details");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
}
