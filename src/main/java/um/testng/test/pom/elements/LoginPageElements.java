package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class LoginPageElements {	
	
	public static By enterEmailAddress() {
		return WrapperMethods.locatorValue(Locators.ID, "MainContent_UserName");
	}
	
	public static By enterPassword() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='MainContent_Password']");
	}
	
	public static By clickLogIn() {
		return WrapperMethods.locatorValue(Locators.ID, "MainContent_LoginButton");
	}
	
	public static By loginError() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//span[text()='Login failed. Invalid credentials.']");
	}
	
	public static By nonExistingEMSUserError() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//span[text()='Login failed. Invalid credentials.']");
	}
	

}
