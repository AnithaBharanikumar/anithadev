package um.testng.test.utilities.framework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

public class UIDashboardUpdate {

	public static void updateUIDashboard(int passCount, int failCount, String htmlReportName) {
		
		System.out.println("pass count and Fial count in UI Dashboard updates "+passCount + " Fail Count "+failCount);
		String endURL = "http://10.191.254.24:3000/api/automationReports";
		
		String project = ConfigProp.getPropertyValue("project");
		System.out.println("getAutomatbaleTestCases "+project);
		
		String subProject = ConfigProp.getPropertyValue("subProject");
		System.out.println("getAutomatbaleTestCases "+subProject);
		
		String getAutomatbaleTestCases = ConfigProp.getPropertyValue("automatable");
		int automatable = Integer.parseInt(getAutomatbaleTestCases);
		System.out.println("getAutomatbaleTestCases "+automatable);
		
		String getAutomatedCount = ConfigProp.getPropertyValue("automated");
		int automated = Integer.parseInt(getAutomatedCount);
		System.out.println("getAutomatedCount "+getAutomatedCount);
		
		String noOfTesters = ConfigProp.getPropertyValue("manualtestcases");
		int testers = Integer.parseInt(noOfTesters);
		System.out.println("testers "+testers);
		
		String validAutomationScripts = ConfigProp.getPropertyValue("validAutomationScript");
		int validScripts = Integer.parseInt(validAutomationScripts);
		System.out.println("validAutomationScripts "+validAutomationScripts);
		
		String percenatgeCompleted = ConfigProp.getPropertyValue("validAutomationScriptPercentage");
		int percentageCompletion = Integer.parseInt(percenatgeCompleted);
		System.out.println("percenatgeCompleted "+percenatgeCompleted);
		
		String date = new SimpleDateFormat("yyyy-MM-dd-hh:mm").format(new Date());
		
		 String appiumRunMode = ConfigProp.getPropertyValue("Run_Appium");
		 String platform = "";
		 if("yes".equalsIgnoreCase(appiumRunMode))
		 {
			 platform = "Mobile";
		 } else {
			 platform = "Desktop";
		 }

		JSONObject json = new JSONObject();
		json.put("project", project);
		json.put("subProject", subProject);
		json.put("automatable", automatable);
		json.put("automated", automated);
		json.put("results", "");
		json.put("platformExcuted", platform);
		json.put("testers", testers);
		json.put("validAutomationScript", validScripts);
		json.put("validAutomationScriptPercentage", percentageCompletion);
		json.put("processedDate", date);
		json.put("report", htmlReportName);
		json.put("pass", passCount);
		json.put("fail", failCount);

		String jsonData = json.toString();

		try {
			HttpPost post = new HttpPost(endURL);
			post.setHeader("Content-Type", "application/json");
			post.setHeader("Accept", "application/json");
			post.setHeader("X-Stream", "true");

			HttpResponse response = null;
			String line = "";
			StringBuffer result = new StringBuffer();
			post.setEntity(new StringEntity(jsonData));
			HttpClient client = HttpClientBuilder.create().build();
			response = client.execute(post);
			System.out.println("Post parameters : " + jsonData);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while updating the Server "+e.getMessage());
		}

	}

}
