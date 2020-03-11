package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.MyAccountFunc;
import um.testng.test.pom.functions.RoomRequestFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;
import um.testng.test.utilities.framework.TestDataProvider;
/**
 * 
 * c-xpanxion-aranaswam
 * Mar 10, 2020
 * Verify the options displayed in delegates section 
 */
public class Delegates {
	public static void delegates() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();			
			login.verifySignIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickUsername();
			HomePageFunc.clickMyAccount();
			MyAccountFunc.clickDelegates();
			MyAccountFunc.verifyDelegateGreenNotch();
			MyAccountFunc.isAddDelegateAvailable();
			MyAccountFunc.isYourSavedDelegatesAvailable();
			MyAccountFunc.noDelagateText();
			//MyAccountFunc.enterDelegate(TestDataProvider.getData("delegateName"));
			//MyAccountFunc.selectDelagateName();	
			//MyAccountFunc.getSavedDelagate(TestDataProvider.getData("delegateName"));
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
