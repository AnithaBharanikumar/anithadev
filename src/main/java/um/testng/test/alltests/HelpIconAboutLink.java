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
 * Mar 09, 2020
 * Validation of About help icon link aand the attributes displayed
 */
public class HelpIconAboutLink {
	
	public static void helpIconAboutLink() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			MyAccountFunc.clickHelpIcon();
			MyAccountFunc.clickHelpIconAboutLink();			
			MyAccountFunc.verifyHelpIconLinkAttributes(TestDataProvider.getData("connection"),TestDataProvider.getData("EMSVersion"), TestDataProvider.getData("SQL Patch Number"),TestDataProvider.getData("Server Version"),TestDataProvider.getData("Client Version"),TestDataProvider.getData("SQL Interface Version"),TestDataProvider.getData("Room Wizard SQL Interface Version"),TestDataProvider.getData("Kiosk SQL Interface Version"),TestDataProvider.getData("Master Calendar SQL Interface Version"));
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
