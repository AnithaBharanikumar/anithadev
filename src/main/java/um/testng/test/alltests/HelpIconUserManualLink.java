package um.testng.test.alltests;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import um.testng.test.pom.elements.MyAccountElements;
import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.MyAccountFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;
import um.testng.test.utilities.framework.TestDataProvider;

/**
 * 
 * c-xpanxion-aranaswam
 * Mar 10, 2020
 * Verify clicking user manual link redirects the user to help content 
 */
public class HelpIconUserManualLink {
	
	public static void helpIconUserManualLink() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			MyAccountFunc.clickHelpIcon();
			MyAccountFunc.clickHelpIconUserManualLink();			
			//HomePageFunc.clickUsername();
			//HomePageFunc.clickSignOut();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

}


}
