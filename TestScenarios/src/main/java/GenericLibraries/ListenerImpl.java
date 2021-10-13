package GenericLibraries;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public  class ListenerImpl implements ITestListener
{
	/*
	 * //@Override public void onTestSuccess(ITestResult result) {
	 * 
	 * }
	 * 
	 * public void onTestStart(ITestResult result) {
	 * 
	 * }
	 * 
	 * public void onTestSkipped(ITestResult result) {
	 * 
	 * }
	 */
	
	public void onTestFailure(ITestResult result)
	{
		//TakesScreenshot ts = (TakesScreenshot)driver;
		EventFiringWebDriver eFire = new EventFiringWebDriver(BaseTestClass.sdriver);
		
		File src = eFire.getScreenshotAs(OutputType.FILE);
		String SCREENSHOTPATH= System.getProperty("user.dir")+"//photo//"+ result.getMethod().getMethodName()+" "+JavaUtility.getSystemDateAndTime()+".png";
			
		File dest = new File(SCREENSHOTPATH);
		try
		{
			Files.copy(src, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		
		
	}
}

	

