package um.testng.test.alltests;

import java.io.IOException;
/**
 * 
 * c-xpanxion-aranaswam
 * Mar 12, 2020
 * This test validates user is not able to add the same delegate name twice
 */

import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.TestDataProvider;

public class NonExistingEMSUser {
	
	public static void nonExistingEMSUser() throws IOException {
		try
		{			
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();
			LogInPageFunc.verifynonExistingEMSUser(TestDataProvider.getData("emailid"), TestDataProvider.getData("password"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

}
}
