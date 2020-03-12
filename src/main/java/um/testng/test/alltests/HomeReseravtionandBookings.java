package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;

public class HomeReseravtionandBookings {
	public static void homeReservation() throws IOException {
		try
		{
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.verfiyReservationTem();
			HomePageFunc.verfiyMyBookings();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}
}