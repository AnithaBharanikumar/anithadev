package um.testng.test.alltests;

import java.io.IOException;

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
 * Mar 03, 2020
 * Verify all the fields in  account details is editable and save changes is updating the modification. 
 */
public class UpdateAccountDetails {
	
	public static void updateAccountDetails() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickUsername();
			HomePageFunc.clickMyAccount();			
			MyAccountFunc.selectTimeZone(TestDataProvider.getData("timezone"));
			MyAccountFunc.enterEmail(TestDataProvider.getData("email"));
			MyAccountFunc.enterName(TestDataProvider.getData("name"));
			MyAccountFunc.enterPhone1(TestDataProvider.getData("phone1"));
			MyAccountFunc.enterPhone2(TestDataProvider.getData("phone2"));
			MyAccountFunc.clickSaveChanges();
			MyAccountFunc.verifyEmail(TestDataProvider.getData("email"));
			MyAccountFunc.verifyName(TestDataProvider.getData("name"));
			MyAccountFunc.verifyPhone1(TestDataProvider.getData("phone1"));
			MyAccountFunc.verifyPhone2(TestDataProvider.getData("phone2"));			
			MyAccountFunc.verifyTimeZone(TestDataProvider.getData("timezone"));				
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
