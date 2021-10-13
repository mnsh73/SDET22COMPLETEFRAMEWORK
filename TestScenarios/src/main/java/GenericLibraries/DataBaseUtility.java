package GenericLibraries;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;


/**
 * this class contains generic methods for reading data from database
 * @author MANISH
 *
 */
public class DataBaseUtility
{
	Connection conn = null;
	ResultSet result = null;
	Driver driverref;
	/**
	 * connection with database is established 
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void connectionToDB() throws Throwable
	{
		DriverManager.registerDriver(driverref);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
		
	}
/**
 * DB connection is closed
 * @throws Throwable 
 * @throws Throwable
 */
	public void closeDB() throws Throwable
	{
		conn.close();
	}
	/**
	 * This mehtod returns the data with respect to the column Index
	 * @param query
	 * @param columnindex
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query, int columnindex) throws Throwable
	{
		String value = null;
		result =  conn.createStatement().executeQuery(query);
		while(result.next())
		{
			value = result.getString(columnindex);
		}
		return value;
	}
	
	
	public String getDataFromDBandVerify(String query,int columnName,String expData) throws Throwable
	{
		boolean flag = false;
		result= conn.createStatement().executeQuery(query);
		while(result.next())
		{
			if (result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if (flag)
		{
			System.out.println(expData+" Data verified in DataBase");
			return expData;
		}
		else
		{
			System.out.println(expData+" Data is not Verified");
			return expData;
		}
		
	}

}
