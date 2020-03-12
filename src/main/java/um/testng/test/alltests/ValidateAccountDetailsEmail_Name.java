package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.MyAccountFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;

/**
 * 
 * c-xpanxion-aranaswam
 * Mar 04, 2020
 * Validate the email and username in MyAccount Details section
 */
public class ValidateAccountDetailsEmail_Name {
	
	public static void validateAccountDetailsEmail_Name() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickUsername();
			HomePageFunc.clickMyAccount();			
			MyAccountFunc.validateEmail();
			MyAccountFunc.validateName();
			HomePageFunc.clickUsername();
			HomePageFunc.clickSignOut();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

}


}
