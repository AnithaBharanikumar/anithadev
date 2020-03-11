package um.testng.test.alltests;

import java.io.IOException;

import um.testng.test.pom.functions.LogInPageFunc;
import um.testng.test.pom.functions.SignInPageFunc;

public class Login {
	
	public static void logIn() throws IOException {
		try
		{			
			//LogInPageFunc lf = new LogInPageFunc();
			//SignInPageFunc sf = new SignInPageFunc();
			//sf.verifySignIn();			
			//LogInPageFunc.verifyLoginPageLoaded();
			//LogInPageFunc.verifyLogIn();
			//SignInPageFunc sf = new SignInPageFunc();
			//sf.verifySignIn();
			//LogInPageFunc lf = new LogInPageFunc();
			//lf.verifyLoginPageLoaded();
			//lf.verifyLogIn();
					

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}

}
}
