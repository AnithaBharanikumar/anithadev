package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import um.testng.test.alltests.Login;
import um.testng.test.utilities.framework.UMReporter;

public class LoginPage {
	
	@Test(groups = "Login", dataProvider = "GlobalTestData",priority=1,invocationCount = 1)		
	public void RBTLogin(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Login Page test");
			Login.logIn();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

}
