package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class MyAccountElements {
		
	public static By clickHelpIcon() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//i[@class='fa fa-question-circle']");		
	}
	
	public static By helpMenus() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='help-icon']/ul/li");
	}
	
	public static By clickHelpAbout() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='help-icon']/ul/li[1]/a");
	}
	
	public static By clickHelpAboutTitle() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//h1[text()='About '])[1]");
	}
	
	public static By getTextConnection() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Connection Successful']");
	}
	
	public static By getTextEMSWebVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='EMS Web Application Interface Version']");
	}
	
	public static By getTextSQLPatchNumber() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='SQL Patch Number']");
	}
	
	public static By getTextServerVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Server Version']");
	}
	
	public static By getTextClientVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Client Version']");
	}
	
	public static By getTextClientSQLInterfaceVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Client SQL Interface Version']");
	}
	
	public static By getTextRoomWizardVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Room Wizard SQL Interface Version']");
	}
	
	public static By getTextKioskVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Kiosk SQL Interface Version']");
	}
	
	public static By getTextMasterCalendarVersion() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//td[text()='Master Calendar SQL Interface Version']");
	}
	
	public static By clickHelpUserManual() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "User Manual");
	}
	
	public static By getTextUserManual() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h1[text()='EMS Web App User Guide']");
	}

	public static By clickAccountDetails() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='account-tabs']/li[1]/a");
	}

	public static By getLabelTimeZone() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//label[text()='Time Zone']");
	}

	public static By getTimeZone() {
		return WrapperMethods.locatorValue(Locators.ID, "edit-timezones");
	}

	public static By getLabelEmail() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//label[text()='Email Address']");
	}
	public static By getEmail() {
		return WrapperMethods.locatorValue(Locators.NAME, "emailAddress");
	}

	public static By getLabelName() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//label[@for='username']");
	}
	
	public static By getName() {
		return WrapperMethods.locatorValue(Locators.NAME, "username");
	}
	
	public static By saveChangesMessage() {
		return WrapperMethods.locatorValue(Locators.CLASS_NAME, "message");
	}


	public static By getLabelPhone1() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//label[text()='Phone 1']");
	}
	
	public static By getPhone1() {
		return WrapperMethods.locatorValue(Locators.NAME, "phone");
	}

	public static By getLabelPhone2() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//label[text()='Phone 2']");
	}
	public static By getPhone2() {
		return WrapperMethods.locatorValue(Locators.NAME, "fax");
	}

	public static By clickAccountDetailsSaveChanges() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//button[text()='Save Changes'])[1]");
	}

	public static By clickDelegates() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@href='#delegateContainer']");
	}

	public static By searchDelegate() {
		return WrapperMethods.locatorValue(Locators.ID, "delegate-search");
	}

	public static By searchDelegateText() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@role='presentation']//div[1]");
	}

	public static By selectDelegate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='tt-suggestion tt-selectable']");
	}
	
	public static By textAddNewDelegate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='Add New Delegate']");
	}
	public static By textYourSavedDelegates() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='Your Saved Delegates']");
	}

	public static By getSavedDelegate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='delegate-grid']");
	}
	public static By deleteDelegate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//i[contains(@class,'fa fa-times-circle')])[1]");		
	}
	public static By getAllDelegates() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='delegate-grid']/div/div[2]");		
	}

	public static By noDelegateText() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='delegate-grid']/div");		
	}

	public static By myAccountSubmenus() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//i[@class='fa fa-question-circle']");		
	}
	
	public static By getUserDetailsSubmenu() {
		return WrapperMethods.locatorValue(Locators.ID, "user-menu-dropdown");		
	}
	
	public static By clickMyFav() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='account-tabs']/li[4]/a");
	}
	
	public static By myfavAdd() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='Add New Favorite Room']");
	}
	
	public static By myfavAddText() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='Add New Favorite Room']/following-sibling::p");
	}
	
	public static By filterButton() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//button[@role='button']");
	}
	
	public static By myfavSearchbox() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//input[@placeholder='Find by room name']");
	}
	
	public static By myfavSection() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='Your Saved Favorite Rooms']");
	}
	
	public static By myfavnorooms() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//div[contains(@class,'col-xs-12 grid-text-center')])[3]");
	}
	
	public static By myfavavarooms() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='col-sm-2 col-sm-3 hidden-xs mobile-wrap-text grid-text']");
	}
	
	public static By deletefavroom() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//i[contains(@class,'fa fa-times-circle')]");
	}
	
	public static By searchaddfavroom() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='tt-suggestion tt-selectable']");
	}
	
	public static By searchduplicatetextMyfav() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='delegate-typeahead-notfound']"); 
	}
	
	


}
