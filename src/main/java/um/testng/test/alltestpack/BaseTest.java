package um.testng.test.alltestpack;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import jcifs.smb.SmbException;
import um.testng.test.drivers.DriverFactory;
import um.testng.test.utilities.framework.ConfigProp;
import um.testng.test.utilities.framework.ConfigProvider;
import um.testng.test.utilities.framework.DBConnection;
import um.testng.test.utilities.framework.ExcelReader;
import um.testng.test.utilities.framework.FrameworkUtilities;
import um.testng.test.utilities.framework.GridConfig;
import um.testng.test.utilities.framework.HipChatHelper;
import um.testng.test.utilities.framework.MailHelper;
import um.testng.test.utilities.framework.ReadAndReplace;
import um.testng.test.utilities.framework.TestDataProvider;
import um.testng.test.utilities.framework.UMReporter;
import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.MessageFormat;

public class BaseTest {

	private static final Logger LOGGER = Logger.getLogger(String.class.getSimpleName()); 
	static final String MSG = "Warning log message";
	UMReporter classReport;
	static int passCount = 0;
	static int failCount = 0;

	@BeforeSuite(alwaysRun = true)
	@Parameters({"ProjectName"})
	public void presteps(ITestContext ctx,String projectName) throws IOException, InterruptedException {
		// DB Query creation 	
		String historyPrerequisite = ConfigProp.getPropertyValue("History_Prerequisite");
		if("yes".equalsIgnoreCase(historyPrerequisite)){
			String dbQuery = ExcelReader.queryGenerator();
			String jsonValue=DBConnection.jsonGenerator(dbQuery);
			ReadAndReplace.updateXML(jsonValue);
		}
		System.out.println("The project Name is "+projectName );
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		LOGGER.log(Level.INFO, "Executing Pre-steps of the Test Suite");
		UMReporter.initReport(suiteName,projectName);		
		String appiumRunMode = ConfigProp.getPropertyValue("Run_Appium");
		LOGGER.log(Level.INFO, () -> "The appium run node --- "+appiumRunMode);
		if("yes".equalsIgnoreCase(appiumRunMode)){
			try{
				GridConfig.launchNodes();
			}catch(Exception e){
				LOGGER.log(Level.WARNING, MSG, e);
			}
		}
		
		//Old Report Cleaning process
		FrameworkUtilities.removeOldReport();
	}

	@AfterSuite(alwaysRun = true)
	public void poststeps(ITestContext ctx) throws IOException {
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		LOGGER.log(Level.INFO, "Executing Post-steps of the Test Suite");
		LOGGER.log(Level.INFO,() -> "The mail over view contents is "+UMReporter.mailOverview);
		String subject =mailSubject();
		String htmlReportName = UMReporter.htmReport;
		
		UMReporter.endReport(suiteName);
		String hipchatPrerequisite = ConfigProp.getPropertyValue("Hipchat_Prerequisite");
		if("yes".equalsIgnoreCase(hipchatPrerequisite))
			hipChat(suiteName);
		String mailPrerequisite = ConfigProp.getPropertyValue("Mail_Prerequisite");
		if("yes".equalsIgnoreCase(mailPrerequisite))
			eMail(suiteName,subject);
		
		String path = UMReporter.reportPath;
        System.out.println("UMreporter Path to transfer the files " + path);
        String replacePath = "";
        if (path.startsWith("./custom_report/")) {
               replacePath = path.replace("./custom_report/", "/custom_report/").trim();
               System.out.println("Replacement Path " + replacePath);
        } else {
               System.out.println("Path doesnt starts with . " + path);
               replacePath = path; // will not work
        }
        
        String dashboard = ConfigProp.getPropertyValue("uiDashboardUpdate");
        System.out.println("Enable dashboard - "+dashboard);
        if(dashboard.equalsIgnoreCase("Yes"))
        {
        	System.out.println("Dashboard update is enabled ***");
    		//UIDashboardUpdate.updateUIDashboard(passCount, failCount, htmlReportName);
            System.out.println("updated  the dashboard ***** ");
        	
        	//String localPath = System.getProperty("user.dir") + replacePath + "\\UM_Execution_Result_Desktop_FS.htm";
            String localPath = System.getProperty("user.dir") + replacePath + "\\" +htmlReportName ;
            System.out.println("Final Local Path before i sent ****** " + localPath);
           
            try {
                   FileCopy.transferReportToVMLocation(localPath,htmlReportName);
            } catch (SmbException e) {
                   System.out.println("SMB Exception occured in Post Steps Base Test class --- " + e.getMessage());
            }
        } else {
        	System.out.println("Dashboard update is not enabled.");
        }
        FrameworkUtilities.updateExtentReport(System.getProperty("user.dir") + replacePath + "\\UM_Execution_Resultwss_Desktop.htm");
        WrapperMethods.killProcesses("geckodriver");
	}



	// Dear Future Logesh, 
	//      You have written below set of lines for some reason and to the best in optimized way.
	//      Don't spend more time on it looking over again.
	// Regards, Logesh 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String mailSubject(){
		Map<String, Map<String, Map<String, ArrayList<Map<String, Boolean>>>>> ms = UMReporter.mailOverview;
		Iterator<?> co = ms.entrySet().iterator();
		int testcases =0;
		StringBuilder sb = new StringBuilder("<table border ='1'><tr bgcolor='DarkGray'><th>Group</th><th>Scenario Name</th><th>Description</th><th>Browser</th><th>Status</th></tr>");
		while(co.hasNext()){
			Map.Entry pair = (Map.Entry)co.next();
			//System.out.println(pair.getKey() + " = " + pair.getValue());
			Map<String, Map<String, ArrayList<Map<String, Boolean>>>> methods = (Map<String, Map<String, ArrayList<Map<String, Boolean>>>>) pair.getValue();
			//System.out.println("The methods size is "+methods.size());
			int methodSize = 0;
			Iterator<?> mo = methods.entrySet().iterator();
			String className  = pair.getKey().toString();
			sb.append("<tr> <td rowspan='MethodSize'> " +className+"</td>");
			boolean firstDesc = true;
			while(mo.hasNext()){
				++testcases;
				Map.Entry mPair = (Map.Entry)mo.next();
				//System.out.println(mPair.getKey() + " = " + mPair.getValue());
				String methodName  = mPair.getKey().toString();
				//				sb.append("<td rowspan='StatusSize'> " +methodName+"</td>");
				if(firstDesc){
					sb.append("<td rowspan='StatusSize'> " +methodName+"</td>");
					firstDesc= false;
				}else{
					sb.append("<tr> <td rowspan='StatusSize'> " +methodName+"</td>");
				}		
				Map<String, ArrayList<Map<String, Boolean>>> desc = (Map<String, ArrayList<Map<String, Boolean>>>) mPair.getValue();
				//System.out.println("The desc size is "+desc.size());
				Iterator<?> dO = desc.entrySet().iterator();			
				while(dO.hasNext()){
					Map.Entry dPair = (Map.Entry)dO.next();
					//	System.out.println(dPair.getKey() + " = " + dPair.getValue());
					String description  = dPair.getKey().toString();
					sb.append("<td rowspan='StatusSize'> " +description+"</td>");				
					ArrayList<Map<String, Boolean>> statusList = (ArrayList<Map<String, Boolean>>) dPair.getValue();
					//System.out.println("The statusList size is "+statusList.size());
					int statusSize = statusList.size();
					methodSize +=statusSize; 
					boolean firstStatus = true;
					for (Map<String, Boolean> map : statusList) {
						Iterator<?> statusValues = map.entrySet().iterator();
						while(statusValues.hasNext()){							
							Map.Entry browserValue = (Map.Entry) statusValues.next();
							//	System.out.println(browserValue.getKey() + " = " + browserValue.getValue());
							String browser = browserValue.getKey().toString();
							String status = browserValue.getValue().toString();
							if(firstStatus){
								sb.append(countStatus(browser, status));
								firstStatus = false;
							}else{
								sb.append("<tr>"+countStatus(browser, status));
							}							
						}
					}
					//					System.out.println("regrx----"+sb.toString().replaceAll("\\bStatusSize\\b", Integer.toString(statusSize)));
					String ss = sb.toString().replaceAll("\\bStatusSize\\b", Integer.toString(statusSize));
					sb.delete(0, sb.length());
					sb.append(ss);
				}
			}
			String ss = sb.toString().replaceAll("\\bMethodSize\\b", Integer.toString(methodSize));
			sb.delete(0, sb.length());
			sb.append(ss);
		}
		String tableOverview ="<table style='border:1px solid black;'>"
				+ " <tr> <th colspan='2' bgcolor='#80bfff'>Overview</th></tr>"
				+ " <tr> <td>Number of scripts executed </td><td width='40' align='center'><strong> "+testcases+"</td></tr>"
				+ " <tr> <td>Number of scripts passed </td><td width='40' align='center' style='color:#33cc33'><strong>"+passCount+"</td></tr>"
				+ " <tr> <td>Number of scripts failed </td><td width='40' align='center' style='color:#ff4d4d'> <strong>"+failCount+"</td></tr>"
				+ "</table>";
		String environment_Details = "<table style='border:1px solid black;''><tbody><tr>"
				+ "<td style='width: 7px;'bgcolor='#80bfff'> Environment </td>"
				+ "<td style='width:10px;'>"+ UMReporter.env+"</td></tr></tbody></table>";
		String headerContent = "Hi Team, <br><br> Please find the scenario details and it's status for current execution, <br>";
		String footerContent = "**And for detailed report status, refer the attachment. <br> <br>Automation Team ";
		return headerContent+tableOverview+"<br>"+environment_Details+"<br>"+sb+"</table> <br>"+footerContent;
	}

	public static String countStatus(String browser,String status){
		if("true".equalsIgnoreCase(status)){
			++passCount;
			return "<td> " +browser+"</td> <td bgcolor='#66BB6A'> <center> <Strong> Pass </strong> </center></td> </tr>";
		}else{
			++failCount;
			return "<td> " +browser+"</td> <td bgcolor='#EF5350'> <center> <strong> Fail </strong> </center> </td> </tr>";
		}		
	}


	public static void hipChat(String suiteName) {
		LOGGER.log(Level.INFO, "Inside Hip chat Messenging");
		String apiKey = ConfigProp.getPropertyValue("APIKey");
		HipChatHelper hipchat = new HipChatHelper(apiKey);
		String path = UMReporter.reportPath;
		String toUser = ConfigProp.getPropertyValue("ToUser");

		if ("Desktop".equalsIgnoreCase(suiteName)) {
			String statusMsg =  "Automation Desktop Test Results: Pass:" + UMReporter.passCountD + " :: FAIL:" + UMReporter.failCountD;
			hipchat.messageUser(toUser, statusMsg, true, MessageFormat.TEXT);
			hipchat.shareFile(toUser, statusMsg, path + "/UM_Execution_Result_Desktop.htm");
		} else {
			String statusMsg =  "Automation Mobile Test Results: Pass:" + UMReporter.passCountM + " :: FAIL:" + UMReporter.failCountM;
			hipchat.messageUser(toUser, statusMsg, true, MessageFormat.TEXT);
			hipchat.shareFile(toUser, statusMsg, path + "/UM_Execution_Result_Mobile.htm");
		}
	}

	public static void eMail(String suiteName,String subject) {
		LOGGER.log(Level.INFO, "Inside eMailing API");
		String path = UMReporter.reportPath;
        String htmlReportName = UMReporter.htmReport;

		if ("Desktop".equalsIgnoreCase(suiteName)) {
			MailHelper.Send(subject, path + "/" +htmlReportName, "", "");
		} else {
			MailHelper.Send(subject, path + "/UM_Execution_Result_Mobile.htm", "", "");
		}
	}

	@BeforeClass(alwaysRun = true)
	public void initParentRep(ITestContext ctx) {
		LOGGER.log(Level.INFO, "============= Before Class ================");
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		String testName = ctx.getCurrentXmlTest().getName();

		if("Browser".equalsIgnoreCase(testName)){
			testName="";
		}
		String className = this.getClass().getSimpleName();
		classReport = new UMReporter(className /*+ " <span class='device-name'> "+testName+"</span>"*/, "Regression Test Set", suiteName);
	}

	@AfterClass(alwaysRun = true)
	public void endParentRepo(ITestContext ctx) {
		LOGGER.log(Level.INFO, "============= After Class ================");
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		System.out.println("============= After Class ================"+suiteName);
//				classReport.endParent(suiteName);
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod(alwaysRun = true)
	public void setUp(Object[] testArgs, ITestContext ctx, Method method) {
		String testName = method.getName();
		LOGGER.log(Level.INFO, () -> "Executing test: " + testName);
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		ConfigProvider.init((Map<String, String>) testArgs[0]);
		TestDataProvider.init((Map<String, String>) testArgs[1]);
		String className = this.getClass().getSimpleName();
		UMReporter.initTest(className,testName,suiteName);
//		String platform = ConfigProvider.getConfig("Platform").toUpperCase();
		//		UMReporter.assignCatogory(platform);
	}

	@AfterMethod(alwaysRun = true)
	public void tearUp(ITestContext context, Method method) throws URISyntaxException, IOException, InterruptedException {
		LOGGER.log(Level.INFO, "============= After Method ================");
		String className=this.getClass().getSimpleName();
		String methodName = method.getName();
		String browser = ConfigProvider.getConfig("Browser");
		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		if ("Desktop".equalsIgnoreCase(suiteName)) {           
			if(!ConfigProvider.getConfig("Res_Height").isEmpty() ){
				browser = browser +" "+ConfigProvider.getConfig("Res_Height")+"*"+ConfigProvider.getConfig("Res_Width");
			}
		}
		UMReporter.addMailContents(className,methodName,ConfigProvider.getConfig("Description"), browser);
		classReport.appendParent();
		if(!(browser.equalsIgnoreCase("firefox")))
			DriverFactory.driverCleanUp();
		 else
			 WrapperMethods.killProcesses("firefox");
		 
		System.out.println("Driver closed");
		ConfigProvider.endThreadLocal();
		TestDataProvider.endThreadLocal();

	}

	@DataProvider(name = "globalTestData", parallel = true)
	public static Object[][] GlobalTestData(Method method, ITestContext context) throws IOException {
		LOGGER.log(Level.INFO, "============= Into DataProvider ================");
		ArrayList<Map<String, String>> browArray ;
		ArrayList<Map<String, String>> DataArray ;

		String className = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();
		browArray = ExcelReader.getBrowsersDeviceComb(context.getCurrentXmlTest().getName(), className, methodName);
		DataArray = ExcelReader.getTestDataIterator(methodName, className);
		LOGGER.log(Level.INFO, () -> "============= "+browArray);
		LOGGER.log(Level.INFO, () -> "============= "+DataArray);
		int i = 0;
		int count = browArray.size() * DataArray.size();
		LOGGER.log(Level.INFO, () -> count + "Combinations");

		Object[][] test = new Object[count][2];

		for (Map<String, String> elem : browArray) {
			for (Map<String, String> entryD : DataArray) {
				test[i][0] = elem;
				test[i][1] = entryD;
				i++;
			}
		}
		return test;
	}
}
