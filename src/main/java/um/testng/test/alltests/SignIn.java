package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.SignInPageFunc;

public class SignIn {

	public static void signIn() throws IOException {
		try
		{
			SignInPageFunc home =new SignInPageFunc();
			//home.verifySignIn();			

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}


}
