package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;

public class HomeMenu {
	public static void homeMenu() throws IOException {
		try
		{
			SignInPageFunc Home=new SignInPageFunc();
			Home.verifySignIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			HomePageFunc.clickHome();
			HomePageFunc.clickCreateReservation();
			HomePageFunc.clickMyEvents();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

}

}
