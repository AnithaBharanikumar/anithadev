package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import um.testng.test.alltests.InvalidLoginCredentials;
import um.testng.test.utilities.framework.UMReporter;

public class LoginPage extends BaseTest{
	
	/*@Test(groups = "Login", dataProvider = "GlobalTestData",priority=1,invocationCount = 1)		
	public void RBTLogin(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Login Page test");
			InvalidLoginCredentials.logIn();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}*/
	
	@Test(groups = "Login", dataProvider = "GlobalTestData",priority=1,invocationCount = 1)		
	public void invalidLoginCredentials(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("In invalid Login credentials method");
			InvalidLoginCredentials.invalidLoginCredentials();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
}
