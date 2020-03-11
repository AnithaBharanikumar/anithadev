package um.testng.test.utilities.framework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.aventstack.extentreports.Status;

public class DBUtility {
	
	/**
	 * 
	 * Dec 16, 2019
	 * magesh-d
	 * To build db connection
	 */
	public static Connection createDBConnection(String hostName,String port,String serviceName,String dbUserName,String dbPassword) throws IOException
	{
		Connection conn=null;
		try
		{
			String connectionString ="jdbc:oracle:thin:"+dbUserName+"/"+dbPassword+"@//"+hostName+":"+port+"/"+serviceName;
			System.out.println(connectionString);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(connectionString);
			System.out.println("connected");
			UMReporter.log(Status.PASS, "Db Connection has been established");
		}
		catch(Exception e)
		{
			UMReporter.log(Status.FAIL, "Db Connection has not been established.So test data has not been retrieved");
			System.out.println("Connect is not established");
			Assert.assertTrue(false);
		}
		return conn;
		
	}
	
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Jan 7, 2019
	 * ResultSet
	 * To retrieve result set by inputing connection and query without pass and fail comments
	 */
	public static ResultSet retrieveQuery(Connection conn,String query) throws IOException
	{
		ResultSet rs=null;
		try
		{
		      Statement st = conn.createStatement();
		      rs = st.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
		
	}
	
	
	/**
	 * 
	 * Dec 17, 2019
	 * magesh-d
	 * To retrieve colum value from result set
	 */
	public static String retrieveColumnValue(ResultSet rs,String columnDesc) throws IOException
	{
		String value="";
		try
		{
		      if(rs!=null)
		      {
		    	  while(rs.next())
		    	  {
		    		  value=rs.getString(1);
		    		  break;
		    	  }
		      }
		      else
		      {
		    	  UMReporter.log(Status.FAIL, "No '"+columnDesc+"' found with the db query");
		    	  Assert.assertTrue(false);
		      }
		      
		      if(!(value.equalsIgnoreCase("")))
		    	  UMReporter.log(Status.PASS, columnDesc+" has been fetched from db and "+columnDesc+" is '"+value+"'");
		      else
		      {
		    	  UMReporter.log(Status.FAIL, columnDesc+" has been fetched from db and "+columnDesc+" is null");
		    	  Assert.assertTrue(false);
		      }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			UMReporter.log(Status.FAIL, columnDesc+" column not found in the given table");
	    	Assert.assertTrue(false);
		}
		return value;
		
	}
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Jan 7, 2019
	 * ResultSet
	 * To retrieve result set by inputing connection and query
	 */
	public static ResultSet retrieveQuery(Connection conn,String query,String pc,String fc) throws IOException
	{
		ResultSet rs=null;
		try
		{
		      Statement st = conn.createStatement();
		      rs = st.executeQuery(query);
		      UMReporter.log(Status.PASS,pc);
		}
		catch(Exception e)
		{
			UMReporter.log(Status.FAIL,fc);
			e.printStackTrace();
		}
		return rs;
		
	}
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Jan 7, 2019
	 * void
	 * To update the db values
	 */
	public static void updateQuery(Connection conn,String query,String pc,String fc) throws IOException
	{
		try
		{
		      Statement st = conn.createStatement();
		      st.executeUpdate(query);
		      UMReporter.log(Status.PASS,pc);
		}
		catch(Exception e)
		{
			UMReporter.log(Status.PASS,fc);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Feb 12, 2019
	 * void
	 * To update the db values
	 */
	public static void updateQuery(Connection conn,String query) throws IOException
	{
		try
		{
		      Statement st = conn.createStatement();
		      st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * c-xpanxion-mdhandapa
	 * Jan 7, 2019
	 * void
	 * To close db connection
	 */
	public static void closeConnection(Connection conn) throws IOException
	{
		try
		{
			conn.close();
			System.out.println("db connection is closed");
		}
		catch(Exception e)
		{
			System.out.println("db connection is not closed");
			e.printStackTrace();
		}
		
	}
	
	public static String retrieveValueFromDB(String inputRequired) throws IOException
	{
		String value="";
		try
		{
			String dbUserName=ConfigProp.getPropertyValue("DB_UserName");
			String dbPassword=Encryption.decrypt(ConfigProp.getPropertyValue("DB_Password"));
			String hostName=ConfigProp.getPropertyValue("HostName");
			String port=ConfigProp.getPropertyValue("Port");
			String serviceName=ConfigProp.getPropertyValue("ServiceName_"+ConfigProvider.getConfig("Environment"));
			Connection conn=DBUtility.createDBConnection(hostName, port, serviceName, dbUserName, dbPassword);
			ResultSet rs=DBUtility.retrieveQuery(conn, ConfigProp.getPropertyValue(inputRequired));
			value=DBUtility.retrieveColumnValue(rs, inputRequired);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
		
	}
	
	public static void main(String[] args) throws IOException
	{
		createDBConnection("10.118.101.31", "1521", "crmuat.odyssey.worldaccess.com", "bramesh", "Allianz456");
	}
	
}
