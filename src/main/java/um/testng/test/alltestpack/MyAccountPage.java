package um.testng.test.alltestpack;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import um.testng.test.alltests.ActAsDelegate;
import um.testng.test.alltests.AddDelegate;
import um.testng.test.alltests.Delegates;
import um.testng.test.alltests.DeleteDelegate;
import um.testng.test.alltests.DuplicateDelegate;
import um.testng.test.alltests.HelpIconAboutLink;
import um.testng.test.alltests.HelpIconMenu;
import um.testng.test.alltests.HelpIconUserManualLink;
import um.testng.test.alltests.InvalidDelegate;
import um.testng.test.alltests.MyAccountSubmenus;
import um.testng.test.alltests.MyFavDefault;
import um.testng.test.alltests.MyFavoriteDeleteroom;
import um.testng.test.alltests.MyFavoriteinvalid;
import um.testng.test.alltests.Myfavduplicate;
import um.testng.test.alltests.Myfavrooms;
import um.testng.test.alltests.NoDelegateText;
import um.testng.test.alltests.UpdateAccountDetails;
import um.testng.test.alltests.UserDetailsSubmenu;
import um.testng.test.alltests.ValidateAccountDetailsEmail_Name;
import um.testng.test.alltests.VerifyAccountDetails;
import um.testng.test.utilities.framework.UMReporter;

public class MyAccountPage extends BaseTest{

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void delegates(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside delegates method");
			Delegates.delegates();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void addDelegate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside delegates method");
			AddDelegate.addDelegate();


		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1, dependsOnMethods="addDelegate")		
	public void actAsDelegate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside act as delegates method");
			ActAsDelegate.actAsDelegate();			

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void deleteDelegate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside delete delegate method");
			DeleteDelegate.deleteDelegate();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void duplicateDelegate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside add duplicate delegate method");
			DuplicateDelegate.duplicateDelegate();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void noDelegateText(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside no delegate text method");
			NoDelegateText.noDelegateText();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void invalidDelegate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside invalid delegate check method");
			InvalidDelegate.invalidDelegate();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void myAccountSubmenus(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside myaccount submenu method");
			MyAccountSubmenus.myAccountSubmenus();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyAccountDetails(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside account details method");
			VerifyAccountDetails.verifyAccountDetails();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void validateAccountDetailsEmail_Name(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside validate email and username method");
			ValidateAccountDetailsEmail_Name.validateAccountDetailsEmail_Name();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void updateAccountDetails(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside update account details method");
			UpdateAccountDetails.updateAccountDetails();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void helpIconMenu(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside Help Icon Menu method");
			HelpIconMenu.helpIconMenu();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void helpIconAboutLink(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside Help Icon About method");
			HelpIconAboutLink.helpIconAboutLink();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void helpIconUserManualLink(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside Help Icon User Manual method");
			HelpIconUserManualLink.helpIconUserManualLink();;

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void userDetailsSubmenu(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Inside user details submenu method");
			UserDetailsSubmenu.userDetailsSubmenu();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}
	//Anitha's code

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyFavdef(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("My Fav Rooms");
			MyFavDefault.verifyFavdef();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}


	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyFavroom(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("My Fav Rooms name");
			Myfavrooms.verifyFavroom();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)		
	public void verifyFavduplicate(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("My fav room duplicate");
			Myfavduplicate.verifyFavduplicate();

		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)
	public void verifyFavinvalid(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Validate Favorite rooms invalid entry");
			MyFavoriteinvalid.verifyFavinvalid();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Test(groups = "MyAccounts", dataProvider = "GlobalTestData",priority=0,invocationCount = 1)
	public void  verifyFavDelete(Map<String, String> elem, Map<String, String> etest, ITestContext ctx) throws IOException {

		try {
			System.out.println("Delete Favorite Rooms");
			MyFavoriteDeleteroom.verifyFavDelete();
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, "Failed due to unexpected exception: " + e.getMessage());
		}
	}


}
