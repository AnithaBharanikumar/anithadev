package um.testng.test.pom.functions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import um.testng.test.drivers.DriverFactory;
import um.testng.test.pom.elements.LoginPageElements;
import um.testng.test.pom.elements.SignInPageElements;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;
import um.testng.test.utilities.framework.Encryption;
import um.testng.test.utilities.framework.UMReporter;
import um.testng.test.utilities.framework.WrapperMethods;

public class SignInPageFunc {
	static String browserName;
	public SignInPageFunc() throws IOException
	{
		DriverFactory.driverInit();
	}


	public void verifySignIn(String emailAddr, String password) throws IOException{
		try {
			String url="";
			WebDriver driver = DriverFactory.getCurrentDriver();
			//driver.manage().deleteAllCookies();			
			url=ConfigProp.getPropertyValue("RBT_URL_"+ConfigProvider.getConfig("Environment"));
			browserName=ConfigProvider.getConfig("Browser").toUpperCase();
			System.out.println("Browser--"+ConfigProvider.getConfig("Browser").toUpperCase());		
			driver.manage().window().maximize();
			driver.get(url);

			WrapperMethods.explicitWait(SignInPageElements.clickSignIn(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(SignInPageElements.clickSignIn(), "SignIn button is clicked", "SignIn button is not clicked");			
			WrapperMethods.explicitWait(LoginPageElements.enterEmailAddress(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(LoginPageElements.enterEmailAddress(), emailAddr, "User name is entered in the login page", "User name is not entered in the login page");		
			password=Encryption.decrypt(password);					
			WrapperMethods.sendkeys(LoginPageElements.enterPassword(), password, "Password is entered in the login page", "Password is not entered in the login page");
			WrapperMethods.click(LoginPageElements.clickLogIn(), "LogIn button is clicked", "LogIn button is not clicked");		
			Thread.sleep(15000);	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());

		} 
	}

	public void clickSignIn() throws IOException{
		try {
			String url="";
			WebDriver driver = DriverFactory.getCurrentDriver();
			//driver.manage().deleteAllCookies();			
			url=ConfigProp.getPropertyValue("RBT_URL_"+ConfigProvider.getConfig("Environment"));
			browserName=ConfigProvider.getConfig("Browser").toUpperCase();
			System.out.println("Browser--"+ConfigProvider.getConfig("Browser").toUpperCase());		
			driver.manage().window().maximize();
			driver.get(url);

			WrapperMethods.explicitWait(SignInPageElements.clickSignIn(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.click(SignInPageElements.clickSignIn(), "SignIn button is clicked", "SignIn button is not clicked");			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());

		} 
	}
	public void verifyLogin(String emailAddr, String password) throws IOException{
		try {				
			WrapperMethods.explicitWait(LoginPageElements.enterEmailAddress(), Integer.parseInt(ConfigProp.getPropertyValue("maxWaitTime")));
			WrapperMethods.sendkeys(LoginPageElements.enterEmailAddress(), emailAddr, "User name is entered in the login page", "User name is not entered in the login page");		
			password=Encryption.decrypt(password);					
			WrapperMethods.sendkeys(LoginPageElements.enterPassword(), password, "Password is entered in the login page", "Password is not entered in the login page");
			WrapperMethods.click(LoginPageElements.clickLogIn(), "LogIn button is clicked", "LogIn button is not clicked");		
			Thread.sleep(15000);		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.FAIL, e.getMessage());

		} 
	}



}


