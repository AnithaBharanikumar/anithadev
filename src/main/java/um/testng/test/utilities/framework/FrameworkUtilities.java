package um.testng.test.utilities.framework;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import jcifs.Config;
import um.testng.test.drivers.DriverFactory;



public class FrameworkUtilities {

	/**
	 * 
	 * Nov 12, 2019 magesh-d To click an element using java script
	 */
	public static void clickElement_JavaScript(WebElement element, String pc, String fc) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			UMReporter.log(Status.PASS, pc);
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, fc);
			Assert.assertTrue(false);
		}
	}

	/**
	 * 
	 * Nov 12, 2019 magesh-d To click an element using java script
	 */
	public static void clickElement_JavaScript(By by, String pc, String fc) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();

		try {
			WebElement element = driver.findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			UMReporter.log(Status.PASS, pc);
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, fc);
			Assert.assertTrue(false);
		}
	}

	/**
	 * 
	 * Nov 22, 2019 Durga To send text to an element using java script
	 */
	public static void sendKeys_JavaScript(By by, String value, String pc, String fc) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();

		try {
			WebElement element = driver.findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value='" + value + "');", element);
			UMReporter.log(Status.PASS, pc);
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, fc);
			Assert.assertTrue(false);
		}
	}

	/**
	 * 
	 * Nov 13, 2019 magesh-d To click element and info in report
	 */
	public static void click_Info(By by, String pc, String fc) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			WebElement element = driver.findElement(by);
			element.click();
			UMReporter.log(Status.INFO, pc);
		} catch (Exception e) {
			UMReporter.log(Status.FAIL, fc);
		}
	}

	/**
	 * 
	 * Nov 11, 2019 magesh-d To add or minus date from current date
	 */
	public static String addOrMinusdayToCurrentDate(int days, String dateFormat) throws IOException {
		Date date = null;
		String strDate = null;
		try {
			Calendar today = Calendar.getInstance();
			today.add(Calendar.DATE, days);
			date = new java.sql.Date(today.getTimeInMillis());
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			strDate = formatter.format(date);
			System.out.println(strDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return strDate;
	}

	/**
	 * c-xpanxion-dvasantha Jan 29, 2019 void This Method Will return the Current
	 * Date
	 */
	public static String currentDate(String format) {
		String currentDate = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			Date date = new Date();
			currentDate = dateFormat.format(date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return currentDate;
	}
	
	/**
	 * Jan, 2020 
	 * Sindhu M
	 * To get Current Time
	 * @return 
	 */
	public static String getCurrentTime(String format) {
		String currentTime = "";
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf =new SimpleDateFormat(format);
			currentTime =sdf.format(cal.getTime());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return currentTime;
	}
	/**
	 * 
	 * Nov 12, 2019 magesh-d To switch alert and accept
	 * 
	 * @throws IOException
	 */
	public static void alertAccept() throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			driver.switchTo().alert().accept();
			UMReporter.log(Status.INFO, "Accept pop up is accepted");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			UMReporter.log(Status.ERROR, "Accept pop up is not accepted");
		}

	}

	/**
	 * 
	 * Nov 15, 2019 magesh-d To wait for alert to be displayed and accept
	 */
	public static void waitForAlertAndAccept(int waitTime) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			int i = 0;
			while (i < waitTime) {
				Thread.sleep(1000);
				try {
					UMReporter.log(Status.PASS, "Accepted Alert Message :" + driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();
					break;
				} catch (NoAlertPresentException e) {
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * Nov 25, 2019 magesh-d To wait for alert to be displayed and accept
	 */
	public static void waitForAlertAndDismiss(int waitTime) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			int i = 0;
			while (i < waitTime) {
				Thread.sleep(1000);
				try {
					driver.switchTo().alert().dismiss();
					break;
				} catch (NoAlertPresentException e) {
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Nov 19, 2019 magesh-d To wait for alert to be displayed and verify alert
	 * message
	 */
	public static void waitForAlertAndVerifyAlertMsg(int waitTime, String expectedMessage) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			int i = 0;
			while (i < waitTime) {
				Thread.sleep(1000);
				try {
					Alert alert = driver.switchTo().alert();
					String actualMessage = alert.getText();
					System.out.println("actual message" + actualMessage);
					if (actualMessage.toLowerCase().contains(expectedMessage.toLowerCase())) {
						UMReporter.log(Status.INFO, "Alert message '" + expectedMessage + "' has been displayed");
						alert.accept();
					} else {
						UMReporter.log(Status.FAIL,
								"Alert message '" + expectedMessage
										+ "' has not been displayed and following alert message '" + actualMessage
										+ "' has been displayed");
					}
					break;
				} catch (Exception ex) {
					i++;
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	/**
	 * 
	 * Nov 19, 2019 Vigneswaran S To wait for alert to be displayed and dismiss alert
	 * message
	 */
	public static String waitForAlertMsgAndDismiss(int waitTime) throws IOException {
		String actualMessage = "";
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			int i = 0;
			while (i < waitTime) {
				Thread.sleep(1000);
				try {
					Alert alert = driver.switchTo().alert();
					actualMessage = alert.getText();
					UMReporter.log(Status.INFO, "Alert displayed and the message is : " + actualMessage);
					alert.dismiss();
					break;
				} catch (Exception e) {
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return actualMessage;

	}
	/**
	 * 
	 * Nov 19, 2019 magesh-d To wait for alert to be displayed and verify alert
	 * message
	 */
	public static String waitForAlertAndGetAlertMsg(int waitTime) throws IOException {
		String actualMessage = "";
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			int i = 0;
			while (i < waitTime) {
				Thread.sleep(1000);
				try {
					Alert alert = driver.switchTo().alert();
					actualMessage = alert.getText();
					UMReporter.log(Status.INFO, "Alert displayed and the message is : " + actualMessage);
					alert.accept();
					break;
				} catch (Exception e) {
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return actualMessage;

	}

	/**
	 * 
	 * Nov 27, 2019 magesh-d To verify alert text and accept without wait
	 */
	public static void waitForAlertAndVerifyAlertMsg(String expectedMessage) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			Alert alert = driver.switchTo().alert();
			String actualMessage = alert.getText();
			System.out.println("actual message" + actualMessage);
			if (actualMessage.toLowerCase().contains(expectedMessage.toLowerCase())) {
				UMReporter.log(Status.INFO, "Alert message '" + expectedMessage + "' has been displayed");
				alert.accept();
			} else {
				UMReporter.log(Status.FAIL, "Alert message '" + expectedMessage
						+ "' has not been displayed.Following alert '" + actualMessage + "' has been displayed");
				throw new Exception(actualMessage);
			}
		} catch (Exception ex) {
			UMReporter.log(Status.FAIL, ex.getMessage());
			System.out.println(ex.getMessage());
			Assert.assertTrue(false);
		}
	}

	/**
	 * 
	 * Nov 15, 2019 magesh-d To wait for new window to get opened
	 */
	public static void waitForNewWindow(int waitTime) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			int i = 0;
			while (i < waitTime) {
				Thread.sleep(1000);
				Set<String> set = driver.getWindowHandles();
				if (set.size() > 1)
					break;
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * Nov 19, 2019 magesh-d To switch to new window
	 */
	public static void switchToNewWindow(int waitTime, String parentWindow) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			waitForNewWindow(waitTime);
			Set<String> windowsSet = driver.getWindowHandles();
			System.out.println(windowsSet.size());
			for (String s : windowsSet) {
				if (!(s.equalsIgnoreCase(parentWindow))) {
					driver.switchTo().window(s);
					driver.manage().window().maximize();
					// LoginPage.loginIntoPeoplesoftAfterWindowSwitch();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Nov 24, 2019 Vigneswaran To switch to back to parent window
	 */
	public static void switchToParentWindow(String parentID) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			driver.close();
			driver.switchTo().window(parentID);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Nov 24, 2019 Vigneswaran To switch to back to default frame
	 */
	public static void switchToDefaultFrame() throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * Nov 19, 2019 magesh-d To wait for invisibility of processing... msg
	 */


	/**
	 * 
	 * Nov 25, 2019 Vigneswaran To switch to new window using title
	 */
	public static void switchToNewWindowUsingTitle(int waitTime, String parentTitle) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			System.out.println("Inside switch method");
			waitForNewWindow(waitTime);
			Set<String> windowsSet = driver.getWindowHandles();
			for (String s : windowsSet) {

				System.out.println("Switching to the child windows and verifying titles....");
				driver.switchTo().window(s);
				String title = driver.getTitle();
				System.out.println("Child window ID :" + title);
				if (!(title.equalsIgnoreCase(parentTitle))) {
					System.out.println("Child window title found..");
					driver.manage().window().maximize();
					
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Nov 19, 2019 magesh-d To wait for element until it gets enabled
	 */
	public static void waitForElementToBeEnabled(By by, int waitTime) throws IOException {
		WebDriver driver = DriverFactory.getCurrentDriver();
		int i = 0;
		try {
			while (i < waitTime) {
				//WrapperMethods.waitForElement(1);
				WebElement ele = driver.findElement(by);
				try {
					String disabled = ele.getAttribute("disabled");
					i++;
				}

				catch (Exception ex) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void fillDateField(By by, String value, String pc, String fc) throws IOException {
		try {
			WrapperMethods.clear(by);
			if (value.equalsIgnoreCase("CurrentDate"))
				WrapperMethods.sendkeys(by, FrameworkUtilities.currentDate("MM/dd/yyyy"), pc, fc);
			else if (value.equalsIgnoreCase("FutureDate"))
				WrapperMethods.sendkeys(by, FrameworkUtilities.addOrMinusdayToCurrentDate(1, "MM/dd/yyyy"), pc, fc);
			else
				WrapperMethods.sendkeys(by, value, pc, fc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	/**
	 * 
	 * Nov 19, 2019 magesh-d To remove com.entent text from extent report
	 */
	public static void updateExtentReport(String reportPath) throws IOException {
		try {
			Path path = Paths.get(reportPath);
			Charset charset = StandardCharsets.UTF_8;

			String content = new String(Files.readAllBytes(path), charset);
			content = content.replaceAll("com.aventstack.extentreports.", " ");
			content = content.replaceAll("[\\s]{1}[A-Za-z]{10}[@]{1}[A-Za-z0-9]{1,20}", "");
			Files.write(path, content.getBytes(charset));
			System.out.println("updated report");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * Nov 27, 2019 Durgalakshmi To wait for element until it could be clickable
	 */
	public static void waitForElementToBeClickable(By by, int waitTime) throws IOException {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Dec 3, 2019 magesh-d To check element is displayed or not
	 */
	public static boolean isElementPresent(By by) throws IOException {
		boolean check = false;
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement ele = driver.findElement(by);
			if (ele.isDisplayed())
				check = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return check;
	}

	/**
	 * 
	 * Dec 20, 2019 magesh-d To click the element and not to throw exception in case
	 * element is not clicked
	 */
	public static void click(By by) throws IOException {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement ele = driver.findElement(by);
			ele.click();
		} catch (Exception e) {

		}
	}


	public static void pageRefresh(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			driver.findElement(by).sendKeys(Keys.F5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void closeWindow() {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void pasteFilePath() throws IOException {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public static void closeBrowser() {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Method to scroll into webElement
	 * Vigneswaran S
	 */
	public static void scrollUsingJavaScriptAndClick(By ele,Integer sec,String pc,String fc) throws InterruptedException, IOException {
		int i=0;
		WebDriver driver = DriverFactory.getCurrentDriver();
		System.out.println("Scrolling using JS..");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		System.out.println("In SCrolling method.");
		boolean isClickable = false;
		while (!isClickable && i<sec) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,15)");
			try {
				driver.findElement(ele).click();
				isClickable = true;
				System.out.println("Element found and clicked after scrolling..");
			} catch (Exception e) {
				isClickable = false;
				i++;
			}
		}
		if(i>=sec)
			UMReporter.log(Status.FAIL, fc);
		else
			UMReporter.log(Status.PASS, pc);
	}
	/*
	 * Method to scroll into webElement
	 * Vigneswaran S
	 */
	public static void waitForElementAndClick(By ele,Integer sec,String pc,String fc) throws InterruptedException, IOException {
		int i=0;
		WebDriver driver = DriverFactory.getCurrentDriver();
		boolean isClickable = false;
		while (!isClickable && i<sec) {
			try {
				driver.findElement(ele).click();
				isClickable = true;
				System.out.println("Element found and clicked..");
			} catch (Exception e) {
				isClickable = false;
				i++;
			}
		}
		if(i>=sec)
			UMReporter.log(Status.FAIL, fc);
		else
			UMReporter.log(Status.PASS, pc);
	}

	public static void main(String[] args) throws IOException
	{
		updateExtentReport("");
	}
	
	/*
	 * Old Report Deletion 
	 * Author : Vigneswaran. S
	 */
		@SuppressWarnings("null")
		public static void removeOldReport() throws InterruptedException {
			if(ConfigProp.getPropertyValue("DeleteOldReports").equalsIgnoreCase("Yes")) {
			try {
			Date date = null;
			String lastThreeMonths = "";
			Integer month = Integer.parseInt(ConfigProp.getPropertyValue("RetainReportsTillDays"));
			System.out.println("/********************************************************/");
			System.out.println("Going to flush the Reports older than :" + month + " days");
			System.out.println("Please be Patient, it may take a minute or two...");
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
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				lastThreeMonths = formatter.format(date);
				lastThreeMonths = "Report_" + lastThreeMonths;
				Iterator<String> itr = removelist.iterator();
			    while (itr.hasNext()) {
					if (itr.next().contains(lastThreeMonths))
						itr.remove();
				}
				today.add(Calendar.DATE, i);
			}int count=0;
			for (String fileName : removelist) {
				String deleteCmd = path + " && rmdir /s /q " + fileName;
				if(fileName.length()>7) {
					count++;
				executeCmd(deleteCmd);
				}
			}
			System.out.println("Number of Old Reports Deleted:"+count);
			System.out.println("/****Old Reports Cleaning Done******/");
			}
			catch(Exception e) {
				System.out.println("Old Reports are not deleted..");
			}
			}
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
		
		public static void scrollUsingJavaScript(By by) throws InterruptedException, IOException {
            WebDriver driver = DriverFactory.getCurrentDriver();
            System.out.println("Scrolling using JS..");
            ((JavascriptExecutor) driver)
         .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
     Thread.sleep(4000);
     boolean isClickable = false;
     while(!isClickable) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,15)");
            try {
                   driver.findElement(by).click();
                   isClickable=true;
                   System.out.println("Element found and clicked after scrolling..");
            }
            catch(Exception e) {
                   isClickable = false;
            }
     }
     }

}
