package um.testng.test.pom.functions;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import um.testng.test.alltestpack.SignInPage;
import um.testng.test.pom.elements.LoginPageElements;
import um.testng.test.utilities.framework.ConfigProp;
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
		
	public void verifyLogIn(String emailAddr, String password) throws IOException{
		try {
			System.out.println("Inside verify login func...");
			//SignInPageFunc sign = new SignInPageFunc();
			//sign.verifySignIn();			
			WrapperMethods.explicitWait(LoginPageElements.enterEmailAddress(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(LoginPageElements.enterEmailAddress(), emailAddr, "User name is entered in the login page", "User name is not entered in the login page");
			WrapperMethods.sendkeys(LoginPageElements.enterPassword(), password, "Password is entered in the login page", "Password is not entered in the login page");
			WrapperMethods.click(LoginPageElements.clickLogIn(), "LogIn button is clicked", "LogIn button is not clicked");		
			Thread.sleep(3000);
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		UMReporter.log(Status.FAIL, e.getMessage());

	} 

	}

}
