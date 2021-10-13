package GenericLibraries;

import java.util.Date;
import java.util.Random;



public class JavaUtility 
{
	/**
	 * author @ Manish
	 */

	/**
	 * This method is generate random number to avoid duplicate
	 * @return
	 */
	public static String getRandonData()
	
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ""+ran;		
	}
	/**
	 * this method is used to generate current date
	 * @return
	 */
	public static String getCurrentDate()
	{
		Date date = new Date();
		String currentdate= date.toString();
		return currentdate;
		
	}
	public static String getSystemDateAndTime()
	{
		Date date = new Date();
		String currentdateandtime= date.toString().replaceAll(" ","_").replace(":","_");
		return currentdateandtime;
		
	}
	
}
