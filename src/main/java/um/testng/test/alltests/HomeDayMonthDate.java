package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.HomePageFunc;
import um.testng.test.pom.functions.SignInPageFunc;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;

public class HomeDayMonthDate {
	

	
		public static void verifyDayMonthDate() throws IOException {
			try
			{
				SignInPageFunc Home=new SignInPageFunc();
				Home.verifySignIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
				HomePageFunc.validateDay();
				HomePageFunc.validateMonth();
				HomePageFunc.validateDate();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				throw e;
			}
		}

	}


