package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class SignInPageElements {
	
	public static By clickSignIn() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='login-sso-div']/div/button");
	}

}
