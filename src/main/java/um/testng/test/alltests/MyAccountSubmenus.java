package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.MyAccountFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;

/**
 * 
 * c-xpanxion-aranaswam
 * Mar 03, 2020
 * Validation of submenus in MyAccount section
 */
public class MyAccountSubmenus {
	
	public static void myAccountSubmenus() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();			
			login.verifySignIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickUsername();
			HomePageFunc.clickMyAccount();			
			MyAccountFunc.verifyMyAccountSubmenus();
			MyAccountFunc.verifyMyAccountDetailsEnabled();
			MyAccountFunc.verifyGreenNotch();
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
