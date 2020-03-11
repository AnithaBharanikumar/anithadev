package um.testng.test.utilities.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import um.testng.test.drivers.DriverFactory;
/**
 * <Need java doc>
 * @author HCL Automation Team
 *
 */
public class MethodDef {

  private static final Logger LOGGER = Logger.getLogger(String.class.getSimpleName());

  /**
   * Logs Fail Message into Reporter log
   * 
   * @param string
   */
  public static void failLog(String message, String string) {
    Reporter.log("<br><font color=\"red\">FAILED:" + string + "</font><br>");
    Reporter.log("<br> Error:" + message);
  }

  /**
   * Logs Pass Message into Reporter log
   * 
   * @param string
   */
  public static void passLog(String string) {
    Reporter.log("<br><font color=\"green\">PASSED:" + string + "</font>");
  }

  
  /**
   * <Need java doc>
   * 
   * @param urlString
   * @return
   */
  public static int getResponseCode(String urlString) {
    try {
      URL u = new URL(urlString);
      HttpURLConnection h = (HttpURLConnection) u.openConnection();
      h.setRequestMethod("GET");
      h.connect();
      if (h.getResponseCode() == 301 || h.getResponseCode() == 302 || h.getResponseCode() == 307) {
        String newUrl = h.getHeaderField("Location");
        u = new URL(newUrl);
        h = (HttpURLConnection) u.openConnection();
        h.setRequestMethod("GET");
        h.connect();
      }
      return h.getResponseCode();

    } catch (MalformedURLException e) {
      Reporter.log("<BR>FAILED: MalformedURLException" + e.getMessage());
      LOGGER.log(Level.INFO, e.getMessage());
      return -1;
    } catch (IOException e) {
      LOGGER.log(Level.INFO, e.getMessage());
    }
    return 0;
  }

  /**
   * <Need java doc>
   * 
   * @return
 * @throws IOException 
   */
  public static String logDriverInfo() throws IOException {
    // LOGGER.log(Level.INFO, "" + elem.keySet());
    // LOGGER.log(Level.INFO, "OS" + elem.get("OS"));
    // LOGGER.log(Level.INFO, "Platform" + elem.get("Platform"));
    // String OS = elem.get("OS");
    String result = "";
    String Platform = ConfigProvider.getConfig("Platform");
    if (Platform.equals("Desktop")) {
      result = getIP();
    } else {
      try {
        String Plat = ConfigProvider.getConfig("Device_ID");
        LOGGER.log(Level.INFO, "Device ID" + Plat);
        String[] app_dev = ConfigProp.getPropertyValue("Devices").split(",");
        for (String dev : app_dev) {
          String[] devport = dev.split("~");
          // LOGGER.log(Level.INFO, "Device Name test" + devport[1]);
          if (devport[0].equalsIgnoreCase(Plat)) {
            LOGGER.log(Level.INFO, "Device Name" + devport[1]);
            result = devport[1];
          }
        }
      } catch (Exception e) {
        LOGGER.log(Level.INFO, "*************************************" + e.getMessage());
      }
    }
    return result;
  }

  /**
   * <Need java doc>
   * 
   * @return
 * @throws IOException 
   */
  private static String getIP() throws IOException {
    WebDriver curr = DriverFactory.getCurrentDriver();
    String id = ((RemoteWebDriver) curr).getSessionId().toString();
    LOGGER.log(Level.INFO, id);
    String ip = "";
    try {
      String hub = ConfigProp.getPropertyValue("SelHost").split("/wd/hub")[0];
      LOGGER.log(Level.INFO, "HUB" + hub);
      HttpClient client = HttpClientBuilder.create().build();
      HttpGet request = new HttpGet(hub + "/grid/api/testsession?session=" + id);
      HttpResponse response = client.execute(request);
      // LOGGER.log(Level.INFO, response);
      JsonObject myjsonobject = extractObject(response);
      JsonElement urltest = myjsonobject.get("proxyId");
      // JsonElement urltest1 = myjsonobject.get("os");
      LOGGER.log(Level.INFO, urltest.getAsString());
      ip = urltest.getAsString();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ip;
  }

  /**
   * <Need java doc>
   * 
   * @param resp
   * @return
   * @throws IOException
   */
  private static JsonObject extractObject(HttpResponse resp) throws IOException {
    BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
    StringBuffer s = new StringBuffer();
    String line;
    while ((line = rd.readLine()) != null) {
      s.append(line);
    }
    rd.close();
    JsonParser parser = new JsonParser();
    JsonObject objToReturn = (JsonObject) parser.parse(s.toString());
    LOGGER.log(Level.INFO, objToReturn.toString());
    LOGGER.log(Level.INFO, objToReturn.get("proxyId").toString());
    return objToReturn;
  }

  

  
}