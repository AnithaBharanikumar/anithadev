package um.testng.test.utilities.framework;

	import java.io.ByteArrayOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.HashSet;
	import java.util.Iterator;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.exec.CommandLine;
	import org.apache.commons.exec.DefaultExecuteResultHandler;
	import org.apache.commons.exec.DefaultExecutor;
	import org.apache.commons.exec.PumpStreamHandler;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Test {
		public static void main(String[] args) throws IOException, InterruptedException {
			
			// strCheck();
		}
	/*
	 * Old Report Deletion 
	 * Vigneswaran. S
	 */
		@SuppressWarnings("null")
		static void removeReport() throws InterruptedException {
			Date date = null;
			String lastThreeMonths = "";
			Integer month = Integer.parseInt("10");
			System.out.println("/********************************************************/");
			System.out.println("Going to flush the Reports older than :" + month + " months");
			Calendar today = Calendar.getInstance();
			String path = "cd " + System.getProperty("user.dir") + "\\custom_report\\".replace("\\\\", "\\");
			String listCommand = path + "&& dir /b ";
			List<String> removelist = new LinkedList<String>();
			String[] listFolder = executeCmd(listCommand).trim().split("Report");
			Thread.sleep(3000);
			for (String s : listFolder)
				removelist.add("Report" + s.trim());
			for (int i = month - 1; i >= 0; i--) {
				today.add(Calendar.DATE, -i);
				date = new java.sql.Date(today.getTimeInMillis());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMDD");
				lastThreeMonths = formatter.format(date);
				lastThreeMonths = "Report_" + lastThreeMonths;
				System.out.println(" sfsd:"+lastThreeMonths);
				Iterator<String> itr = removelist.iterator();
			    while (itr.hasNext()) {
					if (itr.next().contains(lastThreeMonths))
						itr.remove();
				}
				today.add(Calendar.DATE, i);
			}
			for (String fileName : removelist) {
				String deleteCmd = path + " && rmdir /s /q " + fileName;
				if(fileName.length()>7)
				executeCmd(deleteCmd);
			}
			System.out.println("/****Old Reports Cleaning Done******/");

		}

		static String executeCmd(String cmdLine) {
			CommandLine command = new CommandLine("cmd");
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
			try {
				command.addArgument("/c");
				command.addArgument(cmdLine);
				DefaultExecutor executor = new DefaultExecutor();
				executor.setStreamHandler(streamHandler);
				executor.execute(command);
			} catch (Exception e) {
			}
			return (outputStream.toString());
		}

		void browser() throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "./resources/drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://psdevapp1.odyssey.worldaccess.com:11000/psp/crmdev/?cmd=login");
			driver.manage().window().maximize();
			driver.findElementById("userid").clear();
			driver.findElementById("userid").sendKeys("APALANISAMY");
			driver.findElementById("pwd").sendKeys("Allianz57");
			driver.findElementByName("Submit").click();
			Thread.sleep(2000);

			// WebElement
			// topFrame=driver.findElementByXPath("//*[@name='UniversalHeader']");
			// WebElement menuFrame=driver.findElementByName("NAV");
			// WebElement mainMenuFrame=driver.findElementByName("TargetContent");

			// driver.switchTo().frame(topFrame);
			// driver.switchTo().frame(menuFrame);

			driver.findElementByXPath("//*[@class='PTPAGELETBODY']//a[@title='Manage Customer Account']").click();
			Thread.sleep(2000);
			WebElement menuFrame = driver.findElementByName("NAV");
			driver.switchTo().frame(menuFrame);
			driver.findElementByXPath("//*[@class='PTPAGELETBODY']//a[text()='Policy']").click();
			Thread.sleep(2000);
			driver.close();

		}

		static void strCheck() {
			String str1 = "Report_202001240614", str2 = "Report_202001";
			if (str1.contains(str2))
				System.out.println("Not matched");
		}
	

}
