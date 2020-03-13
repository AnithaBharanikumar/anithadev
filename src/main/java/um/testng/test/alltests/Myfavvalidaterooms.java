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

public class Myfavvalidaterooms {
	public static void validateFavrooms() throws IOException {
		try
		{	
			SignInPageFunc login = new SignInPageFunc();	
			login.clickSignIn();			
			LogInPageFunc.verifyLogIn(ConfigProp.getPropertyValue("emailId_" + ConfigProvider.getConfig("Environment")),ConfigProp.getPropertyValue("password_" + ConfigProvider.getConfig("Environment")));
			MyAccountFunc.validateFavrooms();
			RoomRequestFunc.enterStartTime(TestDataProvider.getData("startTime"));
			RoomRequestFunc.enterEndTime(TestDataProvider.getData("endTime"));
			RoomRequestFunc.clickSearch();	
			MyAccountFunc.clickFavoriteCheckbox();
			MyAccountFunc.getCreateReservationFavoriteroom();
			HomePageFunc.clickCreateReservation();
			MyAccountFunc.validateFavrooms();
	        RoomRequestFunc.enterStartTime(TestDataProvider.getData("startTime"));
			RoomRequestFunc.enterEndTime(TestDataProvider.getData("endTime"));
			RoomRequestFunc.clickSearch();	
			MyAccountFunc.getCreateReservationFavoriteroom();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

	}


}
