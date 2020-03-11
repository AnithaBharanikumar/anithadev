package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import um.testng.test.alltests.ActAsDelegate;
import um.testng.test.utilities.framework.UMReporter;

public class HomePage extends BaseTest{
	
	@Test(groups = "Home", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void switchToDelegateMode(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Home Page test");			
			ActAsDelegate.actAsDelegate();
			
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

}
