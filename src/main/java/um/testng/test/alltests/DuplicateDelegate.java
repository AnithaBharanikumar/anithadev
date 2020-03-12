package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.MyAccountFunc;
import um.testng.test.pom.functions.RoomRequestFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;
import um.testng.test.utilities.framework.TestDataProvider;
/**
 * 
 * c-xpanxion-aranaswam
 * Feb 20, 2020
 * This test validates user is not able to add the same delegate name twice
 */
public class DuplicateDelegate {
	public static void duplicateDelegate() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickUsername();
			HomePageFunc.clickMyAccount();
			MyAccountFunc.clickDelegates();
			MyAccountFunc.enterDelegate(TestDataProvider.getData("delegateName"));
			MyAccountFunc.selectDelagateName();	
			MyAccountFunc.getSavedDelagate(TestDataProvider.getData("delegateName"));
			MyAccountFunc.enterDelegate(TestDataProvider.getData("delegateName"));
			MyAccountFunc.getduplicateDelagateMessage();
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
