package um.testng.test.pom.functions;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import um.testng.test.alltestpack.SignInPage;
import um.testng.test.pom.elements.LoginPageElements;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.Encryption;
import um.testng.test.utilities.framework.UMReporter;
import um.testng.test.utilities.framework.WrapperMethods;

public class LogInPageFunc {
	
	public static void verifyLoginPageLoaded() throws IOException{
		try {			
				System.out.println("Login page Loaded");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());
		} 
	}
		
	public static void verifyLogIn(String emailAddr, String password) throws IOException{
		try {
			System.out.println("Inside verify login func...");
			WrapperMethods.explicitWait(LoginPageElements.enterEmailAddress(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(LoginPageElements.enterEmailAddress(), emailAddr, "User name is entered in the login page", "User name is not entered in the login page");		
			password=Encryption.decrypt(password);					
			WrapperMethods.sendkeys(LoginPageElements.enterPassword(), password, "Password is entered in the login page", "Password is not entered in the login page");
			WrapperMethods.click(LoginPageElements.clickLogIn(), "LogIn button is clicked", "LogIn button is not clicked");		
			Thread.sleep(3000);
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		UMReporter.log(Status.FAIL, e.getMessage());

	} 

	}
	
	public static void verifyInvalidLoginCredentials(String emailAddr, String password) throws IOException{
		try {
			System.out.println("Inside verify login func...");
			WrapperMethods.explicitWait(LoginPageElements.enterEmailAddress(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(LoginPageElements.enterEmailAddress(), emailAddr, "User name is entered in the login page", "User name is not entered in the login page");
			WrapperMethods.sendkeys(LoginPageElements.enterPassword(), password, "Password is entered in the login page", "Password is not entered in the login page");
			WrapperMethods.click(LoginPageElements.clickLogIn(), "LogIn button is clicked", "LogIn button is not clicked");
			
			WrapperMethods.explicitWait(LoginPageElements.loginError(), 30);
			String actualtext = WrapperMethods.getText(LoginPageElements.loginError());
			System.out.println("Login error: "+actualtext);
			WrapperMethods.verify_Two_Given_Text(actualtext, "Login failed. Invalid credentials.", "Errror message displayed for bad credentials is matching", "Errror message displayed for bad credentials is not matching");		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		UMReporter.log(Status.FAIL, e.getMessage());

	} 

	}


}
