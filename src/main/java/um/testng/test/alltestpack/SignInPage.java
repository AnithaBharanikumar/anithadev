package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import um.testng.test.alltests.SignIn;
import um.testng.test.utilities.framework.UMReporter;

public class SignInPage extends BaseTest {
	
	@Test(groups = "SignIn", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void RBTSignIn(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {			
			SignIn.signIn();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

}
